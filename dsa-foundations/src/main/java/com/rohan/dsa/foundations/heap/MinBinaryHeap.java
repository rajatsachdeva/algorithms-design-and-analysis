package com.rohan.dsa.foundations.heap;

public class MinBinaryHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinBinaryHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity + 1];
        this.heap[0] = Integer.MIN_VALUE;
    }

    public void insert(int data) {
        if (isFull()) {
            throw new IllegalStateException("Heap Overflow");
        }

        size++;
        heap[size] = data;

        int current = size;
        while (current > 1) {
            int parentIndex = parent(current);
            if (heap[current] < heap[parentIndex]) {
                swap(current, parentIndex);
                current = parentIndex;
            } else {
                return;
            }
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

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public int remove() {

        if (isEmpty()) {
            throw new IllegalStateException("Heap Underflow");
        }

        int removedValue = heap[1];
        heap[1] = heap[size];
        size--;
        minHeapify(1);

        return removedValue;
    }

    private void minHeapify(int index) {

        int smallest = index;
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);

        if (leftIndex <= size && heap[leftIndex] < heap[smallest]) {
            smallest = leftIndex;
        }

        if (rightIndex <= size && heap[rightIndex] < heap[smallest]) {
            smallest = rightIndex;
        }

        if (smallest != index) {
            swap(smallest, index);
            minHeapify(smallest);
        }
    }


    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " +
                    heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }

    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        System.out.println("The Min Heap is ");
        MinBinaryHeap minHeap = new MinBinaryHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.print();

        System.out.println("The Min val is " + minHeap.remove());
    }
}
