package ir.sk.adt.queue.priorityqueue;

import ir.sk.adt.datastructure.tree.binarytree.heaptree.MaxBinaryHeap;
import ir.sk.helper.complexity.TimeComplexity;

/**
 * It's just a wrapper for BinaryHeap
 *
 * @author <a href="sad.keyvanfar@gmail.com">Saeed Kayvanfar</a> on 7/2/2020.
 */
public class MaxHeapPriorityQueue<T extends Integer> implements MaxPriorityQueue<T> {

    private static final int CAPACITY = 15;

    private MaxBinaryHeap binaryHeap = new MaxBinaryHeap(CAPACITY);

    public MaxHeapPriorityQueue() {
    }

    public MaxHeapPriorityQueue(T capacity) {
        this.binaryHeap = new MaxBinaryHeap(capacity);
    }

    /**
     * @param value
     */
    @Override
    @TimeComplexity("O(Log n)")
    public void insert(T value) {
        this.binaryHeap.insert(value);
    }

    /**
     * @return
     */
    @Override
    @TimeComplexity("O(1)")
    public T max() {
        return (T) Integer.valueOf(this.binaryHeap.max());
    }

    /**
     * @return
     */
    @Override
    @TimeComplexity("O(Log n)")
    public T extractMax() {
        return (T) Integer.valueOf(this.binaryHeap.extractMax());
    }


}
