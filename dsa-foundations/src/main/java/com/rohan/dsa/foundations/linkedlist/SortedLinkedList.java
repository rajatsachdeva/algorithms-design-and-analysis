package com.rohan.dsa.foundations.linkedlist;

/**
 * Idea is to always insert in sorted order
 */
public class SortedLinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    public void insert(int data) {

        Node newNode = new Node(data);
        Node prev = null;
        Node current = head;

        while (current != null && data > current.getData()) {
            prev = current;
            current = current.getNext();
        }

        // It was the only element
        if (prev == null) {
            head = newNode;
            tail = newNode;
        } else {
            prev.setNext(newNode);
        }
        newNode.setNext(current);

        if (newNode.getNext() == null) {
            tail = newNode;
        }

        size++;
    }

    public int deleteFirst() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        int data = head.getData();
        head = head.getNext();
        size--;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty!!";
        }
        Node temp = head;
        StringBuilder sb = new StringBuilder();
        while (temp.getNext() != null) {
            sb.append(temp).append(" --> ");
            temp = temp.getNext();
        }
        sb.append(temp).append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(50);
        list.insert(60);
        list.insert(10);
        list.insert(20);
        list.insert(70);
        list.insert(40);
        list.insert(30);

        System.out.println(list);
    }


    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
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
            return "[ " + data + " ]";
        }
    }

}
