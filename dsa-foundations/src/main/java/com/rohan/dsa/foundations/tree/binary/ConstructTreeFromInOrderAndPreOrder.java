package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;

/**
 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 * Test cases:
 * Empty tree
 * One node tree
 * All left side tree
 * All right side tree
 * Mixed tree
 * Full tree
 * complete tree
 * <p>
 * <p>
 * References: https://www.youtube.com/watch?v=W9irlUOf6lI
 * https://www.techiedelight.com/construct-binary-tree-from-inorder-preorder-traversal/
 */
public class ConstructTreeFromInOrderAndPreOrder {

    public TreeNode createTree(int[] inOrder, int[] preOrder) {
        return createTreeHelper(inOrder, preOrder, 0, inOrder.length - 1, 0, preOrder.length - 1);
    }

    private TreeNode createTreeHelper(int[] inOrder, int[] preOrder,
                                      int inOrderStart, int inOrderEnd,
                                      int preOrderStart, int preOrderEnd) {

        if (inOrderStart > inOrderEnd || preOrderStart > preOrderEnd) {
            return null;
        }

        // Get the location
        int rootData = preOrder[preOrderStart];
        int rootIndex = -1;
        for (int i = inOrderStart; i <= inOrderEnd; i++) {
            if (rootData == inOrder[i]) {
                rootIndex = i;
                break;
            }
        }

        // Taking lots of variable for clarification
        int leftInOrderStart = inOrderStart;
        int leftInOrderEnd = rootIndex - 1;

        int leftPreOrderStart = preOrderStart + 1;
        int leftPreOrderEnd = leftInOrderEnd - leftInOrderStart + leftPreOrderStart;
        int rightPreOrderStart = leftPreOrderEnd + 1;
        int rightPreOrderEnd = preOrderEnd;

        int rightInOrderStart = rootIndex + 1;
        int rightInOrderEnd = inOrderEnd;

        TreeNode root = new TreeNode(rootData);
        root.left = createTreeHelper(inOrder, preOrder, leftInOrderStart, leftInOrderEnd,
                leftPreOrderStart, leftPreOrderEnd);

        root.right = createTreeHelper(inOrder, preOrder, rightInOrderStart, rightInOrderEnd,
                rightPreOrderStart, rightPreOrderEnd);

        return root;
    }


    public static void main(String[] args) {
/*        int[] preOrder = {1, 2, 4, 8, 9, 10, 11, 5, 3, 6, 7};
        int[] inOrder = {8, 4, 10, 9, 11, 2, 5, 1, 6, 3, 7};*/

        int[] inOrder = {4, 2, 5, 1, 8, 6, 9, 3, 7};
        int[] preOrder = {1, 2, 4, 5, 3, 6, 8, 9, 7};

        TreeNode root = new ConstructTreeFromInOrderAndPreOrder().createTree(inOrder, preOrder);
        System.out.println(root);
    }

}
