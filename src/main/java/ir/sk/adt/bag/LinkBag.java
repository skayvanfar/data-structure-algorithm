package ir.sk.adt.bag;

import ir.sk.helper.complexity.TimeComplexity;

import java.util.Iterator;

/**
 * Implementing our Bag API using a linked-list data structure
 *
 * @param <T>
 */
public class LinkBag<T> implements Bag<T>, Iterable<T> {

    private Node first;

    private class Node {
        T item;
        Node next;
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
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
