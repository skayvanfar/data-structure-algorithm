package ir.sk.datastructure.queue;

import ir.sk.datastructure.fundamental.tree.binarytree.MaxBinaryHeap;

/**
 * It's just a wrapper for BinaryHeap
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/2/2020.
 */
public class HeapPriorityQueue {

    private static final int CAPACITY = 15;

    private MaxBinaryHeap binaryHeap = new MaxBinaryHeap(CAPACITY);

    public HeapPriorityQueue() {
    }

    public HeapPriorityQueue(int capacity) {
        this.binaryHeap = new MaxBinaryHeap(capacity);
    }

    /**
     * Time Complexity: O(Log n)
     *
     * @param value
     */
    public void insert(int value) {
        this.binaryHeap.insert(value);
    }

    /**
     * Time Complexity: O(1)
     *
     * @return
     */
    public int max() {
        return this.binaryHeap.max();
    }

    /**
     * Time Complexity: O(Log n)
     *
     * @return
     */
    public int extractMax() {
        return this.binaryHeap.extractMax();
    }


}
