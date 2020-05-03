package com.rohan.dsa.foundations.linkedlist;

import static java.lang.String.format;

public class Node {

    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        if (next == null) {
            return format("[ %d ]", data);
        } else {
            return format("[ %d ] -> ", data);
        }
    }
}
