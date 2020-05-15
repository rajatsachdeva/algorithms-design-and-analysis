package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;

public class MirrorOfABinaryTree {

    public TreeNode mirrorUsingTemp(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public TreeNode mirror(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftNode = mirror(root.left);
        TreeNode rightNode = mirror(root.right);

        root.left = rightNode;
        root.right = leftNode;

        return root;
    }
}
