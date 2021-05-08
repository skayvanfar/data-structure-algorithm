package ir.sk.adt.queue;

import ir.sk.adt.datastructure.linklist.DoubleEndedList;

import java.util.Iterator;

/**
 * 2-ended list
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class LinkQueue<T> implements Queue<T>, Iterable<T> {

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
        throw  new UnsupportedOperationException();
    }

    /**
     * @param j
     */
    @Override
    public void enqueue(T j) {
        theList.insertLast(j);
    }

    /**
     * @return
     */
    @Override
    public T dequeue() {
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
