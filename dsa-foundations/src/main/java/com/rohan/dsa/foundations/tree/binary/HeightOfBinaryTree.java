package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.BinaryNode;

import static java.lang.Math.max;

public class HeightOfBinaryTree {

    public int height(BinaryNode root) {

        if (root == null) {
            return -1;
        }

        int leftHeight = height(root.getLeft());
        int rightHeight = height(root.getRight());

        return 1 + max(leftHeight, rightHeight);
    }

    public int heightIterative() {
        return -1;
    }

}
