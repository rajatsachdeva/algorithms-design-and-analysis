package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.Queue;
import com.rohan.dsa.foundations.tree.TreeNode;

/**
 * Find the maximum element in a binary tree with and without recursion.
 */
public class FindMax {

    public int max(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int currMax = root.data;
        int leftMax = max(root.left);
        int rightMax = max(root.right);

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
            if (current.data > max) {
                max = current.data;
            }

            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue((current.right));
            }
        }
        return max;
    }
}
