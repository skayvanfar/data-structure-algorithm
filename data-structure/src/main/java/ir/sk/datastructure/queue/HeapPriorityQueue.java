package ir.sk.datastructure.queue;

import ir.sk.datastructure.fundamental.tree.binarytree.MaxBinaryHeap;

/**
 * It's just a wrapper for BinaryHeap
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/2/2020.
 */
public class HeapPriorityQueue {

    private MaxBinaryHeap binaryHeap = new MaxBinaryHeap(15);

    public HeapPriorityQueue(int capacity) {
        this.binaryHeap = new MaxBinaryHeap(capacity);
    }

    public void insert(int value) {
        this.binaryHeap.insert(value);
    }

    public int max() {
        return this.binaryHeap.max();
    }

    public int extractMax() {
        return this.binaryHeap.extractMax();
    }


}
