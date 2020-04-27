package com.rohan.dsa.foundations.linkedlist;

public class SListNode<T> {

    private T data;
    private SListNode<T> next;

    public SListNode(T data) {
        this.data = data;
    }

    public SListNode(T data, SListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public SListNode(SListNode node) {
        this.setNext(node);
    }

    public T data() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SListNode<T> next() {
        return next;
    }

    public void setNext(SListNode<T> next) {
        this.next = next;
    }
}
