package com.rohan.dsa.foundations.sorting;

import java.util.Arrays;

public class RadixSort {

    private static void radixSort(int[] arr) {

        // Get max number to know the max number of digits
        int max = getMax(arr);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, posituin is passed. position is 10^i
        // where i is current digit number
        for (int pos = 1; (max / pos) > 0; pos *= 10) {
            countingSort(arr, pos);
        }
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    private static void countingSort(int[] arr, int position) {
        int[] count = new int[10];
        int N = arr.length;
        int[] auxArr = new int[N];

        Arrays.fill(count, 0);

        // Create frequency table
        for (int i = 0; i < N; i++) {
            count[digitAtPosition(arr[i], position)] += 1;
        }

        // Convert to position table
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Move items to auxillary array
        for (int i = N - 1; i >= 0; i--) {
            int insertIndex = --count[digitAtPosition(arr[i], position)];
            auxArr[insertIndex] = arr[i];
        }

        // Copy
        for (int i = 0; i < N; i++) {
            arr[i] = auxArr[i];
        }
    }

    private static int digitAtPosition(int value, int position) {
        return (value / position) % 10;
    }

    private static void print(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        print(arr);
    }
}
