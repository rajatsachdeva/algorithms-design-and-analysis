package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;
import com.rohan.dsa.foundations.tree.Queue;

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
            if (present.getValue() == data) {
                TreeNode deepestNode = getDeepestNode(root);
                present.setValue(deepestNode.getValue());
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
            if (deepest.getLeft() != null) {
                queue.enqueue(deepest.getLeft());
            }

            if (deepest.getRight() != null) {
                queue.enqueue(deepest.getRight());
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
            if (present.getLeft() == null) {
                previous.setRight(null);
            }

            if (present.getRight() == null) {
                present.setLeft(null);
                return;
            }

            queue.enqueue(present.getLeft());
            queue.enqueue(present.getRight());
        }
    }
}