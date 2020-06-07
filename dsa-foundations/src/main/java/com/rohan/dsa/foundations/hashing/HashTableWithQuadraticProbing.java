package com.rohan.dsa.foundations.hashing;

/**
 * Quadratic Probing means Insert K(i) at first free location from (u + (i * i)) % m
 * where i = 0 to m - 1 and m is the max range.
 */
public class HashTableWithQuadraticProbing {

    private String[] keys;
    private String[] values;
    private int currentSize;
    private final int maxSize;

    public HashTableWithQuadraticProbing(int capacity) {
        currentSize = 0;
        maxSize = capacity;
        keys = new String[maxSize];
        values = new String[maxSize];
    }

    public void clear() {
        currentSize = 0;
        keys = new String[maxSize];
        values = new String[maxSize];
    }


    public boolean isFull() {
        return currentSize == maxSize;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        return currentSize;
    }

    public void put(String key, String value) {
        int hashIndex = hash(key);
        int u = hashIndex; // Calculated location
        int i = 1;

        do {
            // Not existing
            if (keys[u] == null) {
                keys[u] = key;
                values[u] = value;
                currentSize++;
                return;
            }

            // Existing
            if (keys[u].equals(key)) {
                values[u] = value;
                return;
            }

            // Quadratic Probing
            u = (u + (i * i)) % maxSize;
            i++;
        } while (u != hashIndex);
    }

    public String get(String key) {
        int u = hash(key);
        int i = 1;
        while (keys[u] != null) {
            if (keys[u].equals(key)) {
                return values[u];
            }
            // Quadratic Probing
            u = (u + (i * i)) % maxSize;
            i++;
        }
        return null;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public void remove(String key) {

        if (!contains(key)) {
            return;
        }

        int u = hash(key); // Location
        int i = 1;

        while (!key.equals(keys[u])) {
            u = (u + (i * i)) % maxSize;
            i++;
        }

        // Found location
        keys[u] = null;
        values[u] = null;

        // Rehash all the keys in same cluster
        u = (u + i * i) % maxSize;
        i++;
        while (keys[u] != null) {

            String keyToRehash = keys[u];
            String valueToRehash = values[u];
            keys[u] = null;
            values[u] = null;
            currentSize--;
            put(keyToRehash, valueToRehash);

            u = (u + (i * i)) % maxSize;
            i++;
        }
        currentSize--;
    }

    public void printHashTable() {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null)
                System.out.println(keys[i] + " " + values[i]);
        System.out.println();
    }

    private int hash(String key) {
        return key.hashCode() % maxSize;
    }

}
