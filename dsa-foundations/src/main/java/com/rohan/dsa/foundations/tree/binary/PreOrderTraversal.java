package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.Stack;
import com.rohan.dsa.foundations.tree.TreeNode;

public class PreOrderTraversal {

    // VLR
    public void preOrder(final TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderIterative(final TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode current;
        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current + " ");
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }
}
