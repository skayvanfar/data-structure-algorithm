package ir.sk.adt.queue.priorityqueue;

import ir.sk.helper.complexity.TimeComplexity;

import java.util.Arrays;

/**
 * Simple ordered array-based priority queue
 * its eager implementation where we do as much work
 * as we can up front (keep the list sorted on insertion)
 * to make later operations efficient.
 *
 * This implementation suffers from slow insertion, but it’s
 * simpler and is appropriate when the number of items isn’t high or insertion speed
 * isn’t critical.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class OrderedArrayPriorityQueue<T extends Comparable> implements PriorityQueue<T> {

    // array in sorted order, from max at 0 to min at size-1
    private Comparable[] queArray;
    private int capacity;
    private int size;

    public OrderedArrayPriorityQueue(int capacity) {
        this.capacity = capacity;
        queArray = new Comparable[capacity];
        size = 0;
    }

    /**
     *
     * @param item
     */
    @TimeComplexity("O(n)")
    public void insert(T item) {
        int j;
        if (size == 0)
            queArray[size++] = item; // insert at 0
        else {
            // start at end,
            for (j = size - 1; j >= 0; j--) {
                if (item.compareTo(queArray[j]) < 0) // if new item larger,
                    queArray[j + 1] = queArray[j]; // shift upward
                else // if larger,
                    break; // done shifting
            }
            queArray[j + 1] = item;
            size++;
        }
    }

    /**
     * remove maximum item
     *
     * @return
     */
    @TimeComplexity("O(1)")
    public T max() {
        return (T) queArray[--size];
    }

    /**
     * peek at maximum item
     *
     * @return
     */
    @TimeComplexity("O(1)")
    public T extractMax() {
        return (T) queArray[size - 1];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == capacity);
    }

    public void display() {
        System.out.print("\nPriorityQueue = ");
        if (queArray.length == 0) {
            System.out.print("Empty\n");
            return;
        }
        Arrays.stream(queArray).forEach(o -> System.out.print(", " + o));
        System.out.println();
    }

}
