package com.rohan.dsa.foundations.array;

public class OrderedArray {

    private int[] arr;
    private int numElements;
    private int capacity;

    public OrderedArray(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.numElements = 0;
    }

    // Naive
    public void insert(int element) {

        // Search location where to insert
        int i;
        for (i = 0; i < numElements; i++) {
            if (element < arr[i]) {
                break;
            }
        }

        // Finally insert at the search location
        for (int j = numElements - 1; j >= i; j--) {
            arr[j + 1] = arr[j];
        }
        arr[i] = element;
        numElements++;
    }

    public int search(int element) {
        int beg = 0;
        int last = numElements - 1;
        int mid;
        while (true) {
            mid = (beg + last) / 2;
            if (arr[mid] == element) {
                return mid;
            } else if (beg > last) {
                break;
            } else {
                if (arr[mid] < element) {
                    // It is present in the next half
                    beg = mid + 1;
                } else {
                    last = mid - 1;
                }
            }
        }
        return -1;
    }

    public void delete(int element) {
        int deleteIndex = search(element);
        if (deleteIndex == -1) {
            throw new RuntimeException("Not found");
        }

        for (int i = deleteIndex; i < numElements; i++) {
            arr[i] = arr[i + 1];
        }
        numElements--;
    }

    public void display() {
        for (int i = 0; i < numElements; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    // What if already existing
    void insertAt(int index, int element) {
        arr[index] = element;
        numElements++;
    }

    int at(int index) {
        return arr[index];
    }

    public int length() {
        return numElements;
    }

    public static OrderedArray merge(OrderedArray array1, OrderedArray array2) {

        int array1Length = array1.length();
        int array2Length = array2.length();

        OrderedArray orderedArray = new OrderedArray((array1Length + array2Length) * 2); // Convenience

        int i = 0, j = 0, k = 0;
        while (i < array1Length && j < array2Length) {
            final int elementFromArray1 = array1.at(i);
            final int elementFromArray2 = array2.at(j);
            if (elementFromArray1 < elementFromArray2) {
                orderedArray.insertAt(k, elementFromArray1);
                i++;
            } else {
                orderedArray.insertAt(k, elementFromArray2);
                j++;
            }
            k++;
        }

        while (i < array1Length) {
            orderedArray.insertAt(k, array1.at(i));
            i++;
            k++;
        }

        while (j < array2Length) {
            orderedArray.insertAt(k, array2.at(j));
            j++;
            k++;
        }

        return orderedArray;
    }

    public static void main(String[] args) {
        OrderedArray orderedArray = new OrderedArray(10);

        orderedArray.insert(10);
        orderedArray.insert(9);
        orderedArray.insert(8);
        orderedArray.insert(6);
        orderedArray.insert(5);
        orderedArray.insert(4);

        orderedArray.display();
        orderedArray.insert(7);
        orderedArray.display();

        orderedArray.delete(9);
        orderedArray.display();

        final int searchIndex = orderedArray.search(5);
        if (searchIndex != -1) {
            System.out.println("found at " + searchIndex);
        } else {
            System.out.println("Not found!");
        }

        OrderedArray arr1 = new OrderedArray(5);
        arr1.insert(1);
        arr1.insert(2);
        arr1.insert(3);
        arr1.insert(4);
        arr1.display();

        OrderedArray arr2 = new OrderedArray(5);
        arr2.insert(5);
        arr2.insert(6);
        arr2.insert(7);
        arr2.insert(8);
        arr2.display();

        OrderedArray mergedArray = OrderedArray.merge(arr1, arr2);
        mergedArray.display();
    }
}
