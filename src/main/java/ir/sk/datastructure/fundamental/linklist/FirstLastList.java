package ir.sk.datastructure.fundamental.linklist;

import ir.sk.helper.complexity.TimeComplexity;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Double-Ended List
 * A double-ended list is similar to an ordinary linked list, but it has one additional
 * feature: a reference to the last link as well as to the first.
 * <p>
 * The reference to the last link permits you to insert a new link directly at the end of
 * the list as well as at the beginning. Of course, you can insert a new link at the end of
 * an ordinary single-ended list by iterating through the entire list until you reach the
 * end, but this approach is inefficient.
 * <p>
 * Access to the end of the list as well as the beginning makes the double-ended list
 * suitable for certain situations that a single-ended list can’t handle efficiently. One
 * such situation is implementing a queue;
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class FirstLastList<T> implements Iterable<T> {

    private SinglyLink<T> head;
    private SinglyLink<T> tail;
    private int counter;

    public FirstLastList() {
        head = null;
        tail = null;
    }

    @TimeComplexity("O(1)")
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * insert at front of list
     *
     * @param dd
     */
    @TimeComplexity("O(1)")
    public void insertFirst(T dd) {
        SinglyLink<T> newSinglyLink = new SinglyLink<T>(dd);   // make new link

        if (isEmpty())                // if empty list,
            tail = newSinglyLink;             // newLink <-- last
        newSinglyLink.next = head;          // newLink --> old first
        head = newSinglyLink;               // first --> newLink
        counter++;
    }

    /**
     * insert at end of list
     *
     * @param dd
     */
    @TimeComplexity("O(1)")
    public void insertLast(T dd) {
        SinglyLink<T> newSinglyLink = new SinglyLink<T>(dd);   // make new link
        if (isEmpty())                // if empty list,
            head = newSinglyLink;            // first --> newLink
        else
            tail.next = newSinglyLink;        // old last --> newLink
        tail = newSinglyLink;                // newLink <-- last
        counter++;
    }

    /**
     * delete first link
     *
     * @return
     */
    @TimeComplexity("O(1)")
    public T deleteFirst() {
        // (assumes non-empty list)
        T temp = head.data;
        if (head.next == null)         // if only one item
            tail = null;                // null <-- last
        head = head.next;            // first --> old next
        counter++;
        return temp;
    }

    @TimeComplexity("O(1)")
    public T deleteLast() {
        // (assumes non-empty list)
        T temp = tail.data;
        if (head.next == null)         // if only one item
            tail = null;                // null <-- last
        head = head.next;            // first --> old next
        counter++;
        return temp;
    }


    @TimeComplexity("O(1)")
    public T peakFirst() {
        return head.data;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        SinglyLink current = head;          // start at beginning
        while (current != null)         // until end of list,
        {
            current.displayLink();      // print data
            current = current.next;     // move to next link
        }
        System.out.println("");
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new FirstLastListIterator(head, counter);
    }

    private class FirstLastListIterator implements Iterator<T> {

        private SinglyLink<T> current;          // current link

        // Maintain a counter that counts the number of operations. When creating an
        // iterator, store this value as an Iterator instance variable. Before each call to hasNext() and next(),
        // check that this value has not changed since construction of the iterator; if it has, throw the exception.
        private int counter;

        public FirstLastListIterator(SinglyLink<T> current, int ops) {
            this.current = current;
            this.counter = ops;
        }

        @Override
        public boolean hasNext() {
            if (counter != FirstLastList.this.counter) throw new java.util.ConcurrentModificationException();
            return current != null;
        }

        @Override
        public T next() {
            if (counter != FirstLastList.this.counter)
                throw new java.util.ConcurrentModificationException();
            if (!hasNext())
                throw new NoSuchElementException("Cannot call next() on last item");
            T item = current.data;
            current = current.next;
            return item;
        }
    }
}
