package ir.sk.adt.queue.priorityqueue;

/**
 * Indexed Priority Queue gives us the ability to change the priority of an element without having to go through all the elements.
 */
public interface IndexMinPQ<Item extends Comparable<Item>> {

    /**
     * insert item ; associate it with k
     */
    void insert(int k, Item item);

    /**
     * change the item associated with k to item
     */
    void change(int k, Item item);

    /**
     * is k associated with some item?
     */
    boolean contains(int k);

    /**
     * remove k and its associated item
     */
    void delete(int k);

    /**
     * return a minimal item
     */
    Item min();

    /**
     * return a minimal item’s index
     */
    int minIndex();

    /**
     * remove a minimal item and return its index
     */
    int delMin();

    /**
     * is the priority queue empty?
     */
    boolean isEmpty();

    /**
     * number of items in the priority queue
     */
    int size();


}
