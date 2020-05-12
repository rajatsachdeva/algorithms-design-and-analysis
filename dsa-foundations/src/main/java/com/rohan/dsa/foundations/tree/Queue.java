package com.rohan.dsa.foundations.tree;

public class Queue<T> {

    private LinkedList<T> list;

    public Queue() {
        this.list = new LinkedList<>();
    }

    public void enqueue(T data) {
        list.insertLast(data);
    }

    public T dequeue() {
        return list.deleteFirst();
    }

    public int size() {
        return list.getSize();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
