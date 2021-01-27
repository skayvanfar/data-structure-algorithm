package ir.sk.datastructure.cache;

import ir.sk.helper.complexity.TimeComplexity;

import java.util.HashMap;

/**
 * LRU eviction cache (Least Recently Used eviction)
 * designing the cache, we know we'll need to support two primary functions:
 * Efficient lookups given a key.
 * Expiration of old data so that it can be replaced with new data.
 * <p>
 * A linked list would allow easy purging of old data, by moving "fresh" items to the front. We could implement
 * it to remove the last element of the linked list when the list exceeds a certain size.
 * <p>
 * A hash table allows efficient lookups of data, but it wouldn't ordinarily allow easy data purging.
 * <p>
 * By merging the two data structures
 * <p>
 * alternatively ou can use LinkedHashMap
 * <p>
 * Created by sad.kayvanfar on 9/21/2020.
 */
public class Cache {

    public static int MAX_SIZE = 10;
    public Node head;
    public Node tail;
    public HashMap<String, Node> map;
    public int size = 0;

    public Cache() {
        map = new HashMap<>();
    }

    /**
     * Moves node to front of linked list
     *
     * @param node
     */
    public void moveToFront(Node node) {
        if (node == head) {
            return;
        }
        removeFromLinkedList(node);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        size++;

        if (tail == null) {
            tail = node;
        }
    }

    public void moveToFront(String query) {
        Node node = map.get(query);
        moveToFront(node);
    }

    /**
     * Removes node from linked list
     *
     * @param node
     */
    public void removeFromLinkedList(Node node) {
        if (node == null) {
            return;
        }

        if (node.next != null || node.prev != null) {
            size--;
        }

        Node prev = node.prev;
        if (prev != null) {
            prev.next = node.next;
        }

        Node next = node.next;
        if (next != null) {
            next.prev = prev;
        }

        if (node == head) {
            head = next;
        }

        if (node == tail) {
            tail = prev;
        }

        node.next = null;
        node.prev = null;
    }

    /**
     * Gets results from cache, and updates linked list
     *
     * @param query
     * @return
     */
    @TimeComplexity("O(1)")
    public String[] getResults(String query) {
        if (map.containsKey(query)) {
            Node node = map.get(query);
            moveToFront(node);
            return node.results;
        }
        return null;
    }

    /**
     * Inserts results into linked list and hash
     *
     * @param query
     * @param results
     */
    @TimeComplexity("O(1)")
    public void insertResults(String query, String[] results) {
        if (map.containsKey(query)) {
            Node node = map.get(query);
            node.results = results;
            moveToFront(node);
            return;
        }

        Node node = new Node(query, results);
        moveToFront(node);
        map.put(query, node);

        if (size > MAX_SIZE) {
            map.remove(tail.query);
            removeFromLinkedList(tail);
        }
    }
}

class Node {
    public Node prev;
    public Node next;
    public String[] results;
    public String query;

    public Node(String q, String[] res) {
        results = res;
        query = q;
    }
}
