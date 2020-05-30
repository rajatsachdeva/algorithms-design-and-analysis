package com.rohan.dsa.foundations.heap;

import java.util.Arrays;
import java.util.Vector;

/**
 * Max value is the highest priority. Implemented using MaxHeap
 * <p>
 * Index is 0 based for vectors...
 */
public class PriorityQueue {

    private Vector<Integer> heap;

    public PriorityQueue(int capacity) {
        this.heap = new Vector<>(capacity);
    }

    // TODO: Simplify this
    public void add(int data) {
        heap.addElement(data);

        int current = heap.size() - 1;

        while (current > 0) {
            int parentIndex = parent(current);
            if (heap.get(current) > heap.get(parentIndex)) {
                swap(current, parentIndex);
                current = parentIndex;
            } else {
                return;
            }
        }
    }

    public int poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty!");
        }

        int rootValue = heap.firstElement();
        heap.setElementAt(heap.lastElement(), 0);
        heap.removeElementAt(size() - 1);

        maxHeapify(0); // root

        return rootValue;
    }

    public void maxHeapify(int index) {

        int largest = index;
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);

        // "<" because the heap goes from 0 to n - 1
        if (leftIndex < size() && heap.get(leftIndex) > heap.get(largest)) {
            largest = leftIndex;
        }

        if (rightIndex < size() && heap.get(rightIndex) > heap.get(largest)) {
            largest = rightIndex;
        }

        if (largest != index) {
            swap(largest, index);
            maxHeapify(largest);
        }
    }

    public int peek() {
        if (size() == 0) {
            throw new IllegalStateException("PQ is Empty");
        }
        return heap.firstElement();
    }

    public int size() {
        return heap.size();
    }

    private boolean isEmpty() {
        return heap.isEmpty();
    }

    public boolean contains(int value) {
        return heap.contains(value);
    }

    public Integer[] toArray() {
        return heap.toArray(new Integer[heap.size()]);
    }

    public void clear() {
        System.out.print("Emptying queue: ");
        while (!heap.isEmpty()) {
            System.out.print(poll() + " ");
        }
        System.out.println();
    }

    private int parent(int index) {
        if (index == 0) {
            return 0;
        }

        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return (2 * index) + 1;
    }

    private int rightChild(int index) {
        return (2 * index) + 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.elementAt(index1);
        heap.setElementAt(heap.get(index2), index1);
        heap.setElementAt(temp, index2);
    }

    public static void main(String[] args) {
        // create a Priority Queue of initial capacity 10
        // Priority of an element is decided by element's value
        PriorityQueue pq = new PriorityQueue(10);

        // insert three integers
        pq.add(3);
        pq.add(2);
        pq.add(15);

        // print Priority Queue size
        System.out.println("Priority Queue Size is " + pq.size());

        // search 2 in Priority Queue
        Integer searchKey = 2;

        if (pq.contains(searchKey)) {
            System.out.println("Priority Queue contains " + searchKey + "\n");
        }

        // empty queue
        pq.clear();

        if (pq.isEmpty()) {
            System.out.println("Queue is Empty");
        }

  /*
        // Below will throw exception!

        System.out.println("\nCalling remove operation on an empty heap");
        System.out.println("Element with highest priority is " + pq.poll() + '\n');

        System.out.println("Calling peek operation on an empty heap");
        System.out.println("Element with highest priority is " + pq.peek() + '\n');*/

        // again insert three integers
        pq.add(5);
        pq.add(4);
        pq.add(45);

        // construct array containing all elements present in the queue
        Integer[] I = pq.toArray();
        System.out.println("Printing array: " + Arrays.toString(I));

        System.out.println("\nElement with highest priority is " + pq.poll());
        System.out.println("Element with highest priority is " + pq.peek());
    }
}
