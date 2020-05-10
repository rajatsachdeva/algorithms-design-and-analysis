package com.rohan.dsa.foundations.tree.binary;

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

    private static class LinkedList<T> {

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
}
