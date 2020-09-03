package ir.sk.datastructure.fundamental.tree.binarytree;

import ir.sk.helper.TimeComplexity;

/**
 * binary heap is an complete Binary tree
 * The heap is one maximally efficient implementation of an abstract data type called a priority queue.
 * The heap property:
 * Min-heap: a parent has a lower key than its children.
 * Max-heap: a parent has a upper key than its children.
 * <p>
 * It's usually implemented by Arrays because a binary heap is always a complete binary tree
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/2/2020.
 */
public class MaxBinaryHeap {

    private int[] array;
    private int heapSize;

    public MaxBinaryHeap(int capacity) {
        this.array = new int[capacity];
        this.heapSize = 0;
    }

    public MaxBinaryHeap(int[] array) {
        this.array = array;
        this.heapSize = array.length - 1;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    /**
     * @param index
     * @return
     */
    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    /**
     * @param index
     * @return
     */
    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    /**
     * @param index
     * @return
     */
    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    /**
     * It returns the root element of Max Heap.
     *
     * @return
     */
    @TimeComplexity("O(1)")
    public int max() {
        return array[0];
    }

    /**
     * Removes the maximum element from MaxHeap.
     * this operation needs to maintain the heap property (by calling heapify()) after removing root.
     *
     * @return
     */
    @TimeComplexity("O(Log n)")
    public int extractMax() {
        int max = array[0];
        swap(0, array.length - 1);
        maxHeapify(0);
        return max;
    }

    /**
     * We can insert an element with the following steps:
     * 1. create a new leaf which is the rightmost available slot on the deepest level and store the item in that node
     * if the element is less than it's parent, we swap them
     * 2. continue with step 2, until the element is less than it's parent or it becomes the new root
     *
     * @param element
     */
    @TimeComplexity("O(Log n)")
    public void insert(int element) {
        if (heapSize >= array.length)
            return;

        array[++heapSize] = element;
        int current = heapSize;

        while (array[current] > array[parentIndex(current)]) {
            swap(current, parentIndex(current));
            current = parentIndex(current);
        }
    }

    private void swap(int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    /**
     * Assume that the trees rooted at left(i) and right(i)
     * are max-heaps
     *
     * @param index
     */
    @TimeComplexity("O(Log n)")
    public void maxHeapify(int index) {
        int left = leftChildIndex(index);
        int right = rightChildIndex(index);
        int max;

        if (left <= heapSize && array[left] > array[index])
            max = left;
        else
            max = index;

        if (right <= heapSize && array[right] > array[max])
            max = right;

        if (max != index) {
            swap(index, max);
            maxHeapify(max);
        }
    }

    /**
     * Converts A[1…n] to a max heap
     * Why start at n/2? Because elements A[n/2 + 1 … n] are all leaves of the tree 2i > n, for i > n/2 + 1
     */
    @TimeComplexity("O(n)")
    public void buildMaxHeap() {
        for (int i = heapSize / 2; i >= 0; i--)
            maxHeapify(i);
    }

    public void printArray() {
        int n = array.length;
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
