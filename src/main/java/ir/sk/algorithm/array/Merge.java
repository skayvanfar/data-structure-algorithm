package ir.sk.algorithm.array;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.MultipleFinger;
import ir.sk.helper.technique.BruteForce;
import ir.sk.helper.technique.DivideAndConquer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sad.kayvanfar on 12/26/2020.
 */
public class Merge {

    public static int[] mergeByTwoFinger(int[] l, int[] r) {
        int a[] = new int[l.length + r.length];
        mergeByTwoFinger(a, l, r, l.length, r.length);
        return a;
    }

    /**
     * two-way merge - union - binary merge
     * two-way algorithm that helps us merge two sorted arrays together in one sorted array.
     *
     * @param a     returned array
     * @param l     first ordered array
     * @param r     second ordered array
     * @param left  last index of l array to compare
     * @param right last index of r array to compare
     */
    @MultipleFinger
    @TimeComplexity("O(n+m)")
    public static void mergeByTwoFinger(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;

        // compares the elements of both sub-arrays one by one and places the smaller element into the input array.
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        // When we reach the end of one of the sub-arrays,
        // the rest of the elements from the other array are copied into the input array
        while (i < left) {
            a[k++] = l[i++];
        }

        while (j < right) {
            a[k++] = r[j++];
        }

    }

    /**
     * Create a output array of size n * k.
     * Traverse the matrix from start to end and insert all the elements in output array.
     * Sort and print the output array.
     *
     * @param arrays
     * @return
     */
    @TimeComplexity("O(nk + nk * log nk) k: length of each array. n: length of arrays")
    @SpaceComplexity("nk  The output array is of size n*k")
    @BruteForce
    public static int[] kWayMargeNaive(int[]... arrays) {
        int size = Arrays.stream(arrays).map(ints -> ints.length).reduce((integer, integer2) -> integer + integer2).get();
        int[] result = new int[size];

        int k = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                result[k++] = arrays[i][j];
            }
        }

        Arrays.sort(result);
        return result;
    }

    /**
     * he process might begin with merging arrays into groups of two.
     * After the first merge, we have k/2 arrays. Again merge arrays in groups, now we have k/4 arrays.
     * This is similar to merge sort. Divide k arrays into two halves containing an equal number of arrays until there are two arrays in a group.
     * <p>
     * height of tree: log n
     *
     * @param start
     * @param end
     * @param arrays
     * @return
     */
    @DivideAndConquer
    @TimeComplexity("O(nk * log n) k: length of each array. n: length of arrays")
    @SpaceComplexity("O(nk * log n)")
    public static int[] kWayMargeRecursive(int start, int end, int[]... arrays) {
        if (start == end)
            return arrays[start];
        else {
            int size = (end - start) / 2;
            return mergeByTwoFinger(kWayMargeRecursive(0, size, arrays), kWayMargeRecursive(size + 1, end, arrays));
        }
    }

    static class HeapNode {
        int value;
        int i;
        int j;

        public HeapNode(int value, int i, int j) {
            this.value = value;
            this.i = i;
            this.j = j;
        }
    }

    /**
     * Create a min Heap and insert the first element of all k arrays.
     * Run a loop until the size of MinHeap is greater than zero.
     * Remove the top element of the MinHeap and print the element.
     * Now insert the next element from the same array in which the removed element belonged.
     * If the array doesn’t have any more elements, then replace root with infinite.After replacing the root, heapify the tree.
     *
     * @param arrays
     * @return
     */
    @TimeComplexity("O(nk * log n)")
    @SpaceComplexity("O(nk + n)")
    public static int[] kWayMergeByHeap(int[]... arrays) {
        int size = Arrays.stream(arrays).map(ints -> ints.length).reduce((integer, integer2) -> integer + integer2).get();
        int[] result = new int[size];

        PriorityQueue<HeapNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));

        for (int i = 0; i < arrays.length; i++)
            queue.add(new HeapNode(arrays[i][0], i, 0));

        for (int i = 0; i < size; i++) {
            HeapNode element = queue.poll();

            result[i] = element.value;

            if (++element.j < arrays[element.i].length)
                element.value = arrays[element.i][element.j];
            else
                element.value = Integer.MAX_VALUE;
            queue.add(element);
        }
        return result;
    }
}
