package ir.sk.datastructure.set;

/**
 * Set is ADT of the collection of elements which disallows duplicates, (opposite of bag)
 */
public interface Set<T> {
    void add(T item);
    void delete(T item);
    boolean isEmpty();
}
