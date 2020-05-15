package com.rohan.dsa.foundations.tree.bst;

import com.rohan.dsa.foundations.tree.TreeNode;

public class FindMin {

    public TreeNode min(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null) {
            return root;
        }

        return min(root.left);
    }

    public TreeNode minIterative(TreeNode root) {

        if (root == null) {
            return null;
        }

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}
