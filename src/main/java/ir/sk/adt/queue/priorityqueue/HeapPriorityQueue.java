package ir.sk.adt.queue.priorityqueue;

import ir.sk.adt.datastructure.tree.binarytree.MaxBinaryHeap;
import ir.sk.helper.complexity.TimeComplexity;

/**
 * It's just a wrapper for BinaryHeap
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/2/2020.
 */
public class HeapPriorityQueue<T extends Integer> implements PriorityQueue<T> {

    private static final int CAPACITY = 15;

    private MaxBinaryHeap binaryHeap = new MaxBinaryHeap(CAPACITY);

    public HeapPriorityQueue() {
    }

    public HeapPriorityQueue(T capacity) {
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
