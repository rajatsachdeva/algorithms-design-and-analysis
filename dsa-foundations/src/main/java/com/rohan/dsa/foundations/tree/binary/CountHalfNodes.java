package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;
import com.rohan.dsa.foundations.tree.Queue;

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
                + countHalfNodes(root.getLeft())
                + countHalfNodes(root.getRight());
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

            if (current.getLeft() != null) {
                queue.enqueue(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.enqueue(current.getRight());
            }
        }

        return count;
    }

    private boolean isHalfNode(TreeNode node) {
        return (node.getLeft() != null && node.getRight() == null) ||
                (node.getLeft() == null && node.getRight() != null);
    }
}
