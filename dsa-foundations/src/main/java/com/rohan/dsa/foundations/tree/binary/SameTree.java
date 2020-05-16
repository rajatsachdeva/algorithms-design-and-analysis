package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;

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

    public boolean isSame(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return (root1.data == root2.data) &&
                isSame(root1.left, root2.left) &&
                isSame(root1.right, root2.right);
    }
}
