package com.rohan.dsa.foundations.searching;

public class LinearSearch {

    public boolean search(int[] arr, int value) {
        for (int item : arr) {
            if (item == value) {
                return true;
            }
        }
        return false;
    }

    public int searchIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
