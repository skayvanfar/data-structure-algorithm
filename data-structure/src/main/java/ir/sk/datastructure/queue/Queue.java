package ir.sk.datastructure.queue;

/**
 * A queue implements FIFO (first-in first-out) ordering. As in a line or queue at a ticket stand, items are
 * removed from the data structure in the same order that they are added.
 * <p>
 * Created by sad.kayvanfar on 9/1/2020.
 */
public interface Queue<T> {

    void add(T item);

    T remove();

    T peek();

    boolean isEmpty();

}
