package com.rohan.dsa.foundations.tree.bst;

import com.rohan.dsa.foundations.tree.Queue;
import com.rohan.dsa.foundations.tree.BinaryNode;

public class BinarySearchTree {

    private BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int item) {
        root = insert(root, item);
    }

    private BinaryNode insert(BinaryNode root, int item) {
        // Only place where we create the node
        //
        return null;
    }

    public boolean search(int item) {
        return search(root, item);
    }

    private boolean search(BinaryNode root, int item) {
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

    private void delete(BinaryNode root, int item) {
        // TODO
    }

    public BinaryNode min(BinaryNode root) {
        if (root.getLeft() == null) {
            return root;
        }
        return min(root.getLeft());
    }

    public BinaryNode max(BinaryNode root) {
        if (root.getRight() == null) {
            return root;
        }
        return max(root.getRight());
    }

    // Traversal
    public void levelOrder() {
        Queue<BinaryNode> queue = new Queue<>();
    }

    public static void main(String[] args) {

    }

}
