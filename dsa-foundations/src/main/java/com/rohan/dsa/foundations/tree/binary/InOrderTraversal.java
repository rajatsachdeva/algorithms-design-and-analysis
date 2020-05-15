package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.BinaryNode;
import com.rohan.dsa.foundations.tree.Stack;

public class InOrderTraversal {

    //LVR
    public void inOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root);
        inOrder(root.getRight());
    }

    public void inOrderIterative(BinaryNode root) {

        if (root == null) return;
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(root);

        BinaryNode current = root;

        while (true) {
            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                if (stack.isEmpty()) {
                    break;
                }

                BinaryNode node = stack.pop();
                System.out.print(node + " ");

                if (current.getRight() != null) {
                    current = current.getRight();
                }
            }
        }
    }


}
