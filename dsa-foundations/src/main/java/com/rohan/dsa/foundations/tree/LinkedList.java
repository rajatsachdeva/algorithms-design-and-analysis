package com.rohan.dsa.foundations.tree;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    boolean isEmpty() {
        return head == null;
    }

    void insertLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    T deleteFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Underflow");
        }

        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    int getSize() {
        return size;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

}
