package ir.sk.datastructure.queue;

import ir.sk.datastructure.fundamental.linklist.DoublyLinkedList;
import ir.sk.datastructure.queue.Queue;
import ir.sk.datastructure.stack.Stack;

import java.util.Iterator;

/**
 * Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or
 * a queue but supports adding and removing items at both ends.
 *
 * Created by sad.kayvanfar on 3/8/2021.
 */
public class LinkListDeque<T> implements Iterable<T> {

    private DoublyLinkedList<T> theList;

    public LinkListDeque() {
        theList = new DoublyLinkedList<>();
    }

    public void pushLeft(T item) {
        theList.insertFirst(item);
    }

    public void pushRight(T item) {
        theList.insertLast(item);
    }

    public T popLeft() {
        return theList.deleteFirst();
    }

    public T popRight() {
        return theList.deleteLast();
    }

    public T pop() {
        return theList.deleteFirst();
    }

    public void add(T item) {
        pushLeft(item);
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public Iterator<T> iterator() {
        return theList.iterator();
    }
}
