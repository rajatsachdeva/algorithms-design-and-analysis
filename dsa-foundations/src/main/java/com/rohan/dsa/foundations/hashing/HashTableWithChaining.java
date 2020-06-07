package com.rohan.dsa.foundations.hashing;

import java.util.NoSuchElementException;

/**
 * Chaining is a possible way to resolve collisions. Each slot of the array
 * contains a link to a singly-linked list containing key-value pairs with
 * the same hash. New key-value pairs are added to the end of the list.
 * Lookup algorithm searches through the list to find matching key.
 * Initially table slots contain nulls. List is being created, when value
 * with the certain hash is added for the first time.
 */
public class HashTableWithChaining {
    private final int tableSize;
    private LinkedHashEntry[] table;
    private int size;

    public HashTableWithChaining(int tableSize) {
        this.tableSize = tableSize;
        size = 0;
        table = new LinkedHashEntry[tableSize];
        for (int i = 0; i < this.tableSize; i++) {
            table[i] = null;
        }
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < tableSize; i++) {
            table[i] = null;
        }
    }

    public void put(int key, int value) {
        int hashIndex = hash(key);

        if (table[hashIndex] == null) {
            table[hashIndex] = new LinkedHashEntry(key, value);
            size++;
        } else {
            LinkedHashEntry entry = table[hashIndex];
            while (entry.next != null && entry.key != key) {
                entry = entry.next;
            }
            // Update the value of exiting key
            if (entry.key == key) {
                entry.value = value;
            } else {
                entry.next = new LinkedHashEntry(key, value);
                size++;
            }
        }
    }

    public int get(int key) {
        int hashIndex = hash(key);
        if (table[hashIndex] == null) {
            return -1;
        } else {
            LinkedHashEntry entry = table[hashIndex];

            // Important that we check whether the entry is null
            while (entry != null && entry.key != key) {
                entry = entry.next;
            }
            if (entry == null) {
                return -1;
            } else {
                return entry.value;
            }
        }
    }

    public void remove(int key) {
        int hashIndex = hash(key);

        LinkedHashEntry current = table[hashIndex];
        if (current == null) {
            throw new NoSuchElementException();
        }
        LinkedHashEntry previous = null;

        while (current.next != null && current.key != key) {
            previous = current;
            current = current.next;
        }
        if (current.key == key) {
            // If it was the first element or the only element
            if (previous == null) {
                table[hashIndex] = current.next;
            } else {
                previous.next = current.next;
            }
            size--;
        }
    }

    private int hash(int key) {
        return key % tableSize;
    }

    private static class LinkedHashEntry {
        private int key;
        private int value;
        private LinkedHashEntry next;

        LinkedHashEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "LinkedHashEntry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
