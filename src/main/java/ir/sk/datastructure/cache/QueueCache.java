package ir.sk.datastructure.cache;

import ir.sk.datastructure.fundamental.linklist.DoubledLink;
import ir.sk.datastructure.fundamental.linklist.DoublyLinkedList;
import ir.sk.datastructure.queue.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * When you read in a previously
 * unseen character, insert it at the front of the list. When you read in a duplicate
 * character, delete it from the list and reinsert it at the beginning.
 * it implements the well-known move-to-front strategy, which is useful for
 * caching, data compression, and many other applications where items that have been
 * recently accessed are more likely to be reaccessed.
 *
 * Created by sad.kayvanfar on 3/9/2021.
 */
public class QueueCache<T> implements Queue<T>, Iterable<T> {

    private DoublyLinkedList<T> theList;

    public QueueCache() {
        this.theList = new DoublyLinkedList<>();
    }

    /**
     * Add an item to the end of the list. (enqueue)
     *
     * @param item
     */
    @Override
    public void enqueue(T item) {
        DoubledLink<T> link = theList.isEmpty() ? null : theList.findNode(item);
        if (link != null) theList.removeNode(link);
        theList.insertFirst(item);
    }

    /**
     * Remove the first item in the list. (dequeue)
     *
     * @return
     */
    @Override
    public T dequeue() {
        return theList.deleteFirst();
    }

    /**
     * Return the top of the queue.
     *
     * @return
     */
    @Override
    public T peek() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(T item) {
        enqueue(item);
    }

    /**
     * Return true if and only if the queue is empty.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    public void display() {
        theList.displayForward();
    }

    public Iterator<T> iterator() {
        return theList.iterator();
    }
}
