package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.node.BinaryNode;

public class BinaryTree {
    private BinaryNode root;

    public void insert(int data) {
        BinaryNode newNode = new BinaryNode(data);
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<BinaryNode> queue = new Queue<>();
        queue.enqueue(root);

        BinaryNode present;
        while (!queue.isEmpty()) {
            present = queue.dequeue();
            if (present.getLeft() == null) {
                present.setLeft(newNode);
                break;
            }
            if (present.getRight() == null) {
                present.setRight(newNode);
                break;
            }

            queue.enqueue(present.getLeft());
            queue.enqueue(present.getRight());
        }
    }

    public void remove(int data) {
        if (isBlank()) {
            throw new IllegalStateException("Tree is blank");
        }

        // Search for the node to be deleted using level order traversal
        Queue<BinaryNode> queue = new Queue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            final BinaryNode first = queue.dequeue();
            if (first.getValue() == data) {
                BinaryNode deepest = getDeepestNode();
                first.setValue(deepest.getValue());
                deleteDeepestNode();
                break;
            }

            if (first.getLeft() != null) {
                queue.enqueue(first.getLeft());
            }

            if (first.getRight() != null) {
                queue.enqueue(first.getRight());
            }
        }
    }

    private BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new Queue<>();
        queue.enqueue(root);
        BinaryNode node = null;
        while (!queue.isEmpty()) {
            node = queue.dequeue();
            if (node.getLeft() != null) {
                queue.enqueue(node.getLeft());
            }

            if (node.getRight() != null) {
                queue.enqueue(node.getRight());
            }
        }
        return node;
    }

    /**
     * http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/9-BinTree/heap-delete.html
     */
    private void deleteDeepestNode() {
        Queue<BinaryNode> queue = new Queue<>();
        queue.enqueue(root);
        BinaryNode prev = null, present;
        while (!queue.isEmpty()) {
            present = queue.dequeue();
            prev = present;

            // Farthest Right, when last node has complete binary tree
            if (present.getLeft() == null) {
                prev.setRight(null);
                return;
            } else if (present.getRight() == null) {
                present.setLeft(null);
                return;
            }

            queue.enqueue(present.getLeft());
            queue.enqueue(present.getRight());
        }
    }

    public boolean search(int data) {
        Queue<BinaryNode> queue = new Queue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            BinaryNode first = queue.dequeue();
            if (first.getValue() == data) {
                return true;
            }
            if (first.getLeft() != null) {
                queue.enqueue(first.getLeft());
            }
            if (first.getRight() != null) {
                queue.enqueue(first.getRight());
            }
        }

        return false;
    }

    public void delete() {
        root = null;
    }

    public boolean isBlank() {
        return root == null;
    }

    // Traversals

    // VLR
    public static void preOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root);
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    //LVR
    public static void inOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root);
        inOrder(root.getRight());
    }

    public static void postOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root);
    }

    public void levelOrder() {
        Queue<BinaryNode> queue = new Queue<>();
        queue.enqueue(root);
        BinaryNode first = null;
        while (!queue.isEmpty()) {
            first = queue.dequeue();
            BinaryNode leftChild = first.getLeft();
            BinaryNode rightChild = first.getRight();
            if (leftChild != null) {
                queue.enqueue(leftChild);
            }
            if (rightChild != null) {
                queue.enqueue(rightChild);
            }
            System.out.print(first);
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        //Create a blank Tree
        BinaryTree tree = new BinaryTree();


        //Insert 10 nodes in the tree
        System.out.println("Inserting 10 nodes to tree");
        for (int i = 1; i <= 10; i++)
            tree.insert(i * 10);


        System.out.println("\nLevel-order of tree:");
        tree.levelOrder();
        System.out.println();

        System.out.println("\nPre-order of tree:");
        tree.preOrder(tree.root);
        System.out.println();


        System.out.println("\nPost-order of tree:");
        tree.postOrder(tree.root);
        System.out.println();


        System.out.println("\nIn-order of tree:");
        tree.inOrder(tree.root);
        System.out.println();


        System.out.println("\nSearching node 50 in the tree...");
        tree.search(50);


        System.out.println("\nSearching node 500 in the tree...");
        tree.search(500);


        System.out.println("\nDeleting node having value-5 in the tree...");
        tree.remove(5);


        System.out.println("\nDeleting node having value-50 in the tree...");
        tree.remove(50);
        tree.levelOrder();

/*        System.out.println("\n\nDeleting node having value-10 in the tree...");
        tree.remove(10);
        tree.levelOrder();

        System.out.println("\n\nDeleting node having value-80 in the tree...");
        tree.remove(80);
        tree.levelOrder();

        System.out.println("Deleting the entire Tree");
        tree.delete();*/
    }
}
