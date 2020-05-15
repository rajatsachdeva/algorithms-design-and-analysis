package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.BinaryNode;
import com.rohan.dsa.foundations.tree.Stack;

public class PreOrderTraversal {

    // VLR
    public void preOrder(final BinaryNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root);
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void preOrderIterative(final BinaryNode root) {
        if (root == null) return;
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(root);

        BinaryNode current;
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
