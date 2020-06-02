package com.rohan.dsa.foundations.sorting;

import java.util.Arrays;

/**
 * Idea:-
 * <p>
 * - Array will be divided into 2 logical separation - sorted and unsorted
 * - Initially, sorted would be empty and unsorted would be the complete size
 * - We will find min element from the unsorted array
 * - min element would be added to the sorted array (swap)
 * <p>
 * Here Number of passes = Number of elements - 1;
 *
 * <p>
 * Time Complexity:-
 * <p>
 * Best Case: O(n^2)
 * Worst Case: O(n^2)
 */
public class SelectionSort {


    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // till "n" because we scan the complete list every time
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            // If min is changed
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }


    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] arr = {7, 4, 10, 8, 3, 1};
        selectionSort.sort(arr);
        Arrays.stream(arr).forEach(v -> System.out.print(v + " "));
    }


}
