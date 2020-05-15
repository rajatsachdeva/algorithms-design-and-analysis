package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;
import com.rohan.dsa.foundations.tree.Queue;

public class FindDeepestNode {

    public TreeNode getDeepestNode(TreeNode root) {
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        TreeNode node = null;
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
