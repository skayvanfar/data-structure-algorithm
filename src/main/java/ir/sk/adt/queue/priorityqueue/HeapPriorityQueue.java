package ir.sk.adt.queue.priorityqueue;

import ir.sk.adt.datastructure.tree.binarytree.MaxBinaryHeap;
import ir.sk.helper.complexity.TimeComplexity;

/**
 * It's just a wrapper for BinaryHeap
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/2/2020.
 */
public class HeapPriorityQueue implements PriorityQueue {

    private static final int CAPACITY = 15;

    private MaxBinaryHeap binaryHeap = new MaxBinaryHeap(CAPACITY);

    public HeapPriorityQueue() {
    }

    public HeapPriorityQueue(int capacity) {
        this.binaryHeap = new MaxBinaryHeap(capacity);
    }

    /**
     * @param value
     */
    @Override
    @TimeComplexity("O(Log n)")
    public void insert(int value) {
        this.binaryHeap.insert(value);
    }

    /**
     * @return
     */
    @Override
    @TimeComplexity("O(1)")
    public int max() {
        return this.binaryHeap.max();
    }

    /**
     * @return
     */
    @Override
    @TimeComplexity("O(Log n)")
    public int extractMax() {
        return this.binaryHeap.extractMax();
    }


}
