package com.rohan.dsa.foundations.array;

import java.util.Arrays;

/**
 * Implement a dynamic array. Idea here is to store a pointer(reference) to dynamically
 * allocated array and replace it with a newly allocated array as needed
 * <p>
 * This is not a thread safe approach
 */
public class ResizableArray {

    private int currentSize;
    private int capacity;
    private int[] arr;

    public ResizableArray(int capacity) {
        this.currentSize = 0;
        this.capacity = capacity;
        arr = new int[capacity];
    }

    /**
     * This function sets the value in an array.
     *
     * @param index
     * @param val
     */
    public synchronized void setVal(int index, int val) {
        if (index < 0 || index > capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        arr[index] = val;
    }

    /**
     * This function gets the value from an array at particular index
     *
     * @param index
     * @return
     */
    public synchronized int getVal(int index) {
        if (index < 0 || index > capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[index];
    }

    /**
     * Returns current size, which is current no. of elements in an array
     *
     * @return
     */
    public synchronized int size() {
        return currentSize;
    }

    /**
     * This function pushes an element to end of an array. Also
     * update the capacity once full.
     *
     * @param val
     */
    public synchronized void pushBack(int val) {
        if (currentSize == capacity) {
            int[] temp = new int[2 * capacity];
            for (int i = 0; i < currentSize; i++) {
                temp[i] = arr[i];
            }
            arr = null;
            arr = temp;
            capacity = capacity * 2;
        }
        arr[currentSize] = val;
        currentSize++;
    }

    /**
     * Removes an element at particular index;
     *
     * @param index
     */
    public synchronized int remove(int index) {
        if (index < 0 || index > capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int removedVal = arr[index];
        for (int i = index; i < currentSize; i++) {
            arr[i] = arr[i + 1];
        }
        currentSize--;
        return removedVal;
    }

    /**
     * Pops an element from end of the array and shrinks the size of array of required.
     * @return
     */
    public synchronized int pop() {
        if (currentSize == 0) {
            throw new NegativeArraySizeException();
        }
        int element = remove(currentSize - 1);
        if (currentSize < (capacity / 2)) {
            int newCapacity = capacity / 2;
            int[] temp = new int[newCapacity];
            for (int i = 0; i < currentSize; i++) {
                temp[i] = arr[i];
            }
            arr = null;
            arr = temp;
            capacity = newCapacity;
        }
        return element;
    }

    /**
     * @param pos
     * @param val
     */
    public void insert(int pos, int val){
        for (int i = currentSize; i >= pos; i--){
            arr[i + 1] = arr[i];
        }
        arr[pos] = val;
        currentSize++;
    }

    synchronized int length() {
        return capacity;
    }

    // Test helper
    int[] getArr() {
        return Arrays.copyOf(arr, capacity);
    }
}
