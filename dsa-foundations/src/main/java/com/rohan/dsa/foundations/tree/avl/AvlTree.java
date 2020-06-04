package com.rohan.dsa.foundations.tree.avl;

/**
 * AVL tree is self balancing binary tree. Difference of height of left or right subtree
 * cannot be greater than one.
 * <p>
 * There are four different use cases to insert into AVL tree
 * left left - needs ones right rotation
 * left right - needs one left and one right rotation
 * right left - needs one right and one left rotation
 * right right - needs one left rotation
 * <p>
 * Follow rotation rules to keep tree balanced.
 * <p>
 * At every node we will also keep height of the tree so that we don't
 * have to recalculate values again.
 * <p>
 * Runtime complexity to insert into AVL tree is O(logn).
 * <p>
 * References
 * http://en.wikipedia.org/wiki/AVL_tree
 * http://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 */
public class AvlTree {

    private AvlTreeNode root;

    public AvlTreeNode leftRotate(AvlTreeNode rootNode) {
        AvlTreeNode newRootNode = rootNode.right;
        rootNode.right = newRootNode.left;
        newRootNode.left = rootNode;
        rootNode.height = updateHeight(rootNode);
        newRootNode.height = updateHeight(newRootNode);
        return newRootNode;
    }

    public AvlTreeNode rightRotate(AvlTreeNode rootNode) {
        AvlTreeNode newRootNode = rootNode.left;
        rootNode.left = newRootNode.right;
        newRootNode.right = rootNode;
        rootNode.height = updateHeight(rootNode);
        newRootNode.height = updateHeight(newRootNode);
        return newRootNode;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private AvlTreeNode insert(AvlTreeNode root, int data) {

        if (root == null) {
            return new AvlTreeNode(data);
        }

        // Do a binary search tree insertion
        if (data >= root.data) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
        }

        int balanceFactor = getBalance(root.left, root.right);
        if (balanceFactor > 1) {
            AvlTreeNode leftChildOfRootLeft = root.left.left;
            AvlTreeNode rightChildOfRootLeft = root.left.right;
            if (height(leftChildOfRootLeft) >= height(rightChildOfRootLeft)) {
                /*
                       Z (2, 0) <== root
                      /
                     Y (1, 0)
                    /
                   X (0, 0)

                   rootLeft = Y
                   leftChildOfRootLeft = X
                   rightChildOfRootLeft = null
                   After right rotation:-
                               Y (1, 1)
                              / \
                      (0, 0) X   Z (0, 0)
                 */
                root = rightRotate(root);
            } else {
                /*
                       Z (2, 0) <== root
                      /
                     X (0, 1)
                      \
                       Y (0, 0)

                   rootLeft = X
                   leftChildOfRootLeft = null
                   rightChildOfRootLeft = Y
                 */
                root.left = leftRotate(root.left);
                /*
                    After left rotation:-
                           Z (2, 0) <== root
                          /
                         Y (1, 0)
                        /
                       X (0, 0)

                   rootLeft = Y
                   leftChildOfRootLeft = X
                   rightChildOfRootLeft = null
                 */
                root = rightRotate(root);
            }
        } else if (balanceFactor < -1) {
            AvlTreeNode leftChildOfRootRight = root.right.left;
            AvlTreeNode rightChildOfRootRight = root.right.right;

            if (height(rightChildOfRootRight) >= height(leftChildOfRootRight)) {
               /*
                       X (0, 2) <== root
                         \
                           Y (0, 1)
                             \
                               Z (0, 0)
                   rootRight = Y
                   leftChildOfRootRight = null
                   rightChildOfRootRight = Z
                   After left rotation:-
                               Y (1, 1)
                              / \
                      (0, 0) X   Z (0, 0)
                 */
                root = leftRotate(root);
            } else {
                /*
                       X (0, 2) <== root
                         \ (R)
                          Z (1, 0)
                         / (L)
                        Y (0, 0)

                   rootRight = Z
                   leftChildOfRootRight = Y
                   rightChildOfRootRight = null
                 */
                root.right = rightRotate(root.right);
                /*
                    After right rotation:-
                       X (0, 2) <== root
                         \
                           Y (0, 1)
                             \
                               Z (0, 0)

                   rootRight = Y
                   leftChildOfRootRight = null
                   rightChildOfRootRight = Z
                 */
                root = leftRotate(root);
            }
        } else {
            root.height = updateHeight(root);
        }

        return root;
    }

    private static int updateHeight(AvlTreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private int getBalance(AvlTreeNode left, AvlTreeNode right) {
        return height(left) - height(right);
    }

    private static int height(AvlTreeNode node) {
        return node == null ? 0 : node.height;
    }

    private void preOrder(AvlTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        AvlTree avlTree = new AvlTree();

        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */

        // Expected: 30 20 10 25 40 50
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        avlTree.preOrder(avlTree.root);
    }
}
