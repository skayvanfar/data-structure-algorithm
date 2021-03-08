package ir.sk.datastructure.fundamental.linklist;

import ir.sk.datastructure.queue.Queue;
import ir.sk.datastructure.queue.Steque;
import ir.sk.datastructure.stack.Stack;

import java.util.Iterator;

/**
 * Created by sad.kayvanfar on 3/8/2021.
 */
public class Deque<T> implements Queue<T>, Stack<T>,Iterable<T> {

    private FirstLastList<T> theList;

    public Deque() {
        theList = new FirstLastList();
    }

    @Override
    public void enqueue(T item) {
        theList.insertLast(item);
    }

    @Override
    public T dequeue() {
        return theList.deleteFirst();
    }

    @Override
    public T peek() {
        return theList.peakFirst();
    }

    @Override
    public void push(T item) {
        theList.insertFirst(item);
    }

    public T pop() {
        return theList.deleteFirst();
    }

    @Override
    public void add(T item) {
        enqueue(item);
    }

    @Override
    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public Iterator<T> iterator() {
        return theList.iterator();
    }
}
