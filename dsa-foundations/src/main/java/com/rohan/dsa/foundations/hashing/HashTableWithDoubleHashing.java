package com.rohan.dsa.foundations.hashing;


/**
 * A hash table uses a hash function to compute an index into an array of
 * buckets or slots, from which the correct value can be found.
 * <p>
 * Double Hashing is a probe sequence in which the interval between probes
 * is computed by another hash function
 */
public class HashTableWithDoubleHashing {

    private static final int PRIME = 7;
    private final int tableSize;
    private HashEntry[] table;
    private int currentSize;

    public HashTableWithDoubleHashing(int tableSize) {
        this.tableSize = tableSize;
        table = new HashEntry[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = null;
        }
    }

    public int getSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void clear() {
        currentSize = 0;
        for (int i = 0; i < tableSize; i++) {
            table[i] = null;
        }
    }

    public boolean isFull() {
        return currentSize == tableSize;
    }

    public void put(String key, int value) {
        if (isFull()) {
            throw new RuntimeException("Hashtable is full");
        }

        int hash1 = hash1(key); // u
        int hash2 = hash2(key); // v

        while (table[hash1] != null) {
            hash1 += hash2;
            hash1 %= tableSize;
        }

        table[hash1] = new HashEntry(key, value);
        currentSize++;
    }


    public int get(String key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        while (table[hash1] != null && !table[hash1].key.equals(key)) {
            hash1 += hash2;
            hash1 %= tableSize;
        }

        return table[hash1].value;
    }


    public void remove(String key) {

        int hash1 = hash1(key);
        int hash2 = hash2(key);

        while (table[hash1] != null && !table[hash1].key.equals(key)) {
            hash1 += hash2;
            hash1 %= tableSize;
        }
        table[hash1] = null;
        currentSize--;
    }

    private int hash1(String key) {
        return key.hashCode() % tableSize;
    }

    private int hash2(String key) {
        return PRIME - (key.hashCode() % tableSize) % PRIME;
    }

    public void printHashTable() {
        System.out.println("\nHash Table");
        for (int i = 0; i < tableSize; i++)
            if (table[i] != null)
                System.out.println(table[i].key + " " + table[i].value);
    }

    private class HashEntry {
        private String key;
        private int value;

        HashEntry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
