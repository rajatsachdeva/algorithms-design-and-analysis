package com.rohan.dsa.foundations.sorting;


/**
 * Test cases
 * 1 element
 * 2 element
 * negative numbers
 * already sorted
 * reverse sorted
 * <p>
 * Time Complexity: O(nlogn)
 * <p>
 * Reference:-
 * http://en.wikipedia.org/wiki/Merge_sort
 * https://www.youtube.com/watch?v=jlHkDBEumP0
 */
public class MergeSort {

    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int lb, int ub) {
        if (lb < ub) {
            int mid = (lb + ub) / 2;
            mergeSort(arr, lb, mid);
            mergeSort(arr, mid + 1, ub);
            merge(arr, lb, mid, ub);
        }
    }

    private void merge(int[] arr, int lb, int mid, int ub) {

        int i = lb;
        int j = mid + 1;
        int k = lb;
        int[] temp = new int[lb + ub + 1];

        while (i <= mid && j <= ub) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        while (j <= ub) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        for (int m = lb; m <= ub; m++) {
            arr[m] = temp[m];
        }
    }

    public void printArray(int[] input) {
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int input1[] = {1};
        int input2[] = {4, 2};
        int input3[] = {6, 2, 9};
        int input4[] = {6, -1, 10, 4, 11, 14, 19, 12, 18};
        MergeSort ms = new MergeSort();
        ms.mergeSort(input1);
        ms.mergeSort(input2);
        ms.mergeSort(input3);
        ms.mergeSort(input4);

        ms.printArray(input1);
        ms.printArray(input2);
        ms.printArray(input3);
        ms.printArray(input4);
    }

}
