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
        arr[nElems] = element;
        nElems++;
    }

    private void expand() {
        int[] temp = new int[capacity * 2];
        for (int i = 0; i < nElems; i++) {
            temp[i] = arr[i];
        }
        arr = null;
        arr = temp;
    }

    
    public boolean delete (int index) {


        return false;
    }

    private void shrink() {
    }

    public void display() {
    }
}
