package ir.sk.adt.queue;

import ir.sk.adt.datastructure.linklist.DoublyLinkedList;

import java.util.Iterator;

/**
 *
 * Created by sad.kayvanfar on 3/8/2021.
 */
public class LinkListDeque<T> implements Deque<T>, Iterable<T> {

    private DoublyLinkedList<T> theList;

    public LinkListDeque() {
        theList = new DoublyLinkedList<>();
    }

    @Override
    public void pushLeft(T item) {
        theList.insertFirst(item);
    }

    @Override
    public void pushRight(T item) {
        theList.insertLast(item);
    }

    @Override
    public T popLeft() {
        return theList.deleteFirst();
    }

    @Override
    public T popRight() {
        return theList.deleteLast();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public Iterator<T> iterator() {
        return theList.iterator();
    }
}
