package com.rohan.dsa.foundations.linkedlist;

public class DoubleLinkedList {

    private DNode head;
    private DNode tail;
    private int size;

    public DoubleLinkedList(int initialValue) {
        DNode newNode = new DNode(initialValue);
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public int getSize() {
        return size;
    }

    public void insertFirst(int data) {
        insertAt(data, 0);
    }


    public void insertLast(int data) {
        insertAt(data, size);
    }

    public void insertAt(int data, int location) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            if (location == 0) {
                newNode.setNext(head);
                head.setPrev(newNode);
                head = newNode;
            } else if (location == size) {
                newNode.setPrev(tail);
                tail.setNext(newNode);
                tail = newNode;
            } else {
                DNode temp = head;
                // Go to the node before you selected location
                for (int i = 0; i < location - 1; i++) {
                    temp = temp.getNext();
                }
                newNode.setPrev(temp);
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);
                newNode.getNext().setPrev(newNode);
            }
        }
        size++;
    }

    // Traverse
    public void display() {

        if (head == null) {
            return;
        }

        DNode temp = head;
        while (temp.getNext() != null) {
            System.out.print(temp + " <-> ");
            temp = temp.getNext();
        }
        System.out.print(temp);
        System.out.println("");
    }

    public void reverseDisplay() {
        if (tail == null) {
            return;
        }

        DNode temp = tail;
        while (temp.getPrev() != null) {
            System.out.print(temp + " <-> ");
            temp = temp.getPrev();
        }
        System.out.print(temp);
        System.out.println("");
    }


    public void delete() {
        DNode temp = head;
        while (temp != null) {
            temp.setPrev(null);
            temp = temp.getNext();
        }
        head = tail = null;
    }


    public void deleteFirst() {

        if (head == null) {
            throw new RuntimeException("Nothing to delete");
        }

        // Only element
        if (head.getNext() == null) {
            head = null;
            tail = null;

        } else {
            DNode firstNode = head;
            DNode secondNode = head.getNext();
            head = secondNode;
            secondNode.setPrev(null);
            firstNode.setNext(null);
        }
        size--;
    }

    public void deleteLast() {

        if (head == null) {
            throw new RuntimeException("Nothing to delete");
        }

        if (head.getNext() == null) {
            head = null;
            tail = null;
        }

        // Lets go to the  last node
        DNode lastNode = head;
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }
        DNode secondLastNode = lastNode.getPrev();
        secondLastNode.setNext(null);
        lastNode.setPrev(null);
        tail = secondLastNode;
        size--;
    }

    public void deleteAt(int location) {
        if (head == null) {
            throw new RuntimeException("Nothing to delete");
        }

        if (location == 0) {
            deleteFirst();
        } else if (location == size) {
            deleteLast();
        } else {
            // Go to the node before selected node
            DNode nodeBefore = head;
            for (int i = 0; i < location - 1; i++) {
                nodeBefore = nodeBefore.getNext();
            }

            DNode node = nodeBefore.getNext();
            DNode nodeAfter = node.getNext();
            nodeBefore.setNext(nodeAfter);
            nodeAfter.setPrev(nodeBefore);
            node.setPrev(null);
            node.setNext(null);
        }
        size--;
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList(20);
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
        list.reverseDisplay();
        list.deleteFirst();
        list.display();
        list.deleteLast();
        list.display();
        System.out.println("Linked list size: " + list.getSize());
        list.deleteAt(2);
        list.display();
    }

}
