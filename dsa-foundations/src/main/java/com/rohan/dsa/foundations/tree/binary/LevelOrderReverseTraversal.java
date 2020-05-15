package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;
import com.rohan.dsa.foundations.tree.Queue;
import com.rohan.dsa.foundations.tree.Stack;

/**
 * Given a binary tree print its level order traversal in reverse
 * e.g           1
 *          2         3
 *        4    5    6   7
 *
 * Output should be 4 5 6 7 2 3 1
 *
 * Solution
 * Maintain a stack and queue. Do regular level order traversal but
 * put right first in the queue. Instead of printing put the result
 * in stack. Finally print contents of the stack.
 *
 * Time and space complexity is O(n)
 *
 * References : http://www.geeksforgeeks.org/reverse-level-order-traversal/
 */
public class LevelOrderReverseTraversal {

    public void reverseLevelOrder(final TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);

        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.dequeue();
            if (current.getLeft() != null) {
                queue.enqueue(current.getLeft());
            } else if (current.getRight() != null) {
                queue.enqueue(current.getRight());
            }
            stack.push(current);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
