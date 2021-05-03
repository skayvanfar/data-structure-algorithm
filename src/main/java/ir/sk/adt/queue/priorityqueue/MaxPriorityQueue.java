package ir.sk.adt.queue.priorityqueue;

/**
 * Created by sad.kayvanfar on 4/25/2021.
 */
public interface MaxPriorityQueue<T> {
    void insert(T value);
    T max();
    T extractMax();
}
