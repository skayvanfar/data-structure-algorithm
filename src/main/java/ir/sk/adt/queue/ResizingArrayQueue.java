package ir.sk.adt.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Queue implementation with a resizing array.
 *
 * it implements the queue
 * abstraction with a fixed-size array, and then extend your implementation to use array
 * resizing to remove the size restriction.
 *
 * Created by sad.kayvanfar on 3/6/2021.
 */
public class ResizingArrayQueue<T> implements Queue<T>, Iterable<T> {

    // initial capacity of underlying resizing array
    private static final int INIT_CAPACITY = 8;

    private T[] queueArray;       // queue elements
    private int n;          // number of elements on queue
    private int first;      // index of first element of queue
    private int last;       // index of next available slot

    @SuppressWarnings("unchecked")
    public ResizingArrayQueue() {
        queueArray = (T[]) new Object[INIT_CAPACITY];
        n = 0;
        first = 0;
        last = 0;
    }

    @Override
    public void add(T item) {
        enqueue(item);
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    /**
     * resize the underlying array
     *
     * @param capacity
     */
    private void resize(int capacity) {
        assert capacity >= n;
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = queueArray[(first + i) % queueArray.length];
        }
        queueArray = copy;
        first = 0;
        last  = n;
    }

    @Override
    public void enqueue(T item) {
        // double size of array if necessary and recopy to front of array
        if (n == queueArray.length) resize(2* queueArray.length);   // double size of array if necessary
        queueArray[last++] = item;                        // add item
        if (last == queueArray.length) last = 0;          // wrap-around
        n++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        T item = queueArray[first];
        queueArray[first] = null;                            // to avoid loitering
        n--;
        first++;
        if (first == queueArray.length) first = 0;           // wrap-around
        // shrink size of array if necessary
        if (n > 0 && n == queueArray.length/4) resize(queueArray.length/2);
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return queueArray[first];
    }

    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    /**
     * an iterator, doesn't implement remove() since it's optional
     */
    private class ArrayIterator implements Iterator<T> {
        private int i = 0;
        public boolean hasNext()  { return i < n;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = queueArray[(i + first) % queueArray.length];
            i++;
            return item;
        }
    }
}
