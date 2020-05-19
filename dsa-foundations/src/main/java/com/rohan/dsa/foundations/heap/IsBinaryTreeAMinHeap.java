package com.rohan.dsa.foundations.heap;

import com.rohan.dsa.foundations.tree.Queue;
import com.rohan.dsa.foundations.tree.TreeNode;

public class IsBinaryTreeAMinHeap {

    public static boolean isMinheap(TreeNode root) {
        // TODO
        return false;
    }

    public static boolean isMinHeapIterative(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);

        TreeNode current;
        boolean nullSeen = false;
        while (!queue.isEmpty()) {
            current = queue.dequeue();

            if (nullSeen || current.left != null) {
                if (current.left.data <= current.data) {
                    return false;
                }
                queue.enqueue(current.left);
            } else {
                nullSeen = true;
            }

            if (current.right != null) {
                if (nullSeen || current.right.data <= current.data) {
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
	               2
	             /   \
	            /     \
	           3       4
	          / \     / \
	         /   \   /   \
	        5     6 8    10
		*/

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(10);

        if (isMinHeapIterative(root)) {
            System.out.print("Given Binary Tree is a Min-Heap");
        } else {
            System.out.print("Given Binary Tree is not a Min-Heap");
        }
    }
}
