package ir.sk.adt.bag;

import ir.sk.helper.complexity.TimeComplexity;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementing our Bag API using a linked-list data structure
 *
 * @param <T>
 */
public class LinkBag<T> implements Bag<T>, Iterable<T> {

    private Node first;       // beginning of bag
    private int size;         // number of elements in bag

    private class Node {
        T item;
        Node next;
    }

    public LinkBag() {
        first = null;
        size = 0;
    }

    @TimeComplexity("O(1)")
    @Override
    public void add(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current;

        public ListIterator() {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
