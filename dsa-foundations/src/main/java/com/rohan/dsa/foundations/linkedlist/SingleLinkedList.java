package com.rohan.dsa.foundations.linkedlist;

/**
 * To review:
 * - InsertAt
 * - deleteLast
 * - deleteAt
 * - search
 */
public class SingleLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private SingleLinkedList() {
    }

    public static SingleLinkedList create(int value) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node node = new Node(value);
        singleLinkedList.head = node;
        singleLinkedList.tail = node;
        singleLinkedList.size = 1;
        return singleLinkedList;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertFirst(int value) {
        insertAt(value, 0);
    }

    public void insertLast(int value) {
        insertAt(value, getSize());
    }

    public void insertAt(int value, int location) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        if (location == 0) {
            newNode.setNext(head);
            head = newNode;
        } else if (location == getSize()) {
            tail.setNext(newNode);
            tail = newNode;
        } else {
            Node prevNode = head;
            for (int i = 0; i < location - 1; i++) {
                prevNode = prevNode.getNext();
            }
            newNode.setNext(prevNode.getNext());
            prevNode.setNext(newNode);
        }
        size++;
    }

    public void deleteFirst() {
        deleteAt(0);
    }

    public void deleteLast() {
        deleteAt(getSize());
    }

    public void deleteAt(int location) {
        if (head == null) {
            throw new RuntimeException("Nothing to delete");
        }

        // Only single node
        if (head.getNext() == null) {
            tail = null;
            size--;
            return;
        }

        if (location == 0) {
            head = head.getNext();
        } else if (location == getSize()) {
            Node secondLastNode = head;
            while (secondLastNode.getNext().getNext() != null) {
                secondLastNode = secondLastNode.getNext();
            }
            secondLastNode.setNext(null);
            tail = secondLastNode;
        } else {
            // At a particular location
            Node selectedNode = head;
            for (int i = 0; i < location - 1; i++) {
                selectedNode = selectedNode.getNext();
            }
            Node toDeleteNode = selectedNode.getNext();
            selectedNode.setNext(toDeleteNode.getNext());
        }
        size--;
    }

    public void delete() {
        head = null;
        tail = null;
    }

    public boolean search(int value) {
        Node tempNode = head;
        while (tempNode != null) {
            if (tempNode.getData() == value) {
                return true;
            }
            tempNode = tempNode.getNext();
        }

        return false;
    }

    public void display() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode);
            tempNode = tempNode.getNext();
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        SingleLinkedList list = SingleLinkedList.create(20);
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
        list.deleteFirst();
        list.display();
        list.deleteLast();
        list.display();
        System.out.println("Linked list size: " + list.getSize());
        list.deleteAt(2);
        list.display();
        System.out.println("40 present in the list? : " + list.search(40));
        System.out.println("15 present in the list? : " + list.search(15));
        System.out.println("5 present in the list? : " + list.search(5));
    }
}
