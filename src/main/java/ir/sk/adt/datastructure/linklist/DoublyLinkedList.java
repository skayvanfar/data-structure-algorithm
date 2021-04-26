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
    private DoubledLink<T> tail; // double ended

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
     * @param key
     */
    @TimeComplexity("O(1)")
    public void insertFirst(T key) {
        DoubledLink<T> newLink = new DoubledLink<>(key);

        if (isEmpty())
            tail = newLink;
        else
            head.previous = newLink;
        newLink.next = head;
        head = newLink;
    }

    /**
     * insert at end of list
     *
     * @param key
     */
    @TimeComplexity("O(1)")
    public void insertLast(T key) {
        DoubledLink newLink = new DoubledLink(key);
        if (isEmpty())
            head = newLink;
        else {
            tail.next = newLink;
            newLink.previous = tail;
        }
        tail = newLink;
    }

    /**
     * delete first link
     * assumes non-empty list
     *
     * @return
     */
    @TimeComplexity("O(1)")
    public T deleteFirst() {
        DoubledLink<T> temp = head;
        if (head.next == null)
            tail = null;
        else
            head.next.previous = null;
        head = head.next;
        return temp.data;
    }

    /**
     * delete last link
     * assumes non-empty list
     *
     * @return
     */
    @TimeComplexity("O(1)")
    public T deleteLast() {
        DoubledLink<T> temp = tail;
        if (head.next == null)
            head = null;
        else
            tail.previous.next = null;
        tail = tail.previous;
        return temp.data;
    }

    /**
     * insert dd just after key
     * assumes non-empty list
     *
     * @param key
     * @param dd
     * @return
     */
    @TimeComplexity("O(n)")
    public boolean insertAfter(T key, T dd) {
        DoubledLink<T> current = head;
        while (current.data != key) {
            current = current.next;
            if (current == null)
                return false;
        }
        DoubledLink<T> newLink = new DoubledLink<>(dd);

        if (current == tail) {

            newLink.next = null;
            tail = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }

    /**
     * delete item w/ given key
     * assumes non-empty list
     *
     * @param key
     * @return
     */
    @TimeComplexity("O(n)")
    public DoubledLink<T> deleteKey(T key) {
        DoubledLink current = head;
        while (current.data != key) {
            current = current.next;
            if (current == null)
                return null;
        }
        if (current == head)
            head = current.next;
        else
            current.previous.next = current.next;

        if (current == tail)
            tail = current.previous;
        else
            current.next.previous = current.previous;
        return current;
    }

    public void displayForward() {
        System.out.print("List (first-->last): ");
        DoubledLink current = head;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public void displayBackward() {
        System.out.print("List (last-->first): ");
        DoubledLink current = tail;
        while (current != null) {
            current.displayLink();
            current = current.previous;
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

        private DoubledLink<T> current = head;

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

