package ir.sk.adt.queue.priorityqueue;

/**
 * Created by sad.kayvanfar on 4/25/2021.
 */
public interface PriorityQueue {
    void insert(int value);
    int max();
    int extractMax();
}
