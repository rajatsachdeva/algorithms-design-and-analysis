package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.TreeNode;

public class BinaryTreeImpl {
    private TreeNode root;


    public void delete() {
        root = null;
    }

    public boolean isBlank() {
        return root == null;
    }

    public TreeNode getRoot() {
        return root;
    }
}
