package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.BinaryNode;
import com.rohan.dsa.foundations.tree.Queue;

public class FindMin {

    public int min(BinaryNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int currMin = root.getValue();
        int leftMin = min(root.getLeft());
        int rightMin = min(root.getRight());

        if (leftMin < currMin) {
            currMin = leftMin;
        }

        if (rightMin < currMin) {
            currMin = rightMin;
        }

        return currMin;
    }


    public int minIterative(BinaryNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        Queue<BinaryNode> queue = new Queue<>();
        queue.enqueue(root);
        int min = Integer.MAX_VALUE;
        BinaryNode current;
        while (!queue.isEmpty()) {
            current = queue.dequeue();
            if (current.getValue() < min) {
                min = current.getValue();
            }
            if (current.getLeft() != null) {
                queue.enqueue(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.enqueue((current.getRight()));
            }
        }
        return min;
    }

}
