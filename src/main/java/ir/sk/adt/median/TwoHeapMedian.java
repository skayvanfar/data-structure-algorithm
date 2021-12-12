package ir.sk.adt.median;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Design a data structure, which supports several operations: insert a number with O(logN),
 * return the median element with O(1), delete the median element with O(logN),
 * where N is the number of elements in the data structure.
 *
 * Created by sad.kayvanfar on 12/12/2021.
 */
public class TwoHeapMedian implements MedianADT {

    private Queue<Integer> minHeap, maxHeap;

    public TwoHeapMedian() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    @Override
    public void add(int item) {
        if (!minHeap.isEmpty() && item < minHeap.peek()) {
            maxHeap.offer(item);
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
        } else {
            minHeap.offer(item);
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    @Override
    public int getMedian() {
        int median;
        if (minHeap.size() < maxHeap.size()) {
            median = maxHeap.peek();
        } else if (minHeap.size() > maxHeap.size()) {
            median = minHeap.peek();
        } else {
            median = (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return median;
    }
}
