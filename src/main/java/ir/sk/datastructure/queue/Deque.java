package ir.sk.datastructure.queue;

/**
 * Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or
 * a queue but supports adding and removing items at both ends.
 *
 * Created by sad.kayvanfar on 3/8/2021.
 */
public interface Deque<T> {
    boolean isEmpty();
    void pushLeft(T item);
    void pushRight(T item);
    T popLeft();
    T popRight();
}
