package ir.sk.adt.bag;

import java.util.Iterator;
import java.util.Random;

/**
 * Put the items in an array and randomize their order in the iterator’s constructor.
 * <p>
 * Created by sad.kayvanfar on 3/8/2021.
 */
public class RandomResizingArrayBag<T> implements RandomBag<T>, Iterable<T> {

    private T[] items;
    private int N;

    public RandomResizingArrayBag() {
        items = (T[]) new Object[4];
        N = 0;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    @Override
    public void add(T item) {
        items[N++] = item;
        if (items.length == N) {
            resize(items.length * 2);
        }
    }

    public void resize(int size) {
        T[] copy = (T[]) new Object[size];
        for (int i = 0; i < N; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < N; i++) {
            s += items[i] + " ";
        }
        return s;
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomBagIterator();
    }

    public class RandomBagIterator implements Iterator<T> {
        int current;

        public RandomBagIterator() {
            current = 0;
            Random random = new Random();
            for (int i = 0; i < N; i++) {
                int rand = random.nextInt(N + 1);
                T copy = items[rand];
                items[rand] = items[i];
                items[i] = copy;
            }
        }

        @Override
        public boolean hasNext() {
            return current < N;
        }

        @Override
        public T next() {
            return items[current++];
        }

    }

}
