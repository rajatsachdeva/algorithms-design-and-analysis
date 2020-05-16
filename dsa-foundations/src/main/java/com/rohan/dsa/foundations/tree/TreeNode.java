package com.rohan.dsa.foundations.tree;

public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return " " + data + " ";
    }
}
