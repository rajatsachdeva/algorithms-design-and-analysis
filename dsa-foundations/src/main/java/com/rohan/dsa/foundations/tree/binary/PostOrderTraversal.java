package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;
import com.rohan.dsa.foundations.tree.Stack;

public class PostOrderTraversal {

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root);
    }

    public void postOrderIterative(final TreeNode root) {

        if (root == null) return;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        TreeNode current = null;
        while (!s1.isEmpty()) {
            current = s1.pop();

            if (current.getLeft() != null) {
                s1.push(current.getLeft());
            }

            if (current.getRight() != null) {
                s1.push(current.getRight());
            }
            s2.push(current);
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop() + " ");
        }
    }

    public void postOrderTraversalUsingSingleStack(final TreeNode root) {
        // TODO
    }

}
