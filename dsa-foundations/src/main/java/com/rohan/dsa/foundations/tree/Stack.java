package com.rohan.dsa.foundations.tree;

public class Stack<T> {

    private LinkedList<T> list;

    public Stack() {
        list = new LinkedList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(T item) {
        list.insertFirst(item);
    }

    public T pop() {
        return list.deleteFirst();
    }
}
