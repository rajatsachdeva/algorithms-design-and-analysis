package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;
import com.rohan.dsa.foundations.tree.Queue;

/**
 * Given a root of binary tree, return size of binar tree
 * <p>
 * Solution:
 * Recursively find size of left side, right side and add one to them and return that to calling function.
 * Iterative: Using level order approach
 * <p>
 * Time complexity - O(n)
 * Space complexity(because of recursion stack) - height of binary tree. Worst case O(n)
 * <p>
 * Test cases:
 * Null tree
 * 1 node tree
 * multi node tree
 */
public class SizeOfABinaryTree {

    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSize = size(root.getLeft());
        int rightSize = size(root.getRight());

        return 1 + leftSize + rightSize;
    }

    // Using level order traversal
    public int sizeIterative(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        int size = 0;
        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.dequeue();
            size++;
            if (current.getLeft() != null) {
                queue.enqueue(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.enqueue(current.getRight());
            }
        }

        return size;
    }
}
