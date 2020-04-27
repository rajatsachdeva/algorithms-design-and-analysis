package com.rohan.dsa.foundations.array;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 */
public class UnorderedArray {

    private int[] arr;
    private int numElements;
    private int capacity;

    public UnorderedArray(int capacity) {
        this.arr = new int[capacity];
        this.numElements = 0;
        this.capacity = capacity;
    }

    public void insert(int element) {
        if (numElements >= capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        arr[numElements] = element;
        numElements++;
    }

    public boolean search(int element) {
        return -1 != getElementIndex(element);
    }

    private int getElementIndex(int element) {
        for (int i = 0; i < numElements; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int element) {
        if (numElements == 0) {
            throw new RuntimeException("Nothing to delete..");
        }
        int deleteIndex = getElementIndex(element);
        deleteAtIndex(deleteIndex);
    }

    private void deleteAtIndex(int deleteIndex) {
        if (deleteIndex == -1) {
            throw new RuntimeException("Not found");
        }

        for (int i = deleteIndex; i < numElements - 1; i++) {
            arr[i] = arr[i + 1];
        }

        numElements--;
    }


    public void display() {
        display(arr, numElements);
    }

    public static void display(int[] arr, int numElements) {
        for (int i = 0; i < numElements; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    /**
     * A method called getMax() that returns the value of the highest key in the array,
     * or –1 if the array is empty.
     *
     * @return
     */
    public int getMax() {
        if (numElements == 0) {
            return -1;
        }

        int max = 0;
        for (int i = 1; i < numElements; i++) {
            if (arr[max] <= arr[i]) {
                max = i;
            }
        }
        return max;
    }

    public int valueAt(int index) {
        if (index < 0 || index > capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[index];
    }

    public int removeMax() {
        int maxIndex = getMax();
        int maxIndexValue = valueAt(maxIndex);
        deleteAtIndex(maxIndex);
        return maxIndexValue;
    }

    // Naive Way
    public void noDups() {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < numElements; i++) {
            set.add(arr[i]);
        }
        arr = set.stream()
                .mapToInt(Integer::intValue).toArray();
        numElements = set.size();
    }

    public int length() {
        return numElements;
    }

    public static int[] sort(final UnorderedArray array) {

        int[] sortedArray = new int[array.length()];
        int i = array.length() - 1;
        while (array.length() != 0) {
            int element = array.removeMax();
            sortedArray[i] = element;
            i--;
        }
        return sortedArray;
    }

    public static void main(String[] args) {

        UnorderedArray array = new UnorderedArray(20);

        array.insert(23);
        array.insert(22);
        array.insert(1);
        array.insert(3);
        array.insert(233);

        array.display();

        System.out.println("found 1 ? " + array.search(1));
        System.out.println("found 23 ? " + array.search(23));

        array.delete(3);
        array.display();

        int maxIndex = array.getMax();
        System.out.println("Max value in an array: " + array.valueAt(maxIndex));

        final int maxRemovedValue = array.removeMax();
        System.out.println("Maximum value removed: " + maxRemovedValue);

        array.display();

        array.insert(1);
        array.insert(1);
        array.insert(2);
        array.insert(2);
        array.insert(3);

        array.display();
        array.noDups();
        array.display();

        final int[] sortedArray = UnorderedArray.sort(array);
        UnorderedArray.display(sortedArray, sortedArray.length);
    }
}
