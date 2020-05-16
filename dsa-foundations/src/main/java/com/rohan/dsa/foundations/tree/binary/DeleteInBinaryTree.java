package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.Queue;
import com.rohan.dsa.foundations.tree.TreeNode;

public class DeleteInBinaryTree {

    public void delete(TreeNode root, int data) {
        if (root == null) {
            throw new IllegalStateException("Is empty!");
        }

        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);

        TreeNode present;
        while (!queue.isEmpty()) {
            present = queue.dequeue();
            if (present.data == data) {
                TreeNode deepestNode = getDeepestNode(root);
                present.data = deepestNode.data;
                deleteDeepestNode(root);
                break;
            }
        }
    }

    private TreeNode getDeepestNode(TreeNode root) {
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        TreeNode deepest = null;
        while (!queue.isEmpty()) {
            deepest = queue.dequeue();
            if (deepest.left != null) {
                queue.enqueue(deepest.left);
            }

            if (deepest.right != null) {
                queue.enqueue(deepest.right);
            }
        }
        return deepest;
    }

    /**
     * http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/9-BinTree/heap-delete.html
     *
     * @param root
     */
    private void deleteDeepestNode(TreeNode root) {
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        TreeNode present, previous;
        while (!queue.isEmpty()) {
            present = queue.dequeue();
            previous = present;
            if (present.left == null) {
                previous.right = null;
            }

            if (present.right == null) {
                present.left = null;
                return;
            }

            queue.enqueue(present.left);
            queue.enqueue(present.right);
        }
    }
}