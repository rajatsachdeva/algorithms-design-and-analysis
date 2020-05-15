package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;
import com.rohan.dsa.foundations.tree.Queue;

public class LevelOrderTraversal {

    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        TreeNode first = null;
        while (!queue.isEmpty()) {
            first = queue.dequeue();
            TreeNode leftChild = first.getLeft();
            TreeNode rightChild = first.getRight();
            if (leftChild != null) {
                queue.enqueue(leftChild);
            }
            if (rightChild != null) {
                queue.enqueue(rightChild);
            }
            System.out.print(first);
        }
        System.out.println("");
    }
}
