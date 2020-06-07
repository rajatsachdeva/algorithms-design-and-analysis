package com.rohan.dsa.foundations.hashing;

import java.util.NoSuchElementException;

/**
 * This is a Java Program to implement hash tables. A hash table (also hash map)
 * is a data structure used to implement an associative array, a structure that
 * can map keys to values. A hash table uses a hash function to compute an index
 * into an array of buckets or slots, from which the correct value can be found.
 */
public class BasicHashTable {
    private int[] arr;
    private int capacity;

    public BasicHashTable(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public void insert(int element) {
        int hashedIndex = hash(element);
        arr[hashedIndex] = element;
    }

    public boolean contains(int element) {
        int hashedIndex = hash(element);
        return arr[hashedIndex] == element;
    }

    public void delete(int element) {
        int hashIndex = hash(element);

        if (arr[hashIndex] != element) {
            throw new NoSuchElementException();
        }
        arr[hashIndex] = element;
    }

    public void clear() {
        this.arr = new int[capacity];
    }

    private int hash(int element) {
        return element % capacity;
    }
}
