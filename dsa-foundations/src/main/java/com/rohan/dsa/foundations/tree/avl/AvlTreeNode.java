package com.rohan.dsa.foundations.tree.avl;

public class AvlTreeNode {

    public int data;
    public int height;
    public AvlTreeNode left;
    public AvlTreeNode right;

    public AvlTreeNode(int data) {
        this.data = data;
        this.height = 1; // Assuming the height of a single node is 1
    }


    @Override
    public String toString() {
        return " " + data + " ";
    }
}
