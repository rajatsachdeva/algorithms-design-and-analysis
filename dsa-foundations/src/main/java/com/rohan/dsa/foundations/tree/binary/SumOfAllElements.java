package com.rohan.dsa.foundations.tree.binary;


import com.rohan.dsa.foundations.tree.TreeNode;
import com.rohan.dsa.foundations.tree.Queue;

public class SumOfAllElements {

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.getValue() + sum(root.getLeft()) + sum(root.getRight());
    }


    public int sumIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        int sum = 0;
        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.dequeue();
            sum += current.getValue();
            if (current.getLeft() != null) {
                queue.enqueue(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.enqueue(current.getRight());
            }
        }

        return sum;
    }
}
