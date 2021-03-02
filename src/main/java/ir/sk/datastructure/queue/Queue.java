package ir.sk.datastructure.queue;

import ir.sk.datastructure.bag.Bag;
import ir.sk.helper.complexity.TimeComplexity;

/**
 * Queue is ADT of the collection of elements with specific remove order = FIFO (first-in-first-out), allows duplicates,
 * As in a line or queue at a ticket stand, items are
 * removed from the data structure in the same order that they are added.
 * <p>
 * Created by sad.kayvanfar on 9/1/2020.
 */
public interface Queue<T> extends Bag<T> {

    /**
     * Add an item to the end of the list. (enqueue)
     *
     * @param item
     */
    @TimeComplexity("O(1)")
    void enqueue(T item);

    /**
     * Remove the first item in the list. (dequeue)
     *
     * @return
     */
    @TimeComplexity("O(1)")
    T dequeue();

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
