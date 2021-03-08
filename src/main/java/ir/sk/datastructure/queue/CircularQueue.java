package ir.sk.datastructure.queue;

import ir.sk.helper.Remainder;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A ring buffer (circular buffer), or circular queue, is a FIFO data structure of a fixed size N. It is useful for
 * transferring data between asynchronous processes or for storing log files. When the buffer is
 * empty, the consumer waits until data is deposited; when the buffer is full, the producer waits
 * to deposit data. Develop an API for a RingBuffer and an implementation that uses an array
 * representation (with circular wrap-around).
 *
 * The useful property of a circular buffer is that it does not need to have its elements shuffled around when one is consumed.
 * (If a non-circular buffer were used then it would be necessary to shift all elements when one is consumed.)
 * In other words, the circular buffer is well-suited as a FIFO (First In, First Out) buffer while a standard, non-circular buffer is well suited as a LIFO (Last In, First Out) buffer.
 *
 * Circular buffering makes a good implementation strategy for a queue that has fixed maximum size. Should a maximum size be adopted for a queue, then a circular buffer is a completely ideal implementation;
 * all queue operations are constant time. However, expanding a circular buffer requires shifting memory, which is comparatively costly.
 * For arbitrarily expanding queues, a linked list approach may be preferred instead.
 *
 * @param <T>
 */
    public class CircularQueue<T> implements Queue<T>, Iterable<T> {

    private T[] items;
    private int capacity;
    // front
    private int start;
    private int size;

    public CircularQueue(int m) {
        capacity = m;
        items = (T[]) new Object[capacity];
        start = 0;
        size = 0;
    }

    @Override
    public void add(T item) {
        enqueue(item);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public int maxSize() {
        return capacity;
    }

    @Remainder
    public void enqueue(T item) {
        if (isFull()) {
            throw new UnsupportedOperationException("Queue is full");
        }
        // calculate rear
        items[(start + size) % capacity] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("Queue is empty");
        }
        T item = items[start++];
        if (start == capacity) start = 0;
        size--;
        return item;
    }

    @Override
    public T peek() {
        return null;
    }

    public String toString() {
        String s = "";
        for (T item : this) {
            s += item + " ";
        }
        return s;
    }

    public Iterator<T> iterator() {
        return new CircularQueueIterator();
    }

    private class CircularQueueIterator implements Iterator<T> {
        int current;

        public CircularQueueIterator() {
            current = 0;
        }

        public boolean hasNext() {
            return current < size;
        }

        public T next() {
            if (current == size)
                throw new NoSuchElementException("Cannot call next() on last item in deque");
            return items[(start + current++) % capacity];
        }

        public void remove() {
            throw new UnsupportedOperationException("Cannot remove in iterator");
        }
    }
}
