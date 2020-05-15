package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;
import com.rohan.dsa.foundations.tree.Queue;

/**
 * Find the number of full nodes in the binary tree.
 * <p>
 * The set of all nodes with both left and right children are called full nodes
 */
public class CountFullNodes {

    public int countFullNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return (isFullNode(root) ? 1 : 0)
                + countFullNodes(root.getLeft())
                + countFullNodes(root.getRight());
    }

    public int countFullNodesIterative(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        int count = 0;
        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.dequeue();
            if (isFullNode(current)) {
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

    private boolean isFullNode(TreeNode node) {
        return node.getLeft() != null && node.getRight() != null;
    }
}
