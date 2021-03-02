package ir.sk.datastructure.bag;

import ir.sk.datastructure.Collection;

/**
 * Bag is ADT of the collection of elements which allows duplicates.
 *
 * @param <T>
 */
public interface Bag<T> extends Collection<T> {
    void add(T item);
   // void remove(T item);
    boolean isEmpty();
}
