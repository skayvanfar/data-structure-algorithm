package ir.sk.datastructure.fundamental.array;

import java.util.Iterator;

/**
 * CircularArray class that supports an array-like data structure which
 * can be efficiently rotated.
 *
 * Created by sad.kayvanfar on 9/20/2020.
 */
public class CircularArray<T> implements Iterable<T> {

    private T[] items;
    // create a member variable head which points to what should be conceptually viewed
    // as the start of the circular array. Rather than shifting around the elements in the array, we just increment
    // head by shift Right.
    private int head = 0;

    public CircularArray(int size) {
        items = (T[]) new Object[size];
    }

    /**
     * convert the raw index to the rotated index.
     * @param index
     * @return
     */
    private int convert(int index) {
        if (index < 0) {
            index += items.length;
        }
        return (head + index) % items.length;
    }

    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    public T get(int i) {
        if (i < 0 || i >= items.length) {
            throw new java.lang.IndexOutOfBoundsException("Index " + i + " is out of bounds");
        }
        return items[convert(i)];
    }

    public void set(int i, T item) {
        items[convert(i)] = item;
    }

    public Iterator<T> iterator() {
        return new CircularArrayIterator();
    }

    private class CircularArrayIterator implements Iterator<T> {
        private int _current = -1;

        public CircularArrayIterator() { }

        @Override
        public boolean hasNext() {
            return _current < items.length - 1;
        }

        @Override
        public T next() {
            _current++;
            return (T) items[convert(_current)];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported by CircularArray");
        }
    }
}
