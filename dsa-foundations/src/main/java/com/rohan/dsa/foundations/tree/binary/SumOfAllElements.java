package com.rohan.dsa.foundations.tree.binary;


import com.rohan.dsa.foundations.tree.Queue;
import com.rohan.dsa.foundations.tree.TreeNode;

public class SumOfAllElements {

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.data + sum(root.left) + sum(root.right);
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
            sum += current.data;
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }

        return sum;
    }
}
