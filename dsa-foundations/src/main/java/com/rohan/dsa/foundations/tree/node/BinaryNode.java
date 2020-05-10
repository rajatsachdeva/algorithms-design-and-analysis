package com.rohan.dsa.foundations.tree.node;

public class BinaryNode {

    private int data;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(int data) {
        this.data = data;
    }

    public int getValue() {
        return data;
    }

    public void setValue(int data) {
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return " " + data + " ";
    }
}
