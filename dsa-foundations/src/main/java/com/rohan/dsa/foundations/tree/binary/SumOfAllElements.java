package com.rohan.dsa.foundations.tree.binary;


import com.rohan.dsa.foundations.tree.BinaryNode;
import com.rohan.dsa.foundations.tree.Queue;

public class SumOfAllElements {

    public int sum(BinaryNode root) {
        if (root == null) {
            return 0;
        }

        return root.getValue() + sum(root.getLeft()) + sum(root.getRight());
    }


    public int sumIterative(BinaryNode root) {
        if (root == null) {
            return 0;
        }

        Queue<BinaryNode> queue = new Queue<>();
        queue.enqueue(root);
        int sum = 0;
        BinaryNode current;
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
