package com.rohan.dsa.foundations.sorting;

import java.util.Arrays;

/**
 * Idea:-
 * <p>
 * Compare 2 adjacent values in an array. if one found greater then swap it
 * until the largest value is at the end of the array.
 * <p>
 * Normally, number of passes = number of elements - 1
 * But we can avoid unnecessary passes by prematurely exiting when no swap is done in
 * one of the pass.
 * <p>
 * Time Complexity:
 * Best Case: O(n), when already sorted
 * Worst Case: O(n^2), when in descending order
 */
public class BubbleSort {


    public void sort(int[] arr) {
        boolean swapped;
        int numElements = arr.length;
        for (int i = 0; i < numElements - 1; i++) {
            swapped = false;
            System.out.println("In Pass - " + (i + 1));
            for (int j = 0; j < numElements - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();

        int[] arr = {15, 16, 6, 8, 5};
        bubbleSort.sort(arr);
        Arrays.stream(arr).forEach(value -> System.out.print(value + " "));

        System.out.println();

        int[] arr1 = {16, 14, 5, 6, 58};
        bubbleSort.sort(arr1);
        Arrays.stream(arr1).forEach(value -> System.out.print(value + " "));

        System.out.println();

        int[] arr2 = {1, 2, 3, 4, 5, 6};
        bubbleSort.sort(arr2);
        Arrays.stream(arr2).forEach(value -> System.out.print(value + " "));

    }

}
