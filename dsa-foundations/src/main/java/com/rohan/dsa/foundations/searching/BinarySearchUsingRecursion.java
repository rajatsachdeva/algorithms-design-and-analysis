package com.rohan.dsa.foundations.searching;

public class BinarySearchUsingRecursion {

    public int binarySearch(int[] arr, int key, int min, int max) {
        if (max <= min) {
            return -1;
        } else {
            int mid = (min + max) / 2;

            if (arr[mid] < key) {
                binarySearch(arr, key, mid + 1, max);
            } else if (arr[mid] > key) {
                binarySearch(arr, key, min, mid - 1);
            } else {
                return mid;
            }
        }

        return -1;
    }

}
