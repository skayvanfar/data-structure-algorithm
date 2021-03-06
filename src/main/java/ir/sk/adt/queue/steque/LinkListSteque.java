package ir.sk.adt.queue.steque;

import ir.sk.adt.datastructure.linklist.DoubleEndedList;

import java.util.Iterator;

/**
 * Linked List implementation
 * @param <T>
 */
public class LinkListSteque<T> implements Steque<T>, Iterable<T> {

    private DoubleEndedList<T> theList;

    public LinkListSteque() {
        theList = new DoubleEndedList();
    }

    @Override
    public void enqueue(T item) {
        theList.insertLast(item);
    }

    @Override
    public void push(T item) {
        theList.insertFirst(item);
    }

    @Override
    public T pop() {
        return theList.deleteFirst();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public Iterator<T> iterator() {
        return theList.iterator();
    }

}
