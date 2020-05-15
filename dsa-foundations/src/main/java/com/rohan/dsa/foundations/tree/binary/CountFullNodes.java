package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.BinaryNode;
import com.rohan.dsa.foundations.tree.Queue;

/**
 * Find the number of full nodes in the binary tree.
 * <p>
 * The set of all nodes with both left and right children are called full nodes
 */
public class CountFullNodes {

    public int countFullNodes(BinaryNode root) {

        if (root == null) {
            return 0;
        }
        return (isFullNode(root) ? 1 : 0)
                + countFullNodes(root.getLeft())
                + countFullNodes(root.getRight());
    }

    public int countFullNodesIterative(BinaryNode root) {
        if (root == null) return 0;

        Queue<BinaryNode> queue = new Queue<>();
        queue.enqueue(root);
        int count = 0;
        BinaryNode current;
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

    private boolean isFullNode(BinaryNode node) {
        return node.getLeft() != null && node.getRight() != null;
    }
}
