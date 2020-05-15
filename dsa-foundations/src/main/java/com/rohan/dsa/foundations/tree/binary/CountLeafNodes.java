package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.BinaryNode;
import com.rohan.dsa.foundations.tree.Queue;

/**
 * Find the number of half nodes in the binary tree.
 * <p>
 * The set of all nodes having no left and right children
 */
public class CountLeafNodes {

    public int countLeafNodes(BinaryNode root) {

        if (root == null) {
            return 0;
        }
        return (isLeafNode(root) ? 1 : 0)
                + countLeafNodes(root.getLeft())
                + countLeafNodes(root.getRight());
    }

    public int countLeafNodesIterative(BinaryNode root) {
        if (root == null) return 0;

        Queue<BinaryNode> queue = new Queue<>();
        queue.enqueue(root);
        int count = 0;
        BinaryNode current;
        while (!queue.isEmpty()) {

            current = queue.dequeue();
            if (isLeafNode(current)) {
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

    private boolean isLeafNode(BinaryNode node) {
        return node.getLeft() == null && node.getRight() == null;
    }
}
