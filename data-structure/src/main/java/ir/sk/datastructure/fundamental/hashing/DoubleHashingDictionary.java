package ir.sk.datastructure.fundamental.hashing;

/**
 * Double hashing is a collision resolving technique in Open Addressed Hash tables.
 * Double hashing uses the idea of applying a second hash function to key when a collision occurs.
 * it protect from clustering problem in Linear Probing
 *
 * Created by sad.keyvanfar on 7/8/2020.
 */
public class DoubleHashingDictionary<K, V> {

    private static final float DEFAULT_LOAD_FACTOR = 0.5f;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int PRIME = 7;

    // bucketArray is used to store array
    private OpenAddressingHashNode<K, V>[] array;

    // Current capacity of array list (m) (n <= m <= 4n) (constant load factor)
    private int capacity;

    // Current size of array list (n)
    private int size;

    private final float maxLoadFactor;

    // dummy node as deleted flag
    OpenAddressingHashNode<K, V> deletedNode;

    public DoubleHashingDictionary() {
        this.maxLoadFactor = DEFAULT_LOAD_FACTOR;
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
        array = new OpenAddressingHashNode[capacity];
        deletedNode = new OpenAddressingHashNode<>();
    }

    public DoubleHashingDictionary(int initialCapacity, float maxLoadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        if (maxLoadFactor <= 0 || Float.isNaN(maxLoadFactor))
            throw new IllegalArgumentException("Illegal load factor: " + maxLoadFactor);
        this.maxLoadFactor = maxLoadFactor;
        this.capacity = initialCapacity;
        this.size = 0;
        array = new OpenAddressingHashNode[capacity];
        deletedNode = new OpenAddressingHashNode<>();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * function to calculate first hash
     *
     * @param key
     * @return
     */
    private int hashFuntion1(K key) {
        // prehashing
        int hashCode = key.hashCode();
        // hashing
        int index = hashCode % capacity;
        return index;
    }

    /**
     * function to calculate second hash
     *
     * @param key
     * @return
     */
    private int hashFuntion2(K key) {
        // prehashing
        int hashCode = key.hashCode();
        return (PRIME - (hashCode % PRIME));
    }

    /**
     * Keep probing until an empty slot is found. Once an empty slot is found, insert k.
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        OpenAddressingHashNode<K, V> newNode = new OpenAddressingHashNode<>(key, value);
        int hashIndex = hashFuntion1(key);

        // if collision occurs
        if (array[hashIndex] != null && array[hashIndex].key != key) {
            // get index2 from second hash
            int hashIndex2 = hashFuntion2(key);
            int i = 1;
            while (true) {
                // get newIndex
                int newIndex = (hashIndex + i * hashIndex2) % capacity;

                // if no collision occurs, store
                // the key
                if (array[hashIndex] != null && array[hashIndex].key != key) {
                    array[newIndex] = newNode;
                    break;
                }
                i++;
            }
        } else
            array[hashIndex] = newNode;
        size++;

        //  when Load Factor (n/m) is 1, Time Complexity is exact O(1)
        double loadFactor = ((1.0 * size) / capacity);
        if (loadFactor >= this.maxLoadFactor) {
            // size of new array = 2 * numBuckets (Table Doubling): It's the best size for growing the size of array
            reHash(2 * capacity);
        }
    }

    /**
     * Keep probing until slot’s key doesn’t become equal to k or an empty slot is reached.
     *
     * @param key
     * @return
     */
    public V get(K key) {
        // Apply hash function to find index for given key
        int hashIndex = hashFuntion1(key);
        int hashIndex2 = hashFuntion2(key);

        int i = 0;
        //finding the node with given key
        while (array[(hashIndex + i * hashIndex2) % capacity] != null) {
            //if node found return its value
            if (array[hashIndex].key == key)
                return array[hashIndex].value;
            i++;
        }

        //If not found return null
        return null;
    }

    /**
     * Delete operation is interesting. If we simply delete a key, then search may fail.
     * So slots of deleted keys are marked specially as “deleted”
     * @param key
     * @return
     */
    public V remove(K key) {
        // Apply hash function to find index for given key
        int hashIndex = hashFuntion1(key);
        int hashIndex2 = hashFuntion2(key);

        int i = 0;
        //finding the node with given key
        while (array[(hashIndex + i * hashIndex2) % capacity] != null) {
            //if node found
            if (array[(hashIndex + i * hashIndex2) % capacity].key == key) {
                OpenAddressingHashNode<K, V> temp = array[hashIndex];

                //Insert dummy node here for further use
                array[hashIndex] = deletedNode;

                // Reduce size
                size--;

                // Shrink
                double loadFactor = ((1.0 * size) / capacity);
                if (loadFactor <= this.maxLoadFactor) {
                    // size of new array = numBuckets / 4 (Table Shrink): It's the best size for shrinking the size of array
                    reHash(capacity / 4);
                }

                return temp.value;
            }
            i++;
        }

        //If not found return null
        return null;
    }

    /**
     * If load factor goes beyond threshold, then double hash table size
     * Time Complexity: O(n + m + m') = O(n)
     */
    private void reHash(int m) {
        capacity = m;
        size = 0;
        OpenAddressingHashNode<K, V>[] temp = array;
        array = new OpenAddressingHashNode[capacity];

        for (OpenAddressingHashNode<K, V> headNode : temp) {
            if (headNode != null) {
                add(headNode.key, headNode.value);
            }
        }
    }
}
