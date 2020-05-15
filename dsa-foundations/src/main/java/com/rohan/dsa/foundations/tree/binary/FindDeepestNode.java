package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.BinaryNode;
import com.rohan.dsa.foundations.tree.Queue;

public class FindDeepestNode {

    public BinaryNode getDeepestNode(BinaryNode root) {
        Queue<BinaryNode> queue = new Queue<>();
        queue.enqueue(root);
        BinaryNode node = null;
        while (!queue.isEmpty()) {
            node = queue.dequeue();
            if (node.getLeft() != null) {
                queue.enqueue(node.getLeft());
            }

            if (node.getRight() != null) {
                queue.enqueue(node.getRight());
            }
        }

        // This will be the last node of the queue
        return node;
    }
}
