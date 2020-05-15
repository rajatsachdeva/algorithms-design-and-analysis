package com.rohan.dsa.foundations.tree.bst;

import com.rohan.dsa.foundations.tree.TreeNode;

public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int item) {
        root = insert(root, item);
    }

    private TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        } else {
            if (root.getValue() > data) {
                root.right = insert(root.right, data);
            } else {
                root.left = insert(root.left, data);
            }
        }
        return root;
    }

    public boolean search(int item) {
        return search(root, item);
    }

    private boolean search(TreeNode root, int item) {
        if (root == null) {
            return false;
        } else if (item == root.getValue()) {
            return true;
        } else if (item > root.getValue()) {
            return search(root.getRight(), item);
        } else {
            return search(root.getRight(), item);
        }
    }

    public void delete(int item) {
        delete(root, item);
    }

    private TreeNode delete(TreeNode root, int data) {
        if (root == null) {
            throw new IllegalStateException("Empty");
        } else if (data < root.getValue()) {
            root.left = delete(root.left, data);
        } else if (data > root.getValue()) {
            root.right = delete(root.right, data);
        } else {
            // Found
            // Case 1: Both the children
            if (root.left != null && root.right != null) {
                TreeNode minElementNode = min(root);
                root.setValue(minElementNode.getValue());
                // Important: because we found it from the right
                root.right = delete(root.right, minElementNode.getValue());
            }
            // Case 2: Single left child
            else if (root.left != null) {
                root = root.left;
            }
            // Case 2: Single right child
            else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    public TreeNode min(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.getLeft() == null) {
            return root;
        }

        return min(root.getLeft());
    }


    public static void main(String[] args) {

    }

}
