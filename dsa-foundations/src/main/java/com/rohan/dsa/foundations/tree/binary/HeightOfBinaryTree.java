package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;

import static java.lang.Math.max;

public class HeightOfBinaryTree {

    public int height(TreeNode root) {

        if (root == null) {
            return -1;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + max(leftHeight, rightHeight);
    }

    public int heightIterative() {
        return -1;
    }

}
