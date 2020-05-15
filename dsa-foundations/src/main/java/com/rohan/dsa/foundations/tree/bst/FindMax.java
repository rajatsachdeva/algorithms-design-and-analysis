package com.rohan.dsa.foundations.tree.bst;

import com.rohan.dsa.foundations.tree.TreeNode;

public class FindMax {
    public TreeNode max(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            // Means the last node in the right
            if (root.right == null) {
                return root;
            }
            return max(root.right);
        }
    }

    public TreeNode maxIterative(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

}
