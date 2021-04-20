package ir.sk.adt.queue;

import ir.sk.adt.datastructure.linklist.FirstLastList;

import java.util.Iterator;

/**
 * Steque is a stack-ended data structure which
 * supports stack operations as well as queue's
 * enqueue operation.
 *
 * @param <T>
 */
public class LinkListSteque<T> implements Iterable<T> {

    private FirstLastList<T> theList;

    public LinkListSteque() {
        theList = new FirstLastList();
    }

    public void enqueue(T item) {
        theList.insertLast(item);
    }

    public void push(T item) {
        theList.insertFirst(item);
    }

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