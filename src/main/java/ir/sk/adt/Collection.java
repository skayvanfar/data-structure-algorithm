package ir.sk.adt;

/**
 * In general, anything that holds an elements is Collection.
 * Any collection which allows duplicates is Bag, otherwise it is Set.
 * Any bag which access elements via index is List.
 * Bag which appends new element after the last one and has a method to remove element from the head (first index) is Queue.
 * Bag which appends new element after the last one and has a method to remove element from the tail (last index) is Stack.
 *
 * In Java, LinkedList is a collection, bag, list,
 * queue and also you can work with it as it was a stack since it support stack operations
 * (add~addLast~push, peekLast, removeLast~pop), so you can call it also stack.
 *
 * @param <T>
 */
public interface Collection<T> {
}
