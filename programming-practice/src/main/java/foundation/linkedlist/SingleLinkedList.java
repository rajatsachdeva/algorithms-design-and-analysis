package foundation.linkedlist;

import utilities.SListNode;

import java.util.NoSuchElementException;

public class SingleLinkedList<T> implements LinkedListOperations<T> {

    private int size;
    private SListNode<T> head;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return head == null;
    }

    @Override
    public T valueAt(int index) {

        if (index < 0) {
            throw new IllegalArgumentException();
        }

        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        SListNode<T> current = head;
        for (int pos = 0; pos <= index; pos++) {
            current = current.next();
        }

        return current.data();
    }

    @Override
    public void pushFront(T value) {
        SListNode<T> newNode = new SListNode<>(value);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    @Override
    public void pushBack(T value) {
        SListNode<T> newNode = new SListNode<>(value);
        if (head == null) {
            head = newNode;
        } else {
            SListNode<T> current = head;
            while (current.next() != null) {
                current = current.next();
            }
            current.setNext(newNode);
        }
        size++;
    }

    @Override
    public T popFront() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        SListNode<T> front = head;
        head = head.next();

        size--;
        return front.data();
    }

    @Override
    public T popBack() {

        if (head == null) {
            throw new NoSuchElementException();
        }

        SListNode<T> prev = head;
        SListNode<T> current = head;
        while (current.next() != null) {
            prev = current;
            current = current.next();
        }
        prev.setNext(null);

        size--;
        return current.data();
    }

    @Override
    public T front() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        return head.data();
    }

    @Override
    public T back() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        SListNode<T> current = head;
        while (current.next() != null) {
            current = current.next();
        }
        return current.data();
    }

    @Override
    public void insert(int index, T value) {

        if (index < 0) {
            throw new IllegalArgumentException();
        }

        if (index > size()) {
            throw new IndexOutOfBoundsException();
        }

        SListNode<T> newNode = new SListNode<>(value);
        if (head == null) {
            head = newNode;
        } else {
            if (index == 0) {
                newNode.setNext(head);
                head = newNode;
            } else {
                SListNode<T> prev = head;
                SListNode<T> current = head;
                for (int i = 0; i < index; i++) {
                    prev = current;
                    current = current.next();
                }

                newNode.setNext(prev.next());
                prev.setNext(newNode);
            }
        }
        size++;
    }

    @Override
    public void erase(int index) {

        if (index < 0) {
            throw new IllegalArgumentException();
        }

        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (head == null) {
            throw new NoSuchElementException();
        }

        if (index == 0) {
            head = head.next();
        } else {
            SListNode<T> current = head;
            SListNode<T> prev = head;
            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next();
            }
            prev.setNext(current.next());
        }
        size--;
    }

    @Override
    public void removeValue(T value) {
        SListNode<T> current = head;
        SListNode<T> prev = head;
        while (current != null) {
            if (current.data().equals(value)) {
                if (head == current) {
                    head = head.next();
                } else {
                    prev.setNext(current.next());
                }
                size--;
                break;
            }
            prev = current;
            current = current.next();
        }
    }

    @Override
    public void printList() {
        System.out.println(toString());
    }

    @Override
    public void reverse() {
        SListNode<T> prev = null;
        SListNode<T> current = head;
        while (current != null) {
            SListNode<T> next = current.next();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }

    @Override
    public void reverseUsingRecursion() {
        // TODO
    }

    @Override
    public T nthValueFromEnd(int n) {

        SListNode<T> main = head;
        SListNode<T> ref = head;
        int count = 0;

        while (count < n) {
            ref = ref.next();
            count++;
        }

        while (ref != null) {
            main = main.next();
            ref = ref.next();
        }

        return main.data();
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        list.append("[");

        SListNode<T> current = head;
        while (current != null) {
            list.append(current.data());
            current = current.next();
            if (current != null) {
                list.append(",");
            }
        }
        return list.append("]").toString();
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
    }

}