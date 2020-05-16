package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.Queue;
import com.rohan.dsa.foundations.tree.Stack;
import com.rohan.dsa.foundations.tree.TreeNode;

/**
 * Given a binary tree print its level order traversal in reverse
 * e.g           1
 * 2         3
 * 4    5    6   7
 * <p>
 * Output should be 4 5 6 7 2 3 1
 * <p>
 * Solution
 * Maintain a stack and queue. Do regular level order traversal but
 * put right first in the queue. Instead of printing put the result
 * in stack. Finally print contents of the stack.
 * <p>
 * Time and space complexity is O(n)
 * <p>
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
            if (current.left != null) {
                queue.enqueue(current.left);
            } else if (current.right != null) {
                queue.enqueue(current.right);
            }
            stack.push(current);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
