package ir.sk.datastructure.bag;

/**
 * Bag is ADT of the collection of elements which allows duplicates.
 *
 * @param <T>
 */
public interface Bag<T> {
    void add(T item);
    boolean isEmpty();
}
