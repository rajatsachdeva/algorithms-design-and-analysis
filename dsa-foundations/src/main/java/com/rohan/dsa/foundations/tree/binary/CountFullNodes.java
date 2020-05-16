package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.Queue;
import com.rohan.dsa.foundations.tree.TreeNode;

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
                + countFullNodes(root.left)
                + countFullNodes(root.right);
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
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }
        return count;
    }

    private boolean isFullNode(TreeNode node) {
        return node.left != null && node.right != null;
    }
}
