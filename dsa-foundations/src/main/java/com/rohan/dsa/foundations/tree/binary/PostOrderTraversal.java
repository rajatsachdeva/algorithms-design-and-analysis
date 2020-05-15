package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.BinaryNode;
import com.rohan.dsa.foundations.tree.Stack;

public class PostOrderTraversal {

    public void postOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root);
    }

    public void postOrderIterative(final BinaryNode root) {

        if (root == null) return;

        Stack<BinaryNode> s1 = new Stack<>();
        Stack<BinaryNode> s2 = new Stack<>();
        s1.push(root);

        BinaryNode current = null;
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

    public void postOrderTraversalUsingSingleStack(final BinaryNode root) {
        // TODO
    }

}
