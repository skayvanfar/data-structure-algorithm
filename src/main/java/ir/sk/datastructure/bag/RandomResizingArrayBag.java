package ir.sk.datastructure.bag;

import java.util.Iterator;
import java.util.Random;

/**
 * this API is the same as for
 * Bag, except for the adjective random, which indicates that the iteration should provide
 * the items in random order (all N ! permutations equally likely, for each iterator). Hint :
 * Put the items in an array and randomize their order in the iterator’s constructor.
 * <p>
 * Created by sad.kayvanfar on 3/8/2021.
 */
public class RandomResizingArrayBag<T> implements Bag<T>, Iterable<T> {
    T[] items;
    int N;

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
                int rand = random.nextInt(N - 0 + 1) + 0;
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
