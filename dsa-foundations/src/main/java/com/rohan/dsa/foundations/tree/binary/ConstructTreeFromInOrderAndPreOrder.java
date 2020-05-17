package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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
 * <p>
 * <p>
 * // TODO
 * Using hashMap strategies
 */
public class ConstructTreeFromInOrderAndPreOrder {

    /**
     * This approach is equation based
     */
    private static class Technique1 {

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

            // InOrder
            int leftInOrderStart = inOrderStart;
            int leftInOrderEnd = rootIndex - 1;
            int rightInOrderStart = rootIndex + 1;
            int rightInOrderEnd = inOrderEnd;

            // PreOrder
            int leftPreOrderStart = preOrderStart + 1;
            int leftPreOrderEnd = leftInOrderEnd - leftInOrderStart + leftPreOrderStart;
            int rightPreOrderStart = leftPreOrderEnd + 1;
            int rightPreOrderEnd = preOrderEnd;

            TreeNode root = new TreeNode(rootData);
            root.left = createTreeHelper(inOrder, preOrder, leftInOrderStart, leftInOrderEnd,
                    leftPreOrderStart, leftPreOrderEnd);

            root.right = createTreeHelper(inOrder, preOrder, rightInOrderStart, rightInOrderEnd,
                    rightPreOrderStart, rightPreOrderEnd);

            return root;
        }
    }

    private static class Technique2 {

        public TreeNode createTree(int[] inOrder, int[] preOrder) {

            Map<Integer, Integer> inOrderMap = new HashMap<>();

            for (int i = 0; i < inOrder.length; i++) {
                inOrderMap.put(inOrder[i], i);
            }

            AtomicInteger preOrderIndex = new AtomicInteger(0);

            return createTreeHelper(preOrder, inOrderMap, preOrderIndex, 0, preOrder.length - 1);
        }


        private TreeNode createTreeHelper(int[] preOrder, Map<Integer, Integer> inOrderMap, AtomicInteger preOrderIndex,
                                          int start, int end) {

            if (start > end) {
                return null;
            }

            // Get the location
            int rootData = preOrder[preOrderIndex.getAndIncrement()];
            int rootIndex = inOrderMap.get(rootData);

            // Taking lots of variable for clarification
            TreeNode root = new TreeNode(rootData);
            root.left = createTreeHelper(preOrder, inOrderMap, preOrderIndex, start, rootIndex - 1);
            root.right = createTreeHelper(preOrder, inOrderMap, preOrderIndex, rootIndex + 1, end);
            return root;
        }
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root);
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root);
    }

    public static void main(String[] args) {
        int[] inOrder = {4, 2, 5, 1, 8, 6, 9, 3, 7};
        int[] preOrder = {1, 2, 4, 5, 3, 6, 8, 9, 7};

        System.out.println("Using Technique 1");
        final Technique1 converter1 = new Technique1();
        TreeNode root = converter1.createTree(inOrder, preOrder);
        printArray(inOrder);
        inOrder(root);
        System.out.println();
        postOrder(root);


        System.out.println("\nUsing Technique 2\n");
        final Technique2 converter2 = new Technique2();
        root = converter2.createTree(inOrder, preOrder);
        printArray(inOrder);
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

    private static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + " ");
        }
        System.out.println("");
    }
}
