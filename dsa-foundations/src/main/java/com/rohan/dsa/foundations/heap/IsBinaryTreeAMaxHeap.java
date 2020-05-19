package com.rohan.dsa.foundations.heap;

import com.rohan.dsa.foundations.tree.Queue;
import com.rohan.dsa.foundations.tree.TreeNode;

/**
 * Recursive and Iterative Solution
 */
public class IsBinaryTreeAMaxHeap {

    public static boolean isMaxHeap(TreeNode root) {
        // TODO
        return false;
    }

    public static boolean isMaxHeapIterative(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);

        TreeNode current;
        boolean nullSeen = false;
        while (!queue.isEmpty()) {
            current = queue.dequeue();

            if (current.left != null) {
                if (nullSeen || current.left.data >= current.data) {
                    return false;
                }
                queue.enqueue(current.left);
            } else {
                nullSeen = true;
            }

            if (current.right != null) {
                if (nullSeen || current.right.data >= current.data) {
                    return false;
                }
                queue.enqueue(current.right);
            } else {
                nullSeen = true;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        /* Construct below binary tree
	               10
	             /   \
	            /     \
	           8       9
	          / \     / \
	         /   \   /   \
	        7     6 5    4
		*/

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);

        if (isMaxHeapIterative(root)) {
            System.out.print("Given Binary Tree is a Max-Heap");
        } else {
            System.out.print("Given Binary Tree is not a Max-Heap");
        }
    }
}

