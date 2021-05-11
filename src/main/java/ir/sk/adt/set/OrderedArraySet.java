package ir.sk.adt.set;

public class OrderedArraySet<T extends Comparable<T>> implements Set<T> {

    private static final int INIT_CAPACITY = 2;
    private T[] values;
    private int size = 0;

    public OrderedArraySet() {
        this.values = (T[]) new Object[INIT_CAPACITY];
    }

    public OrderedArraySet(int capacity) {
        this.values = (T[]) new Object[capacity];
    }

    // resize the underlying arrays
    private void resize(int capacity) {
        assert capacity >= size;
        T[] tempv = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            tempv[i] = values[i];
        values = tempv;
    }

    @Override
    public void add(T item) {
        if (item == null) throw new IllegalArgumentException("the argument is null");

        int i = rank(item);

        // Item is already in table
        if (i < size && values[i].compareTo(item) == 0) {
            values[i] = item;
            return;
        }

        // insert new item
        if (size == values.length) resize(2 * values.length);

        for (int j = size; j > i; j--)  {
            values[j] = values[j-1];
        }
        values[i] = item;
        size++;
    }

    @Override
    public void remove(T item) {
        // TODO: 5/5/21
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T item) {
        if (item == null) throw new IllegalArgumentException("argument to contains() is null");
        return rank(item) == 0 ? false : true;
    }

    public int rank(T item) {
        if (item == null) throw new IllegalArgumentException("argument to rank() is null");

        int lo = 0, hi = size -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = item.compareTo(values[mid]);
            if      (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
}
