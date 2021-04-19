package ir.sk.adt.datastructure.hashing;

/**
 * A simple hashtable implementation
 *
 * A hash table is simply an array associated with a function (the hash function).
 * It efficiently implements the dictionary ADT with efficient insert, remove and find operations, each taking O(1)O(1) expected time.
 *
 */
public class HashTable {

    private boolean[] array;

    public HashTable(int size) {
        this.array = new boolean[size];
    }

    /**
     * A hash function is used to determine the index where each key-value pair should go in the hash table
     *
     * @param key
     * @return
     */
    private int hash(int key) {
        return key % array.length;
    }

    public void insert(int key) {
        array[hash(key)] = true;
    }

    public boolean contains(int key) {
        return array[hash(key)];
    }
}
