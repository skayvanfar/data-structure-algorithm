package ir.sk.datastructure.queue;

import ir.sk.helper.TimeComplexity;

/**
 * A queue implements FIFO (first-in first-out) ordering. As in a line or queue at a ticket stand, items are
 * removed from the data structure in the same order that they are added.
 * <p>
 * Created by sad.kayvanfar on 9/1/2020.
 */
public interface Queue<T> {

    /**
     * Add an item to the end of the list.
     *
     * @param item
     */
    @TimeComplexity("O(1)")
    void add(T item);

    /**
     * Remove the first item in the list.
     *
     * @return
     */
    @TimeComplexity("O(1)")
    T remove();

    /**
     * Return the top of the queue.
     *
     * @return
     */
    @TimeComplexity("O(1)")
    T peek();

    /**
     * Return true if and only if the queue is empty.
     *
     * @return
     */
    @TimeComplexity("O(1)")
    boolean isEmpty();

}
