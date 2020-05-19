package com.rohan.dsa.foundations.sorting;

import java.util.Arrays;

// Using max binary heap
public class HeapSort {

    public void heapSort(int[] arr) {

        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, i, 0);
            maxHeapify(arr, i, 0);
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private void maxHeapify(int[] arr, int size, int index) {
        int largest = index;
        int leftIndex = (2 * index) + 1;
        int rightIndex = (2 * index) + 2;

        if (leftIndex < size && arr[leftIndex] > arr[largest]) {
            largest = leftIndex;
        }

        if (rightIndex < size && arr[rightIndex] > arr[largest]) {
            largest = rightIndex;
        }

        if (largest != index) {
            swap(arr, largest, index);
            maxHeapify(arr, size, largest);
        }
    }

    public static void main(String[] args) {

        HeapSort sorter = new HeapSort();

        int[] arr = {67, 1, 233, 32, 2, 23, 43, 98};
//        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Before");
        System.out.println(Arrays.toString(arr));

        sorter.heapSort(arr);

        System.out.println("Sorted");
        System.out.println(Arrays.toString(arr));
    }
}
