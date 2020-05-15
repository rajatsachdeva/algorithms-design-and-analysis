package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.BinaryNode;
import com.rohan.dsa.foundations.tree.Queue;

public class SearchInBinaryTree {

    public boolean search(BinaryNode root, int data) {
        if (root == null) {
            return false;
        }
        if (root.getValue() == data) {
            return true;
        }

        return search(root.getLeft(), data) || search(root.getRight(), data);
    }

    public boolean searchIterative(BinaryNode root, int data) {
        if (root == null) {
            return false;
        }
        Queue<BinaryNode> queue = new Queue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            BinaryNode first = queue.dequeue();
            if (first.getValue() == data) {
                return true;
            }
            if (first.getLeft() != null) {
                queue.enqueue(first.getLeft());
            }
            if (first.getRight() != null) {
                queue.enqueue(first.getRight());
            }
        }

        return false;
    }

}
