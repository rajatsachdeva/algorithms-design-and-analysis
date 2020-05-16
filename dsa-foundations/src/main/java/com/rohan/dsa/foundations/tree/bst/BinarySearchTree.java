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
            if (root.data > data) {
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
        } else if (item == root.data) {
            return true;
        } else if (item > root.data) {
            return search(root.right, item);
        } else {
            return search(root.left, item);
        }
    }

    public void delete(int item) {
        delete(root, item);
    }

    private TreeNode delete(TreeNode root, int data) {
        if (root == null) {
            throw new IllegalStateException("Empty");
        } else if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            // Found
            // Case 1: Both the children
            if (root.left != null && root.right != null) {
                TreeNode minElementNode = min(root);
                root.data = minElementNode.data;
                // Important: because we found it from the right
                root.right = delete(root.right, minElementNode.data);
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

        if (root.left == null) {
            return root;
        }
        return min(root.left);
    }
}
