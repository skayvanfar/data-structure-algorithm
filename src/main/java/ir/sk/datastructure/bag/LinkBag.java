package ir.sk.datastructure.bag;

import java.util.Iterator;

/**
 * Implementing our Bag API using a linked-list data structure
 *
 * @param <T>
 */
public class LinkBag<T> implements Bag<T>, Iterable {

    private Node first; // first node in list

    private class Node {
        T item;
        Node next;
    }

    @Override
    public void add(T item) { // same as push() in Stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
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
        }

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
