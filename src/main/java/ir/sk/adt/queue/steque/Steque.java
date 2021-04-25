package ir.sk.adt.queue.steque;

/**
 * Steque is a stack-ended data structure which
 * supports stack operations as well as queue's
 * enqueue operation.
 *
 * Created by sad.kayvanfar on 4/25/2021.
 */
public interface Steque<T> {
    void enqueue(T item);
    void push(T item);
    T pop();
}
