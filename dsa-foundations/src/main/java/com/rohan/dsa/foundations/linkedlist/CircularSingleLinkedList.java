package com.rohan.dsa.foundations.linkedlist;

public class CircularSingleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public CircularSingleLinkedList(int value) {
        Node newNode = new Node(value);
        newNode.setNext(newNode);
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public void insertFirst(int value) {
        insertAt(value, 0);
    }

    public void insertLast(int value) {
        insertAt(value, size);
    }

    public void insertAt(int value, int location) {

        Node newNode = new Node(value);
        if (head == null) {
            newNode.setNext(newNode);
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        if (location == 0) {
            newNode.setNext(head);
            head = newNode;
            tail.setNext(newNode);
        } else if (location == size) {
            Node lastNode = tail;
            newNode.setNext(lastNode.getNext());
            lastNode.setNext(newNode);
            tail = newNode;
        } else {
            // Reach on the node previous to the selected node
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.getNext();
            }
            newNode.setNext(tempNode.getNext());
            tempNode.setNext(newNode);
        }

        size++;
    }

    // Traverse
    public void display() {
        if (head == null) {
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp);
            temp = temp.getNext();
        } while (temp != head);
        System.out.print(String.format("( %d )", temp.getData()));
        System.out.println("");
    }

    public int getSize() {
        return size;
    }

    public boolean search(int value) {
        Node temp = head;
        while (temp != tail) {
            if (temp.getData() == value) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public void deleteFirst() {
        //deleteAt(0);
        if (head == null) {
            throw new RuntimeException("Nothing to delete");
        }

        // Only element or head == null
        if (head.getNext() == head) {
            head = tail = null;
            size--;
            return;
        }

        head = head.getNext();
        tail.setNext(head);
        size--;
    }

    public void deleteLast() {
        //deleteAt(size);
        if (head == null) {
            throw new RuntimeException("Nothing to delete");
        }

        if (tail.getNext() == tail) {
            tail = head = null;
            size--;
            return;
        }

        // Go to second last node
        Node temp = head;
        while (temp.getNext() != tail) {
            temp = temp.getNext();
        }

        temp.setNext(head);
        tail = temp;
        size--;
    }

    public void deleteAt(int location) {

        Node temp = head;
        for (int i = 0; i < location - 1; i++) {
            temp = temp.getNext();
        }

        Node toDelete = temp.getNext();
        temp.setNext(toDelete.getNext());
    }

    public static void main(String[] args) {

        CircularSingleLinkedList list = new CircularSingleLinkedList(20);
        list.insertFirst(10);
        list.insertLast(40);
        list.display();
        list.insertAt(30, 2);
        list.display();
        list.insertAt(5, 0);
        list.insertAt(50, 5);
        list.display();
        System.out.println("Linked list size: " + list.getSize());
        list.insertAt(15, 2);
        list.display();

        System.out.println("40 present in the list? : " + list.search(40));
        System.out.println("15 present in the list? : " + list.search(15));
        System.out.println("5 present in the list? : " + list.search(5));
        System.out.println("50 present in the list? : " + list.search(50));
        list.deleteFirst();
        list.display();

        list.deleteLast();
        list.display();

        list.deleteAt(3);
        list.display();

        CircularSingleLinkedList list2 = new CircularSingleLinkedList(10);
        list2.display();
        list2.deleteFirst();
        list2.display();
    }
}
