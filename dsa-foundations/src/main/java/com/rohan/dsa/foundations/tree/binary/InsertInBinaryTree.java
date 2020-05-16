package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.Queue;
import com.rohan.dsa.foundations.tree.TreeNode;

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
            if (root.data > data) {
                root.right = insert(root.right, data);
            } else {
                root.left = insert(root.left, data);
            }
        }
        return root;
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
            if (present.left == null) {
                present.left = newNode;
                return root;
            }
            if (present.right == null) {
                present.right = newNode;
                return root;
            }

            queue.enqueue(present.left);
            queue.enqueue(present.right);
        }
        return root;
    }
}
