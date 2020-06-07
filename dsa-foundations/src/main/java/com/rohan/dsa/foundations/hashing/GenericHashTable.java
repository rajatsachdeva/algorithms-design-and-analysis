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
 * This implementation uses a linear probing hash table and also showcase resizing
 */
public class GenericHashTable<K, V> {



}
