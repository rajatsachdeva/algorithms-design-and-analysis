package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.BinaryNode;
import com.rohan.dsa.foundations.tree.Queue;

public class BinaryTreeImpl {
    private BinaryNode root;

    public void insert(int data) {
        BinaryNode newNode = new BinaryNode(data);
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<BinaryNode> queue = new Queue<>();
        queue.enqueue(root);

        BinaryNode present;
        while (!queue.isEmpty()) {
            present = queue.dequeue();
            if (present.getLeft() == null) {
                present.setLeft(newNode);
                break;
            }
            if (present.getRight() == null) {
                present.setRight(newNode);
                break;
            }

            queue.enqueue(present.getLeft());
            queue.enqueue(present.getRight());
        }
    }

    public void remove(int data) {
        if (isBlank()) {
            throw new IllegalStateException("Tree is blank");
        }

        // Search for the node to be deleted using level order traversal
        Queue<BinaryNode> queue = new Queue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            final BinaryNode first = queue.dequeue();
            if (first.getValue() == data) {
                BinaryNode deepest = getDeepestNode();
                first.setValue(deepest.getValue());
                deleteDeepestNode();
                break;
            }

            if (first.getLeft() != null) {
                queue.enqueue(first.getLeft());
            }

            if (first.getRight() != null) {
                queue.enqueue(first.getRight());
            }
        }
    }

    private BinaryNode getDeepestNode() {
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
        return node;
    }

    /**
     * http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/9-BinTree/heap-delete.html
     */
    private void deleteDeepestNode() {
        Queue<BinaryNode> queue = new Queue<>();
        queue.enqueue(root);
        BinaryNode prev = null, present;
        while (!queue.isEmpty()) {
            present = queue.dequeue();
            prev = present;

            // Farthest Right, when last node has complete binary tree
            if (present.getLeft() == null) {
                prev.setRight(null);
                return;
            } else if (present.getRight() == null) {
                present.setLeft(null);
                return;
            }

            queue.enqueue(present.getLeft());
            queue.enqueue(present.getRight());
        }
    }

    public void delete() {
        root = null;
    }

    public boolean isBlank() {
        return root == null;
    }

    public BinaryNode getRoot() {
        return root;
    }
}
