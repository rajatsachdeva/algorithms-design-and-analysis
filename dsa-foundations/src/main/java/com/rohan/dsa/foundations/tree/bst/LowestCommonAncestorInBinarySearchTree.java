package com.rohan.dsa.foundations.tree.bst;

import com.rohan.dsa.foundations.tree.TreeNode;

/**
 * Lowest common ancestor in binary search tree.
 * <p>
 * Time complexity O(height of tree)
 * Space complexity O(height of tree)
 * <p>
 * Assumptions:-
 * <p>
 * 1. Assumption that both nodes are present in the tree.
 * 2. Any node being null will give NPE in your code.
 * 3. The conditions should have root.data
 * <p>
 * Expected Output:
 * LCA of 10 and 14 is 12
 * LCA of 14 and 8 is 8
 * LCA of 10 and 22 is 20
 */
public class LowestCommonAncestorInBinarySearchTree {

    public static TreeNode lca(TreeNode node, int n1, int n2) {
        if (node == null) {
            return null;
        }

        if (node.data > n1 && node.data > n2) {
            return lca(node.left, n1, n2);
        } else if (node.data < n1 && node.data < n2) {
            return lca(node.right, n1, n2);
        } else {
            return node;
        }
    }


    public static TreeNode lcaUsingMinMax(TreeNode node, int n1, int n2) {
        if (node == null) {
            return null;
        }

        if (node.data > Math.max(n1, n2)) {
            return lca(node.left, n1, n2);
        } else if (node.data < Math.min(n1, n2)) {
            return lca(node.right, n1, n2);
        } else {
            return node;
        }
    }

    public static void main(String[] args) {

        // Let us construct the BST shown in the above figure
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        int n1 = 10, n2 = 14;
        TreeNode t = lcaUsingMinMax(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = lca(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = lcaUsingMinMax(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
    }
}
