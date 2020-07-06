package ir.sk.datastructure.fundamental.hashing;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Dictionary ADT (HashTable ADT) (HashMap ADT), Symbol table
 * Hash table is a generalization of array. With an array, we store the element whose key is k at a
 * position k of the array.That means, given a key k, we find the element whose key is k by just
 * looking in the kth position of the array. This is called direct addressing.
 * Direct addressing is applicable when we can afford to allocate an array with one position for
 * every possible key.
 *
 * Hash table or hash map is a data structure that
 * stores the keys and their associated values, and hash table uses a hash function to map keys to
 * their associated values.
 *
 * There are only three basic operations on Dictionary: searching, inserting, and deleting.
 *
 * deal with collisions by Chaining
 *
 * Created by sad.keyvanfar on 7/6/2020.
 */
public class Dictionary<K, V> {

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_CAPACITY = 10;

    // bucketArray is used to store array of chains
    private HashNode<K, V>[] bucketArray;

    // Current capacity of array list
    private int numBuckets;

    // Current size of array list
    private int size;

    private final float loadFactor;

    public Dictionary() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.numBuckets = DEFAULT_CAPACITY;
        this.size = 0;
        bucketArray = new HashNode[numBuckets];
    }

    public Dictionary(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        this.loadFactor = loadFactor;
        this.numBuckets = initialCapacity;
        this.size = 0;
        bucketArray = new HashNode[numBuckets];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * This implements hash function to find index for a key
     *
     * @param key
     * @return
     */
    private int hashFuntion(K key) {
        // prehashing
        int hashCode = key.hashCode();
        // hashing
        int index = hashCode % numBuckets;
        return index;
    }

    /**
     * Returns value for a key
     *
     * Time Complexity: O(1)
     *
     * @param key
     * @return
     */
    public V get(K key) {

        // Find head of chain for given key
        int bucketIndex = hashFuntion(key);
        HashNode<K, V> head = bucketArray[bucketIndex];

        // Search key in chain
        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }

        return null;
    }

    /**
     * Adds a key value pair to hash
     *
     * Time Complexity: O(1)
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        // Find head of chain for given key
        int bucketIndex = hashFuntion(key);
        HashNode<K, V> head = bucketArray[bucketIndex];

        // Check if key is already present
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert key in chain
        size++;
        head = bucketArray[bucketIndex];
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        bucketArray[bucketIndex] = newNode;

        reHash();
    }

    /**
     * If load factor goes beyond threshold, then double hash table size
     *
     * Time Complexity: O(n)
     */
    private void reHash() {
        if ((1.0 * size) / numBuckets >= this.loadFactor) {
            numBuckets = 2 * numBuckets;
            size = 0;
            HashNode<K, V>[] temp = bucketArray;
            bucketArray = new HashNode[numBuckets];

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    /**
     * Method to remove a given key
     *
     * Time Complexity: O(1)
     *
     * @param key
     * @return
     */
    public V remove(K key) {
        // Apply hash function to find index for given key
        int bucketIndex = hashFuntion(key);

        // Get head of chain
        HashNode<K, V> head = bucketArray[bucketIndex];

        // Search for key in its chain
        HashNode<K, V> prev = null;
        while (head != null) {
            // If Key found
            if (head.key.equals(key))
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // If key was not there
        if (head == null)
            return null;

        // Reduce size
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            bucketArray[bucketIndex] = head.next;

        return head.value;
    }
}

class HashNode<K, V> {

    K key;
    V value;

    // Reference to next node
    HashNode<K, V> next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
