package ir.sk.adt.datastructure.tree.binarytree.heaptree;

import ir.sk.helper.complexity.TimeComplexity;

/**
 * two properties of a heap:
 * 1. binary heap is an complete Binary tree
 * 2. a heap must either be greater than or equal to the value of its children nodes, or less than or equal to the value of its children nodes
 * <p>
 * The heap is one maximally efficient implementation of an abstract data type called a priority queue.
 * The heap property:
 * Min-heap: a parent has a lower key than its children.
 * Max-heap: a parent has a upper key than its children.
 * <p>
 * It's usually implemented by Arrays because a binary heap is always a complete binary tree
 * A binary heap must be a complete tree,children are added at each level from left to right,and usually implemented as arrays.(putting the nodes in level order)
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/2/2020.
 */
public class MaxBinaryHeap {

    private int[] array;
    private int size;

    public MaxBinaryHeap(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    public MaxBinaryHeap(int[] array) {
        this.array = array;
        this.size = array.length - 1;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * in complete binary trees we can get parent item  using this formula: floor((i — 1) / 2)
     *
     * @param index
     * @return
     */
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    /**
     * in complete binary trees we can get left child using this formula: (2i + 1)
     *
     * @param index
     * @return
     */
    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    /**
     * in complete binary trees we can get left child using this formula: (2i + 2)
     *
     * @param index
     * @return
     */
    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    /**
     * peek operation
     * It returns the root element of Max Heap.
     *
     * @return
     */
    @TimeComplexity("O(1)")
    public int max() {
        return array[0];
    }

    /**
     * poll operation
     * Removes the maximum element from MaxHeap.
     * this operation needs to maintain the heap property (by calling heapify()) after removing root.
     *
     * @return
     */
    @TimeComplexity("O(Log n)")
    public int extractMax() {
        int max = array[0];
        swap(0, size - 1);
        array[size - 1] = 0; // Avoid loitering.

        heapifyDown(0);
        return max;
    }

    /**
     * Assume that the trees rooted at left(i) and right(i)
     * are max-heaps
     *
     * @param index
     */
    @TimeComplexity("O(Log n)")
    public void heapifyDown(int index) {
        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);
        int max;

        if (left <= size && array[left] > array[index])
            max = left;
        else
            max = index;

        if (right <= size && array[right] > array[max])
            max = right;

        if (max != index) {
            swap(index, max);
            heapifyDown(max);
        }
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
        if (size >= array.length)
            return;

        array[++size] = element;
        heapifyUp();
    }

    /**
     *
     */
    @TimeComplexity("O(Log n)")
    private void heapifyUp() {
        int current = size;

        while (array[current] > array[getParentIndex(current)]) {
            swap(current, getParentIndex(current));
            current = getParentIndex(current);
        }
    }

    private void swap(int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }


    /**
     * Converts A[1…n] to a max heap
     * Why start at n/2? Because elements A[n/2 + 1 … n] are all leaves of the tree 2i > n, for i > n/2 + 1
     */
    @TimeComplexity("O(n)")
    public void buildMaxHeap() {
        for (int i = size / 2; i >= 0; i--)
            heapifyDown(i);
    }

    public void printArray() {
        int n = array.length;
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
