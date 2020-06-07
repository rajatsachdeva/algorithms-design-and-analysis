package com.rohan.dsa.foundations.hashing;

/**
 * A very simple hash table example. It uses simple hash function, collisions
 * are resolved using linear probing (open addressing strategy) and hash table
 * has constant size.
 * <p>
 * This example clearly shows the basics of hashing technique.
 * <p>
 * Linear probing is applied to resolve collisions. In case the slot,
 * indicated by hash function, has already been occupied, algorithm
 * tries to find an empty one by probing consequent slots in the array.
 * <p>
 * Note. Linear probing is not the best technique to be used when table
 * is of a constant size. When load factor exceeds particular value (appr. 0.7),
 * hash table performance will decrease non-linearly.
 * Also, the number of stored key-value pairs is limited to the size of
 * the table (128).
 * <p>
 * This implementation suffers onelimitation. When there is no more place in the table,
 * the loop, searching for empty slot, will run throw an exception.
 */

public class HashTableWithLinearProbing {

    private final static int TABLE_SIZE = 10;

    private HashEntry[] table;
    private int size;

    public HashTableWithLinearProbing() {
        table = new HashEntry[TABLE_SIZE];

        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }

    public void clear() {
        table = new HashEntry[TABLE_SIZE];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == TABLE_SIZE;
    }

    public void put(int key, int value) {
        int hashIndex = hash(key);
        int i = hashIndex;
        boolean isSet = false;
        // Search for the next available element or for the next matching key
        do {
            // Not existing
            if (table[i] == null) {
                table[i] = new HashEntry(key, value);
                size++;
                isSet = true;
                break;
            }

            // Update existing
            if (table[i].key == key) {
                table[i].value = value;
                isSet = true;
                break;
            }

            // Linearly probing to find available slot
            i = (i + 1) % TABLE_SIZE;
        } while (i != hashIndex);

        if (!isSet) {
            throw new RuntimeException("No available slots");
        }
    }

    public int get(int key) {
        int hashIndex = hash(key);
        while (table[hashIndex] != null) {
            if (table[hashIndex].key == key) {
                return table[hashIndex].value;
            }
            hashIndex = (hashIndex + 1) % TABLE_SIZE;
        }
        return -1;
    }

    public boolean contains(int key) {
        return get(key) != -1;
    }

    public void remove(int key) {
        if (!contains(key)) {
            return;
        }

        // Find the position and delete
        int hashIndex = hash(key);
        while (table[hashIndex].key != key) {
            hashIndex = (hashIndex + 1) % TABLE_SIZE;
        }

        // Delete the associated entry (key and value)
        table[hashIndex] = null;

        // Rehash all the keys in same cluster
        int i = hashIndex;
        i = (i + 1) % TABLE_SIZE;
        while (table[i] != null) {

            HashEntry entryToRehash = table[i];
            size--;
            put(entryToRehash.key, entryToRehash.value);
            i = (i + 1) % TABLE_SIZE;
        }
        size--;
    }

    private int hash(int key) {
        return key % TABLE_SIZE;
    }

    class HashEntry {
        private int key;
        private int value;

        HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }


        @Override
        public String toString() {
            return "HashEntry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
