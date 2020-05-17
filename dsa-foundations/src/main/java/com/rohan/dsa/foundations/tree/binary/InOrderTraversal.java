package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.Stack;
import com.rohan.dsa.foundations.tree.TreeNode;

public class InOrderTraversal {

    //LVR
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root);
        inOrder(root.right);
    }

    public void inOrderIterative(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (true) {

            // if current node is not null, push it to the stack (defer it)
            // and move to its left child
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                // else if current node is null, we pop an element from stack,
                // print it and finally set current node to its right child
                if (stack.isEmpty()) {
                    break;
                }

                current = stack.pop();
                System.out.print(current + " ");
                current = current.right;
            }
        }
    }
}
