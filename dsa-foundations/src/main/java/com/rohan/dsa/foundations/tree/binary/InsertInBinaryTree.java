package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;
import com.rohan.dsa.foundations.tree.Queue;

/**
 * Inserting an element in a Binary tree.
 * <p>
 * Using recursion and iterative
 */
public class InsertInBinaryTree {

    public TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        } else {
            if (root.getValue() > data) {
                return insert(root.getRight(), data);
            } else {
                return insert(root.getLeft(), data);
            }
        }
    }

    public TreeNode insertIterative(TreeNode root, int data) {
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            root = newNode;
            return root;
        }

        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);

        TreeNode present;
        while (!queue.isEmpty()) {
            present = queue.dequeue();
            if (present.getLeft() == null) {
                present.setLeft(newNode);
                return root;
            }
            if (present.getRight() == null) {
                present.setRight(newNode);
                return root;
            }

            queue.enqueue(present.getLeft());
            queue.enqueue(present.getRight());
        }
        return root;
    }
}
