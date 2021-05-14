package ir.sk.adt.queue;

import ir.sk.adt.datastructure.linklist.DoubleEndedList;

import java.util.Iterator;

/**
 * 2-ended list
 *  The {@code LinkedQueue} class represents a first-in-first-out (FIFO)
 *  queue of generic items.
 *  It supports the usual <em>enqueue</em> and <em>dequeue</em>
 *  operations, along with methods for peeking at the first item,
 *  testing if the queue is empty, and iterating through
 *  the items in FIFO order.
 *  <p>
 *  This implementation uses a singly linked list with a non-static nested class
 *  for linked-list nodes.  See {@link Queue} for a version that uses a static nested class.
 *  The <em>enqueue</em>, <em>dequeue</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 *  operations all take constant time in the worst case.
 */
public class LinkQueue<T> implements Queue<T>, Iterable<T> {

    private int size = 0;         // number of elements on queue
    private DoubleEndedList<T> theList;

    public LinkQueue() {
        theList = new DoubleEndedList();
    }

    @Override
    public void add(T item) {

        enqueue(item);
    }

    @Override
    public boolean isEmpty() {
        return theList.isEmpty();
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * @param j
     */
    @Override
    public void enqueue(T j) {
        theList.insertLast(j);
        size++;
    }

    /**
     * @return
     */
    @Override
    public T dequeue() {
        size--;
        return theList.deleteFirst();
    }

    @Override
    public T peek() {
        return theList.peakFirst();
    }

    public void display() {
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }

    @Override
    public Iterator<T> iterator() {
        return theList.iterator();
    }
}
