package ir.sk.datastructure.set;

import java.util.Arrays;
import java.util.Iterator;

public class ArraySet<T> implements Set<T>, Iterable<T> {

    private T[] set;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArraySet(int capacity) {
        this.capacity = capacity;
        set = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void add(T item) {
        for (int i = 0; i < capacity; i++) {
            if (!contains(item)) {
                if (size == capacity) {
                    set = Arrays.copyOf(set, size * 2);
                }
                set[i++] = item;
            }
        }
        size++;

    }

    private T[] resize(int max) {  // Move stack to a new array of size max.
        return Arrays.copyOf(set, size * 2);
    }

    public boolean contains(T item) {
        for (T setItem : set) {
            if (setItem.equals(item))
                return true;
        }
        return false;
    }

    @Override
    public void remove(T item) {
        boolean remove = false;
        for (int i = 0; i < capacity; i++) {
            if (item.equals(set[i])) {
                set[i] = set[size - 1];
                size--;
                remove = true;
            }
            if (isEmpty()) {
                remove = false;
            }
        }
        //   return remove;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }


}
