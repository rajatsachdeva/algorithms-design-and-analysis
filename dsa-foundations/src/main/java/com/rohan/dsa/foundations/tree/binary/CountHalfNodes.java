package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.Queue;
import com.rohan.dsa.foundations.tree.TreeNode;

/**
 * Find the number of half nodes in the binary tree.
 * <p>
 * The set of all nodes having one child are called half nodes
 */
public class CountHalfNodes {


    public int countHalfNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return (isHalfNode(root) ? 1 : 0)
                + countHalfNodes(root.left)
                + countHalfNodes(root.right);
    }

    public int countHalfNodesIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        int count = 0;
        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.dequeue();

            if (isHalfNode(current)) {
                count++;
            }

            if (current.left != null) {
                queue.enqueue(current.left);
            }

            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }

        return count;
    }

    private boolean isHalfNode(TreeNode node) {
        return (node.left != null && node.right == null) ||
                (node.left == null && node.right != null);
    }
}
