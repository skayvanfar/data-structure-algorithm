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

    public void insert(T item) // insert item
    {
        int j;
        if (nItems == 0) // if no items,
            queArray[nItems++] = item; // insert at 0
        else // if items,
        {
            for (j = nItems - 1; j >= 0; j--) // start at end,
            {
                if (item.compareTo(queArray[j]) > 0) // if new item larger,
                    queArray[j + 1] = queArray[j]; // shift upward
                else // if smaller,
                    break; // done shifting
            } // end for
            queArray[j + 1] = item; // insert it
            nItems++;
        } // end else (nItems > 0)
    } // end insert()

    public T remove() // remove minimum item
    {
        return (T) queArray[--nItems];
    }

    public T peekMin() // peek at minimum item
    {
        return (T) queArray[nItems - 1];
    }

    public boolean isEmpty() // true if queue is empty
    {
        return (nItems == 0);
    }

    public boolean isFull() // true if queue is full
    {
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
