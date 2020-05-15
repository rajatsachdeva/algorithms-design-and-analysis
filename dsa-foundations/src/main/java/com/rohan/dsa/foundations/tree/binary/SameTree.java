package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.BinaryNode;

/**
 * Given roots of two tree, return true if they have same data and same structure
 * or return false.
 * <p>
 * Solution
 * Keep comparing root of both data and then recursively check left and right.
 * <p>
 * Time complexity is O(n)
 */
public class SameTree {

    public boolean isSame(BinaryNode root1, BinaryNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return (root1.getValue() == root2.getValue()) &&
                isSame(root1.getLeft(), root2.getLeft()) &&
                isSame(root1.getRight(), root2.getRight());
    }
}
