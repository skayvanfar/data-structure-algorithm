package ir.sk.datastructure.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Steque is a stack-ended data structure which
 * supports stack operations as well as queue's
 * enqueue operation.
 *
 * @param <T>
 */
public class Steque<T> implements Iterable<T> {

    private Node first, last;

    private class Node {
        T item;
        Node next;
    }

    public Steque() {
        first = last = null;
    }


    /**
     * inserts an item in the steque in queue fashion.
     *
     * @param item Item to be inserted.
     */
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (first == null)
            first = last;
        else
            oldLast.next = last;
    }


    /**
     * inserts an item in the steque in stack fashion.
     *
     * @param item Item to be inserted.
     */
    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (last == null)
            last = first;
    }

    /**
     * pops a least recent item in steque.
     *
     * @return Item object from steque.
     */
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("No element exists in Steque");
        T item = first.item;
        first = first.next;
        return item;
    }

    /**
     * checks to see if steque is empty.
     *
     * @return true if steque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return first == null || last == null;
    }

    /**
     * return the number of elements currently in the steque.
     *
     * @return size as integer.
     */
    public int size() {
        int count = 0;
        for (T item : this) {
            count++;
        }
        return count;
    }

    /**
     * returns an iterator over the elements
     * stored in steque.
     */
    public Iterator<T> iterator() {
        return new StequeIterator();
    }


    public class StequeIterator implements Iterator<T> {
        Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation not supported");

        }
    }
}
