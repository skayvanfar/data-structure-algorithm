package ir.sk.adt.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sad.kayvanfar on 3/8/2021.
 */
public class ResizingArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] deque;
    private int start;
    private int end;

    public ResizingArrayDeque() {
        start = 1;
        end = 1;
        deque = (T[]) new Object[3];
    }

    public void resize(int n) {
        T[] copy = (T[]) new Object[n];
        int newstart = (n - size()) / 2;
        for (int i = 0; i < size(); i++) {
            copy[newstart + i] = deque[start + i];
        }
        end = newstart + size();
        start = newstart;
        deque = copy;
    }

    @Override
    public boolean isEmpty() { return (end - start) == 0; }

    public int size() { return (end - start); }

    public int sizeOfArray() { return deque.length; }

    @Override
    public void pushLeft(T item) {
        if (item == null) throw new NullPointerException("Cannot add null item");
        if (start == 0) resize(deque.length * 2);
        deque[--start] = item;
    }

    @Override
    public void pushRight(T item) {
        if (item == null) throw new NullPointerException("Cannot add null item");
        if (end == deque.length) resize(deque.length * 2);
        deque[end++] = item;
    }

    @Override
    public T popLeft() {
        if (isEmpty()) throw new NoSuchElementException("Cannot remove from empty deque");
        T item = deque[start++];
        if (!isEmpty() && size() < deque.length / 4) {
            resize(deque.length / 2);
        }
        return item;
    }

    @Override
    public T popRight() {
        if (isEmpty()) throw new NoSuchElementException("Cannot remove from empty deque");
        T item = deque[--end];
        if (!isEmpty() && size() < deque.length / 4) {
            resize(deque.length / 2);
        }
        return item;
    }

    public String toString() {
        String s = "";
        for (T item : this) {
            s += item + " ";
        }
        return s;
    }

    // return an iterator over items in order from front to end
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T> {
        private int current = start;

        public boolean hasNext() {
            return current != end;
        }

        public void remove() {
            throw new UnsupportedOperationException("Cannot remove in iterator");
        }

        public T next() {
            if (current == end)
                throw new NoSuchElementException("Cannot call next() on last item in deque");
            return deque[current++];
        }
    }
}
