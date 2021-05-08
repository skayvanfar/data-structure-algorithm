package ir.sk.adt.bag;

import ir.sk.adt.Collection;

/**
 * Bag is ADT of the collection of elements which allows duplicates.
 *
 * @param <T>
 */
public interface Bag<T> extends Collection<T>, Iterable<T> {
    void add(T item);
   // void remove(T item);
    boolean isEmpty();

    int size();
}
