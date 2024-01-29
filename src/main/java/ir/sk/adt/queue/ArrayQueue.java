package ir.sk.adt.queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author <a href="sad.keyvanfar@gmail.com">Saeid Keyvanfar</a> on 12/10/2017.
 */
public class ArrayQueue<T> implements Queue<T>, Iterable<T> {

    private Object[] queueArray;
    private int front, rear;
    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queueArray = new Object[this.capacity];
        front = 0;
        rear = 0;
    }

    /**
     * @param item
     */
    @Override
    public void enqueue(T item) {
        if (rear == capacity - 1)
            throw new RuntimeException("Queue Overflow");

        queueArray[++rear] = item;
    }

    /**
     * It's better to shift for better space management
     *
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (front == rear)
            throw new RuntimeException("Queue is Empty");

        return (T) queueArray[front++];
    }

    /**
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        return (T) queueArray[front];
    }

    @Override
    public void add(T item) {
        enqueue(item);
    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public int size() {
        return rear - front + 1;
    }

    public void display() {
        Arrays.stream(queueArray).forEach(o -> System.out.print(", " + o));
    }

    public Iterator<T> iterator() {
        return new ArrayQueue.ArrayIterator();
    }

    /**
     * an iterator, doesn't implement remove() since it's optional
     */
    private class ArrayIterator implements Iterator<T> {
        private int i = 0;

        public boolean hasNext() {
            return i <= rear;
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T item = (T) queueArray[(i + front) % queueArray.length];
            i++;
            return item;
        }
    }
}
