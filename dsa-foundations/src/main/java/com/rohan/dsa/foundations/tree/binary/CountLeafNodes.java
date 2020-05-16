package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.Queue;
import com.rohan.dsa.foundations.tree.TreeNode;

/**
 * Find the number of half nodes in the binary tree.
 * <p>
 * The set of all nodes having no left and right children
 */
public class CountLeafNodes {

    public int countLeafNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return (isLeafNode(root) ? 1 : 0)
                + countLeafNodes(root.left)
                + countLeafNodes(root.right);
    }

    public int countLeafNodesIterative(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        int count = 0;
        TreeNode current;
        while (!queue.isEmpty()) {

            current = queue.dequeue();
            if (isLeafNode(current)) {
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

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
