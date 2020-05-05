package com.rohan.dsa.foundations.queue;

import java.util.stream.IntStream;

public class LinkedQueue {

    private LinkedList list;

    public LinkedQueue() {
        this.list = new LinkedList();
    }

    public void enqueue(int data) {
        list.insertLast(data);
    }

    public int dequeue() {
        return list.deleteFirst();
    }

    public int peek() {
        return list.getFirstValue();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    private static class LinkedList {
        private Node head;
        private Node tail;
        private int size;

        public void insertLast(int data) {
            Node newNode = new Node(data);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
            size++;
        }

        public int deleteFirst() {
            if (head == null) {
                throw new IllegalStateException("Is empty!!");
            }

            int data = head.getData();
            head = head.getNext();
            size--;

            if (head == null) {
                tail = null;
            }

            return data;
        }

        public int getFirstValue() {
            if (head == null) {
                throw new IllegalStateException("Queue is empty");
            }
            return head.getData();
        }

        public int size() {
            return size;
        }

        @Override
        public String toString() {
            Node temp = head;
            StringBuilder stringBuilder = new StringBuilder();
            while (temp != null) {
                stringBuilder.append(temp);
                stringBuilder.append("\n");
                temp = temp.getNext();
            }

            return stringBuilder.toString();
        }
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
            return String.format("[ %d ]", data);
        }
    }

    public static void main(String[] args) {
        LinkedQueue q = new LinkedQueue();
        IntStream.range(1, 6).forEach(q::enqueue);
        System.out.println(q);

        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
        System.out.println("Is empty ? " + q.isEmpty());

        q.enqueue(10);
        System.out.println(q);
        System.out.println("Peek -> " + q.peek());
    }
}
