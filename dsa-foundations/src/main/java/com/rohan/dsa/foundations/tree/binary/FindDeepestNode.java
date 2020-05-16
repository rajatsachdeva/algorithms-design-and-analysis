package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.Queue;
import com.rohan.dsa.foundations.tree.TreeNode;

public class FindDeepestNode {

    public TreeNode getDeepestNode(TreeNode root) {
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.dequeue();
            if (node.left != null) {
                queue.enqueue(node.left);
            }

            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }

        // This will be the last node of the queue
        return node;
    }
}
