package com.rohan.dsa.foundations.stack;

import java.util.stream.IntStream;

/**
 * Stack using Linked list
 */
public class LinkedStack {

    public LinkedList linkedList;

    public LinkedStack() {
        linkedList = new LinkedList();
    }

    public void push(int data) {
        linkedList.insertFirst(data);
    }

    public int pop() {
        return linkedList.deleteFirst();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public void delete() {
        linkedList.delete();
    }

    public int peek() {
        return linkedList.getFirstValue();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }

    private static class LinkedList {
        private Node head;
        private int size;

        void insertFirst(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                newNode.setNext(head);
                head = newNode;
            }
            size++;
        }

        int deleteFirst() {
            if (head == null) {
                throw new RuntimeException("Its Empty! Nothing to Delete!");
            }

            int data = head.getData();
            head = head.next;
            size--;
            return data;
        }

        boolean isEmpty() {
            return head == null;
        }

        int getSize() {
            return size;
        }

        int getFirstValue() {
            if (isEmpty()) {
                throw new RuntimeException("Its Empty! Nothing to Peek!");
            }
            return head.getData();
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

        public void delete() {
            head = null;
        }
    }

    private static class Node {

        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }

        int getData() {
            return data;
        }

        void setData(int data) {
            this.data = data;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return String.format("[ %d ]", data);
        }
    }

    public static void main(String[] args) {

        LinkedStack stack = new LinkedStack();
        IntStream.range(10, 15).forEach(stack::push);
        System.out.println(stack);

        for (int i = 0; i < 4; i++) {
            System.out.println(stack.pop());
        }

        System.out.println("Peeking... : " + stack.peek());
    }
}
