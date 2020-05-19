package com.rohan.dsa.foundations.heap;

/**
 * This implementation is fixed size.
 * <p>
 * FIXME: Check boundary conditions, to be checked on refactoring.
 */
public class MaxBinaryHeap {

    private final static int ROOT_INDEX = 1;

    private int[] heap;
    private int size;
    private int capacity;

    public MaxBinaryHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    public void insert(int value) {
        size++;
        heap[size] = value;
        int currentIndex = size;

        while (currentIndex > 1) {
            int parentIndex = parent(currentIndex);
            if (heap[parentIndex] < heap[currentIndex]) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                return;
            }
        }
    }

    public int remove() {
        if (size() == 0) {
            throw new IllegalStateException("Heap Underflow");
        }

        int headValue = heap[1];
        heap[1] = heap[size - 1];
        size--;

        maxHeapify(1);
        return headValue;
    }

    private void maxHeapify(int index) {

        int largestIndex = index;
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);

        // "<=" because the heap goes from 1 to n
        if (leftIndex <= size() && heap[leftIndex] > heap[largestIndex]) {
            largestIndex = leftIndex;
        }

        if (rightIndex <= size() && heap[rightIndex] > heap[largestIndex]) {
            largestIndex = rightIndex;
        }

        if (largestIndex != index) {
            swap(largestIndex, index);
            maxHeapify(largestIndex);
        }
    }

    public void delete() {
        heap = null;
    }

    public void print() {
        // size /2 mean we go till last non leaf node.
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " +
                    heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return (2 * index);
    }

    private int rightChild(int index) {
        return (2 * index) + 1;
    }

    private int size() {
        return size;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public static void main(String[] args) {
        System.out.println("The Max Heap is ");
        MaxBinaryHeap maxHeap = new MaxBinaryHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        System.out.println("The max val is " + maxHeap.remove());
    }
}
