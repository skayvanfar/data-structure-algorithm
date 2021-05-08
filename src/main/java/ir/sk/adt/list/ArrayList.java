package ir.sk.adt.list;

import ir.sk.helper.complexity.AmortizedTimeComplexity;
import ir.sk.helper.complexity.TimeComplexity;

import java.util.Iterator;

/**
 * Use dynamic array logic
 * <p>
 * Created by sad.keyvanfar on 8/25/2020.
 */
public class ArrayList<T> implements List<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private T[] items; // the items in the List
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * If the array is full, replace it with a new, larger array;
     * store the new item after the last item
     * and increment the count of the number of items in the List.
     *
     */
    @Override
    @AmortizedTimeComplexity("O(1)")
    public void add(T item) {
        // if array is full, get new array of double size,
        // and copy items from old array to new array
        if (items.length == size) {
            expandArray();
        }

        // add new item; update numItems
        items[size++] = item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Get a new array of twice the current size.
     * Copy the items from the old array to the new array.
     * Make the new array be this List's "items" array.
     */
    @TimeComplexity("O(n)")
    private void expandArray() {
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[size * 2];
        for (int k = 0; k < size; k++) {
            newArray[k] = items[k];
        }
        items = newArray;
    }

    /**
     * Add item to the List in position pos (moving items over to the right to make room).
     * <p>
     * random access operation
     *
     */
    @Override
    @TimeComplexity("O(n)")
    public void add(int pos, T item) {
        // check for bad pos and for full array
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException();
        }
        if (items.length == size) {
            expandArray();
        }

        // move items over and insert new item
        for (int k = size; k > pos; k--) {
            items[k] = items[k - 1];
        }
        items[pos] = item;
        size++;
    }

    @TimeComplexity("O(1)")
    @Override
    public T get(int pos) {
        if (pos >= size || pos < 0)
            throw new IndexOutOfBoundsException("Index: " + pos + ", Size " + pos);

        return items[pos];
    }

    /**
     * delete item from the List in position pos (moving items over to the left to shrink).
     * <p>
     * random access operation
     *
     */
    @TimeComplexity("O(n)")
    @Override
    public T remove(int pos) {
        if (pos >= size || pos < 0)
            throw new IndexOutOfBoundsException("Index: " + pos + ", Size " + pos);
        T object = items[pos];
        items[pos] = null;
        int tmp = pos;
        // shrink
        while (tmp < size) {
            items[tmp] = items[tmp + 1];
            items[tmp + 1] = null;
            tmp++;
        }
        size--;
        return object;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
