package com.rohan.dsa.foundations.sorting;

/**
 * Partition Exchange Algorithm
 * <p>
 * <p>
 * Time Complexity: O(nlogn)
 * <p>
 * Reference:
 * https://www.youtube.com/watch?v=QN9hnmAgmOc&list=PLdo5W4Nhv31bbKJzrsKfMpo_grxuLl8LU&index=100
 */
public class QuickSort {
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int lowerBound, int upperBound) {

        if (lowerBound < upperBound) {
            int location = partition(arr, lowerBound, upperBound);
            quickSort(arr, lowerBound, location - 1);
            quickSort(arr, location + 1, upperBound);
        }
    }

    private int partition(int[] arr, int lowerBound, int upperBound) {
        int pivot = arr[lowerBound];
        int start = lowerBound;
        int end = upperBound;
        while (start <= end) {

            while (start <= end && arr[start] <= pivot) {
                start++;
            }

            while (end >= start && arr[end] > pivot) {
                end--;
            }

            if (start < end) {
                swap(arr, start, end);
            }
        }

        // Here start is greater than end, Now we swap the pivot index (lowerBound)
        // with end index (partition point)
        swap(arr, lowerBound, end);
        return end;
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] arr = {11, 19, 0, -1, 5, 6, 16, -3, 6, 0, 14, 18, 7, 21, 18, -6, -8};
        //int[] arr = {7, 6, 10, 5, 9, 2, 1, 15, 7};
        qs.quickSort(arr);
        qs.printArray(arr);
    }
}
