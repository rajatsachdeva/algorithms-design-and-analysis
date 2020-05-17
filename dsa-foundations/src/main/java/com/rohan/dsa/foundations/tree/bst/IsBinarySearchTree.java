package com.rohan.dsa.foundations.tree.bst;

import com.rohan.dsa.foundations.tree.Stack;
import com.rohan.dsa.foundations.tree.TreeNode;

public class IsBinarySearchTree {


    public boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data <= min || root.data > max) {
            return false;
        }

        return isBST(root.left, min, root.data) &&
                isBST(root.right, root.data, max);
    }


    // Using inorder iterative traversal
    public boolean isBSTIterative(TreeNode root) {

        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        int prev = Integer.MIN_VALUE;
        TreeNode current = root;

        while (true) {

            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }

                current = stack.pop();
                if (current.data < prev) {
                    return false;
                }
                prev = current.data;
                current = current.right;
            }
        }

        return true;
    }

}
