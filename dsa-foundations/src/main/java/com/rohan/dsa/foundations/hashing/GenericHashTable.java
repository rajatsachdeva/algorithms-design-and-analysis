package com.rohan.dsa.foundations.hashing;

/**
 * With the growth of hash table's load factor, number of collisions increases,
 * which leads to the decrease of overall table's performance. It is bearable for
 * hash tables with chaining, but unacceptable for hash tables based on open
 * addressing due to essential performance drop. The solution is to resize table,
 * when its load factor exceeds given threshold.
 * <p>
 * As well, when table becomes too rare, it's reasonable to pack the array in
 * order to save space.
 * <p>
 * <p>
 * Resizing algorithm:-
 * Remember, that hash values depend on table's size. Hence, hashes of entries
 * are changed when resizing and algorithm can't just copy data from old storage
 * to new one. For general hash function the only thing to do is to iterate over
 * old hash table and add each entry to a new table.
 * <p>
 * Complexity analysis:-
 * Dynamic resizing doesn't affect amortized complexity of the hash table's
 * operations. But resizing is done at once and operation, which triggers
 * resizing, takes O(n) time to complete, where n is a number of entries in
 * the table. This fact may make dynamic-sized hash tables inappropriate for
 * real-time applications.
 * <p>
 * This implementation uses a linear probing hash table and also showcases resizing
 */
public class GenericHashTable<K, V> {

    private static final int INIT_CAPACITY = 4;

    private K[] keys;
    private V[] values;
    private int capacity;//m
    private int size; //n

    public GenericHashTable() {
        this(INIT_CAPACITY);
    }

    public GenericHashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        keys = (K[]) new Object[this.capacity];
        values = (V[]) new Object[this.capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to contains() is null");
        }
        return get(key) == null;
    }

    /**
     * Inserts the specified key-value pair into the symbol table,
     * overwriting the old  value with the new value if the symbol
     * table already contains the specified key.  Deletes the specified
     * key (and its associated value) from this symbol table if the
     * specified value is {@code null}.
     *
     * @param key   the key
     * @param value the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("First argument to put() is null");
        }

        if (value == null) {
            delete(key);
            return;
        }

        // Double the size if 50% full
        if (size >= capacity / 2) {
            resize(2 * capacity);
        }

        int hashIndex = hash(key);
        while (keys[hashIndex] != null) {
            // Already existing
            if (keys[hashIndex].equals(key)) {
                values[hashIndex] = value;
                return;
            }
            // Linearly probing
            hashIndex = (hashIndex + 1) % capacity;
        }

        // New entry
        keys[hashIndex] = key;
        values[hashIndex] = value;
        size++;
    }

    /**
     * Returns the value associated with the specified key.
     *
     * @param key the key
     * @return the value associated with {@code key};
     * {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public V get(K key) {

        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }

        int hashIndex = hash(key);
        while (keys[hashIndex] != null) {
            if (keys[hashIndex].equals(key)) {
                return values[hashIndex];
            }
            hashIndex = (hashIndex + 1) % capacity;
        }
        return null;
    }

    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(K key) {

        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (!contains(key)) {
            return;
        }

        // Find position
        int hashIndex = hash(key);
        while (!key.equals(keys[hashIndex])) {
            hashIndex = (hashIndex + 1) % capacity;
        }

        // delete
        keys[hashIndex] = null;
        values[hashIndex] = null;

        // Now rehash all the keys in the same cluster
        hashIndex = (hashIndex + 1) % capacity;
        while (keys[hashIndex] != null) {
            K keyToRehash = keys[hashIndex];
            V valueToRehash = values[hashIndex];
            keys[hashIndex] = null;
            values[hashIndex] = null;
            size--;
            put(keyToRehash, valueToRehash);
            hashIndex = (hashIndex + 1) % capacity;
        }

        size--;
        // halves size of array if it's 12.5% full or less
        if (size > 0 && size >= capacity / 8) {
            resize(capacity / 2);
        }
    }

    // hash function for keys - returns value between 0 and M-1
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }

    // resizes the hash table to the given capacity by re-hashing all of the keys
    private void resize(int newCapacity) {
        GenericHashTable<K, V> temp = new GenericHashTable<>(newCapacity);
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], values[i]);
            }
        }

        keys = temp.keys;
        values = temp.values;
        capacity = temp.capacity;
    }

}
