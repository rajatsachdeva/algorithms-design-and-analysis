package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstructTreeFromInOrderAndPostOrder {

    private static class Technique1 {
        public Technique1() {
            System.out.println("\nUsing Technique 1\n");
        }

        public TreeNode createTree(int[] inOrder, int[] postOrder) {
            return createTreeHelper(inOrder, postOrder, 0, inOrder.length - 1,
                    postOrder.length - 1, 0);
        }

        private TreeNode createTreeHelper(int[] inOrder, int[] postOrder,
                                          int inOrderStart, int inOrderEnd,
                                          int postOrderStart, int postOrderEnd) {

            if (inOrderStart > inOrderEnd || postOrderEnd > postOrderStart) {
                return null;
            }

            // Get the location
            int rootData = postOrder[postOrderStart];
            int rootIndex = -1;
            for (int i = inOrderStart; i <= inOrderEnd; i++) {
                if (rootData == inOrder[i]) {
                    rootIndex = i;
                    break;
                }
            }

            // Taking lots of variable for clarification
            // In Order
            int leftInOrderStart = inOrderStart; // 0
            int leftInOrderEnd = rootIndex - 1; // 2
            int rightInOrderStart = rootIndex + 1; // 4
            int rightInOrderEnd = inOrderEnd; // 8

            // This part took me time to digest. I had to dry run quite some time
            // Post Order
            int rightPostOrderStart = postOrderStart - 1; // 7
            int rightPostOrderEnd = rightPostOrderStart - rightInOrderEnd + rightInOrderStart; // 4
            int leftPostOrderStart = rightPostOrderEnd - 1; // 2
            int leftPostOrderEnd = postOrderEnd; // 0

            TreeNode root = new TreeNode(rootData);
            root.left = createTreeHelper(inOrder, postOrder, leftInOrderStart, leftInOrderEnd,
                    leftPostOrderStart, leftPostOrderEnd);

            root.right = createTreeHelper(inOrder, postOrder, rightInOrderStart, rightInOrderEnd,
                    rightPostOrderStart, rightPostOrderEnd);

            return root;
        }
    }

    //https://www.techiedelight.com/construct-binary-tree-from-inorder-postorder-traversals/
    private static class Technique2 {

        public Technique2() {
            System.out.println("\nUsing Technique 2\n");
        }

        public TreeNode createTree(int[] inOrder, int[] postOrder) {

            Map<Integer, Integer> inOrderMap = new HashMap<>();

            for (int i = 0; i < inOrder.length; i++) {
                inOrderMap.put(inOrder[i], i);
            }

            AtomicInteger postOrderIndex = new AtomicInteger(postOrder.length - 1);

            return createTreeHelper(postOrder, inOrderMap, postOrderIndex, 0, postOrder.length - 1);
        }

        public TreeNode createTreeHelper(int[] postOrder, Map<Integer, Integer> inOrderMap,
                                         AtomicInteger postOrderIndex, int start, int end) {

            if (start > end) {
                return null;
            }

            int rootData = postOrder[postOrderIndex.getAndDecrement()];
            int rootIndex = inOrderMap.get(rootData);

            TreeNode root = new TreeNode(rootData);
            // Below order matters as for postorder, we traverse from last and Right subtree comes first.
            // and postOrderIndex starts from last.
            root.right = createTreeHelper(postOrder, inOrderMap, postOrderIndex, rootIndex + 1, end);
            root.left = createTreeHelper(postOrder, inOrderMap, postOrderIndex, start, rootIndex - 1);
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

    public static void main(String[] args) {
        int[] inOrder = {4, 2, 5, 1, 8, 6, 9, 3, 7};
        int[] postOrder = {4, 5, 2, 8, 9, 6, 7, 3, 1};

        final Technique1 technique1 = new Technique1();
        TreeNode root = technique1.createTree(inOrder, postOrder);
        printArray(inOrder);
        inOrder(root);

        final Technique2 technique2 = new Technique2();
        root = technique2.createTree(inOrder, postOrder);
        printArray(inOrder);
        inOrder(root);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + " ");
        }
        System.out.println("");
    }
}