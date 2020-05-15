package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;
import com.rohan.dsa.foundations.tree.Queue;

/**
 * Find the maximum element in a binary tree with and without recursion.
 */
public class FindMax {

    public int max(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int currMax = root.getValue();
        int leftMax = max(root.getLeft());
        int rightMax = max(root.getRight());

        if (leftMax > currMax) {
            currMax = leftMax;
        }

        if (rightMax > currMax) {
            currMax = rightMax;
        }

        return currMax;
    }

    // Using level Order traversal
    public int maxIterative(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        int max = Integer.MIN_VALUE;
        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.dequeue();
            if (current.getValue() > max) {
                max = current.getValue();
            }

            if (current.getLeft() != null) {
                queue.enqueue(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.enqueue((current.getRight()));
            }
        }
        return max;
    }

}
