package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;
import com.rohan.dsa.foundations.tree.Stack;

public class InOrderTraversal {

    //LVR
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root);
        inOrder(root.getRight());
    }

    public void inOrderIterative(TreeNode root) {

        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode current = root;

        while (true) {
            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                if (stack.isEmpty()) {
                    break;
                }

                TreeNode node = stack.pop();
                System.out.print(node + " ");

                if (current.getRight() != null) {
                    current = current.getRight();
                }
            }
        }
    }


}
