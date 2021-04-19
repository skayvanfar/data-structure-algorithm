package ir.sk.adt.stack;

import ir.sk.adt.datastructure.linklist.SinglyLinkList;

import java.util.Iterator;

/**
 * Stack Implemented by a Linked List
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class LinkStack<T> implements Stack<T>, Iterable<T> {

    private SinglyLinkList<T> theList;

    public LinkStack() {
        theList = new SinglyLinkList();
    }

    /**
     * @param item
     */
    @Override
    public void push(T item) {
        // by using insertFirst for O(1)
        theList.insertFirst(item);
    }

    /**
     * @return
     */
    @Override
    public T pop() {
        return theList.deleteFirst();
    }

    @Override
    public T peek() {
        return theList.peakFirst();
    }

    @Override
    public boolean isEmpty() {
        return (theList.isEmpty());
    }

    public void display() {
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }

    @Override
    public Iterator<T> iterator() {
        return theList.iterator();
    }
}
