package ir.sk.adt.dictionary;

import ir.sk.helper.complexity.TimeComplexity;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * One straightforward option
 * for the underlying data structure for a symbol table is a linked list of nodes that contain
 * keys and values, as in the code on the facing page. To implement get(), we scan through
 * the list, using equals() to compare the search key with the key in each node in the list.
 * If we find the match, we return the associated value; if not, we return null. To implement
 * put(), we also scan through the list, using equals() to compare the client key
 * with the key in each node in the list. If we find the match, we update the value associated
 * with that key to be the value given in the second argument; if not, we create a new
 * node with the given key and value and insert it at the beginning of the list. This method
 * is known as sequential search.
 *
 * Created by sad.kayvanfar on 5/5/2021.
 */
public class LinkedListDictionary<K , V> implements Dictionary<K, V> {

    private int size;           // number of key-value pairs
    private Link first;      // the linked list of key-value pairs

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size;
    }

    /**
     * Is this symbol table empty?
     * @return {@code true} if this symbol table is empty and {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Does this symbol table contain the given key?
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *     {@code false} otherwise
     */
    public boolean contains(K key) {
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key.
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol table
     *     and {@code null} if the key is not in the symbol table
     */
    @TimeComplexity("O(n)")
    @Override
    public V get(K key) {
        for (Link x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }

    /**
     * Inserts the key-value pair into the symbol table, overwriting the old value
     * with the new value if the key is already in the symbol table.
     * If the value is {@code null}, this effectively deletes the key from the symbol table.
     * @param key the key
     * @param val the value
     */
    @TimeComplexity("O(n)")
    @Override
    public void put(K key, V val) {
        if (val == null) {
            remove(key);
            return;
        }

        for (Link x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Link(key, val, first);
        size++;
    }

    /**
     * Removes the key and associated value from the symbol table
     * (if the key is in the symbol table).
     * @param key the key
     */
    public V remove(K key) {
        first = remove(first, key);
        return null; // TODO: 5/5/2021
    }

    // delete key in linked list beginning at Link x
    // warning: function call stack too large if table is large
    private Link remove(Link x, K key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            size--;
            return x.next;
        }
        x.next = remove(x.next, key);
        return x;
    }


    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (K key : st.keys())}.
     * @return all keys in the symbol table as an {@code Iterable}
     */
    public Iterable<K> keys()  {
        Queue<K> queue = new ArrayDeque<>();
        for (Link x = first; x != null; x = x.next)
            queue.add(x.key);
        return queue;
    }

    private class Link {
        private K key;
        private V val;
        private Link next;

        /**
         * a helper linked list data type
         */
        public Link(K key, V val, Link next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }
}
