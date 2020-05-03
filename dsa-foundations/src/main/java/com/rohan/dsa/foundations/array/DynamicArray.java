package com.rohan.dsa.foundations.array;

/**
 * Unordered Array
 */
public class DynamicArray {

    private int[] arr;
    private int capacity;
    private int nElems;

    public DynamicArray(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        this.nElems = 0;
    }

    public void insert(int element) {
        if (nElems == capacity) {
            expand();
        }
        arr[nElems++] = element;
    }

    private void expand() {
        int newSize = capacity * 2;
        int[] temp = new int[newSize];
        for (int i = 0; i < nElems; i++) {
            temp[i] = arr[i];
        }
        arr = null;
        arr = temp;
    }

    public int delete(int index) {
        if (index < 0 || index > capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (nElems == 0) {
            throw new NegativeArraySizeException();
        }

        int element = remove(index);
        if (nElems < (capacity / 2)) {
            shrink();
        }
        nElems--;

        return element;
    }

    private int remove(int index) {
        int element = arr[index];
        for (int i = index; i < nElems; i++) {
            arr[i] = arr[i + 1];
        }
        return element;
    }

    private void shrink() {
        int newSize = capacity / 2;
        int[] temp = new int[newSize];
        for (int i = 0; i < nElems; i++) {
            temp[i] = arr[i];
        }
        arr = null;
        arr = temp;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
