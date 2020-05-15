package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;
import com.rohan.dsa.foundations.tree.Stack;

public class PreOrderTraversal {

    // VLR
    public void preOrder(final TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root);
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void preOrderIterative(final TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode current;
        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current + " ");
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }
    }
}
