package ir.sk.adt.datastructure.linklist;

import ir.sk.helper.complexity.TimeComplexity;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * he doubly linked list (not to be
 * confused with the double-ended list)
 * It allows you to traverse backward as
 * well as forward through the list. The secret is that each link has two references to
 * other links instead of one. The first is to the next link, as in ordinary lists.
 *
 * First-Last Pointer
 * Doubled
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class DoublyLinkedList<T> implements Iterable<T> {

    private DoubledLink<T> head;
    private DoubledLink<T> tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    @TimeComplexity("O(n)")
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
        DoubledLink<T> newLink = new DoubledLink<>(dd);   // make new link

        if (isEmpty())                // if empty list,
            tail = newLink;             // newLink <-- last
        else
            head.previous = newLink;   // newLink <-- old first
        newLink.next = head;          // newLink --> old first
        head = newLink;               // first --> newLink
    }

    /**
     * insert at end of list
     *
     * @param dd
     */
    @TimeComplexity("O(1)")
    public void insertLast(T dd) {
        DoubledLink newLink = new DoubledLink(dd);   // make new link
        if (isEmpty())                // if empty list,
            head = newLink;            // first --> newLink
        else {
            tail.next = newLink;        // old last --> newLink
            newLink.previous = tail;    // old last <-- newLink
        }
        tail = newLink;                // newLink <-- last
    }

    /**
     * delete first link
     *
     * @return
     */
    @TimeComplexity("O(1)")
    public T deleteFirst() {
        // (assumes non-empty list)
        DoubledLink<T> temp = head;
        if (head.next == null)         // if only one item
            tail = null;                // null <-- last
        else
            head.next.previous = null; // null <-- old next
        head = head.next;            // first --> old next
        return temp.data;
    }

    /**
     * delete last link
     *
     * @return
     */
    @TimeComplexity("O(1)")
    public T deleteLast() {
        // (assumes non-empty list)
        DoubledLink<T> temp = tail;
        if (head.next == null)         // if only one item
            head = null;               // first --> null
        else
            tail.previous.next = null;  // old previous --> null
        tail = tail.previous;          // old previous <-- last
        return temp.data;
    }

    /**
     * insert dd just after key
     *
     * @param key
     * @param dd
     * @return
     */
    @TimeComplexity("O(n)")
    public boolean insertAfter(T key, T dd) {
        // (assumes non-empty list)
        DoubledLink<T> current = head;          // start at beginning
        while (current.data != key) {  // until match is found,

            current = current.next;     // move to next link
            if (current == null)
                return false;            // didn't find it
        }
        DoubledLink<T> newLink = new DoubledLink<>(dd);   // make new link

        if (current == tail) {             // if last link,

            newLink.next = null;        // newLink --> null
            tail = newLink;             // newLink <-- last
        } else { // not last link,
            newLink.next = current.next; // newLink --> old next
            // newLink <-- old next
            current.next.previous = newLink;
        }
        newLink.previous = current;    // old current <-- newLink
        current.next = newLink;        // old current --> newLink
        return true;                   // found it, did insertion
    }

    /**
     * delete item w/ given key
     *
     * @param key
     * @return
     */
    @TimeComplexity("O(n)")
    public DoubledLink<T> deleteKey(T key) {
        // (assumes non-empty list)
        DoubledLink current = head;          // start at beginning
        while (current.data != key)    // until match is found,
        {
            current = current.next;     // move to next link
            if (current == null)
                return null;             // didn't find it
        }
        if (current == head)             // found it; first item?
            head = current.next;       // first --> old next
        else                           // not first
            // old previous --> old next
            current.previous.next = current.next;

        if (current == tail)              // last item?
            tail = current.previous;    // old previous <-- last
        else                           // not last
            // old previous <-- old next
            current.next.previous = current.previous;
        return current;                // return value
    }

    public void displayForward() {
        System.out.print("List (first-->last): ");
        DoubledLink current = head;          // start at beginning
        while (current != null)         // until end of list,
        {
            current.displayLink();      // display data
            current = current.next;     // move to next link
        }
        System.out.println("");
    }

    public void displayBackward() {
        System.out.print("List (last-->first): ");
        DoubledLink current = tail;           // start at end
        while (current != null)         // until start of list,
        {
            current.displayLink();      // display data
            current = current.previous; // move to previous link
        }
        System.out.println("");
    }

    public DoubledLink<T> findNode(T item) {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        DoubledLink<T> current = head;
        while (current != null) {
            if (current.data.equals(item)) return current;
            current = current.next;
        }
        return null;
    }

    public T removeNode(DoubledLink<T> node) {
        DoubledLink<T> current = head;
        while (current != null) {
            if (current == node) {
                T item = current.data;
                if (current == head) head = current.next;
                if (current == tail)  tail  = current.previous;
                if (current.previous != null)  current.previous.next = current.next;
                if (current.next     != null)  current.next.previous = current.previous;
                return item;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedList.DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<T> {

        private DoubledLink<T> current = head;          // current link

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null)
                throw new NoSuchElementException("Cannot call next() on last item");
            T item = current.data;
            current = current.next;
            return item;
        }
    }
}

