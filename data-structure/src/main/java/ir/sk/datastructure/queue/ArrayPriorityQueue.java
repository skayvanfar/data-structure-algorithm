package ir.sk.datastructure.queue;

import java.util.Arrays;

/**
 * Simple array-based priority queue
 * This implementation suffers from slow insertion, but it’s
 * simpler and is appropriate when the number of items isn’t high or insertion speed
 * isn’t critical.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class ArrayPriorityQueue<T extends Comparable> {

    // array in sorted order, from max at 0 to min at size-1
    private int maxSize;
    private Comparable[] queArray;
    private int nItems;

    public ArrayPriorityQueue(int s) {
        maxSize = s;
        queArray = new Comparable[maxSize];
        nItems = 0;
    }

    /**
     * Time Complexity: O(n)
     *
     * @param item
     */
    public void insert(T item) {
        int j;
        if (nItems == 0)
            queArray[nItems++] = item; // insert at 0
        else {
            // start at end,
            for (j = nItems - 1; j >= 0; j--) {
                if (item.compareTo(queArray[j]) > 0) // if new item larger,
                    queArray[j + 1] = queArray[j]; // shift upward
                else // if smaller,
                    break; // done shifting
            }
            queArray[j + 1] = item;
            nItems++;
        }
    }

    /**
     * remove minimum item
     * <p>
     * Time Complexity: O(1)
     *
     * @return
     */
    public T remove() {
        return (T) queArray[--nItems];
    }

    /**
     * peek at minimum item
     * <p>
     * Time Complexity: O(1)
     *
     * @return
     */
    public T peekMin() {
        return (T) queArray[nItems - 1];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
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
