package ir.sk.datastructure.fundamental.hashing;

/**
 * A simple hashtable implementation
 */
public class HashTable {

    private boolean[] array;

    public HashTable(int size) {
        this.array = new boolean[size];
    }

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
