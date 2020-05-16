package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.Queue;
import com.rohan.dsa.foundations.tree.TreeNode;

public class SearchInBinaryTree {

    public boolean search(TreeNode root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }

        return search(root.left, data) || search(root.right, data);
    }

    public boolean searchIterative(TreeNode root, int data) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            TreeNode first = queue.dequeue();
            if (first.data == data) {
                return true;
            }
            if (first.left != null) {
                queue.enqueue(first.left);
            }
            if (first.right != null) {
                queue.enqueue(first.right);
            }
        }
        return false;
    }

}
