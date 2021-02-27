package ir.sk.algorithm.median;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Heap-based Approach
 * <p>
 * A min-heap that contains the larger half of the elements, with the minimum element at the root
 * A max-heap that contains the smaller half of the elements, with the maximum element at the root
 * <p>
 * had two heaps, you could keep track of the bigger half and the smaller half of the
 * elements. The bigger half is kept in a min heap, such that the smallest element in the bigger half is at
 * the root. The smaller half is kept in a max heap, such that the biggest element of the smaller half is at the
 * root. Now, with these data structures, you have the potential median elements at the roots. If the heaps
 * are no longer the same size, you can quickly "rebalance" the heaps by popping an element off the one
 * heap and pushing it onto the other.
 * <p>
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class HeapMedianOfIntegerStream implements MedianOfIntegerStream {

    private Queue<Integer> minHeap, maxHeap;

    public HeapMedianOfIntegerStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    /**
     * time complexity: O(Log n)
     *
     * @param num
     */
    @Override
    public void add(int num) {
        if (!minHeap.isEmpty() && num < minHeap.peek()) {
            maxHeap.offer(num);
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
        } else {
            minHeap.offer(num);
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    /**
     * time complexity: O(1)
     *
     * @return
     */
    @Override
    public double getMedian() {
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
