package com.rohan.dsa.foundations.sorting;

import java.util.Arrays;

/**
 * Time Complexity : O (N + R)
 * Space Complexity : O (N + R)
 */
public class CountingSort {

    public int[] countingSort(int[] arr, int range) {

        int[] count = new int[range + 1];
        int[] sorted = new int[arr.length];

        // Create Frequency Table
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] += 1;
        }

        // Convert to positions
        for (int i = 1; i <= range; i++) {
            count[i] = count[i] + count[i - 1];
        }

        // Move items to the auxillary array
        for (int i = arr.length - 1; i >= 0; i--) {
            int insertIndex = --count[arr[i]];
            sorted[insertIndex] = arr[i];
        }

        return sorted;
    }

    private static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(v -> System.out.print(v + " "));
    }

    public static void main(String[] args) {
        int[] input = {2, 1, 1, 0, 2, 5, 4, 0, 2, 8, 7, 7, 9, 2, 0, 1, 9};
        int range = 9;
        printArray(new CountingSort().countingSort(input, range));
    }
}
