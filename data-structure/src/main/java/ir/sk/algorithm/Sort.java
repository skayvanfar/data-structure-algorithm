package ir.sk.algorithm;

import ir.sk.datastructure.fundamental.tree.binarytree.MaxBinaryHeap;

import java.util.Arrays;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/7/2017.
 */
public class Sort {

    /**
     * compare and swap
     * Stable: Yes
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int out = 0; out < n; out++) {
            for (int in = 1; in < (n - out); in++)
                if (array[in - 1] > array[in])
                    array[in] = Utils.gSwap(array[in - 1], array[in - 1] = array[in]); // swap them A[j], A[j - 1]
        }
    }


    /**
     * compare and swap
     * The selection sort performs the same number of comparisons as the bubble sort.
     * but lower swap
     *
     * @param array
     */
    public static void selectionSort(int[] array) {
        int out, in, min;
        for (out = 0; out < array.length - 1; out++) { // outer loop
            min = out; // minimum
            for (in = out + 1; in < array.length; in++) // inner loop
                if (array[in] < array[min]) // if min greater,
                    min = in; // we have a new min
            array[out] = Utils.gSwap(array[min], array[min] = array[out]); // swap them
        } // end for(out)
    }

    /**
     * Time Complexity: O(n*2)
     * Auxiliary Space: O(1)
     * <p>
     * compare and copy
     * twice faster than bubble sort and faster than selection sort
     * Stable: Yes
     * Sorting In Place: Yes
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            int key = array[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j] > key) {
                // using rotate by condition(array[j] > key), no swap, since shifting has better performance than swap
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    /**
     * better performance when comparing is costly for example for record data
     * using binary search instead of comparing fro finding the place of an item
     * <p>
     * Time Complexity: O(n*2)
     * Auxiliary Space: O(1)
     *
     * @param array
     */
    public static void binaryInsertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];

            // Find location to insert using binary search
            int loc = Math.abs(Arrays.binarySearch(array, 0, i, key) + 1);

            // Move all elements after location to create space
            // Shifting array to one location right
            Utils.rotate(array, loc, i);
            // System.arraycopy(array, loc, array, loc + 1, i - loc);
            // Placing element at its correct location
            // array[loc] = key;
        }
    }

    /**
     * T(n) = 2T(n/2) + O(n)
     * Time Complexity: O(n * log n)
     * Auxiliary Space: O(n)
     * Stable: Yes
     * Sorting In Place: No
     *
     * @param a
     * @param n
     */
    public static void mergeSort(int[] a, int n) {

        // base case
        if (n < 2)
            return;

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    /**
     * @param a
     * @param l
     * @param r
     * @param left
     * @param right
     */
    private static void merge(
            int[] a, int[] l, int[] r, int left, int right) {
        Utils.twoFingerAlgorithm(a, l, r, left, right);
    }

    /**
     * Divide-and-conquer algorithm and recursive
     * <p>
     * Time Complexity: O(n * log n)
     * Auxiliary Space: O(1) improved over normal merge sort O(n)
     * Sorting In Place: Yes
     *
     * @param array
     */
    public static void inPlaceMergeSort(int[] array) {
        // provides workspace
        int[] workSpace = new int[array.length];
        recMergeSort(array, workSpace, 0, array.length - 1);
    }

    private static void recMergeSort(int[] array, int[] workSpace, int lowerBound,
                                     int upperBound) {
        if (lowerBound == upperBound)            // if range is 1,
            return;                              // no use sorting
        else {                                    // find midpoint
            int mid = (lowerBound + upperBound) / 2;
            // sort low half
            recMergeSort(array, workSpace, lowerBound, mid);
            // sort high half
            recMergeSort(array, workSpace, mid + 1, upperBound);
            // merge them
            merge(array, workSpace, lowerBound, mid + 1, upperBound);
        }  // end else
    }  // end recMergeSort()

    //-----------------------------------------------------------
    private static void merge(int[] array, int[] workSpace, int lowPtr,
                              int highPtr, int upperBound) {
        int j = 0;                             // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;       // # of items

        while (lowPtr <= mid && highPtr <= upperBound)
            if (array[lowPtr] < array[highPtr])
                workSpace[j++] = array[lowPtr++];
            else
                workSpace[j++] = array[highPtr++];

        while (lowPtr <= mid)
            workSpace[j++] = array[lowPtr++];

        while (highPtr <= upperBound)
            workSpace[j++] = array[highPtr++];

        for (j = 0; j < n; j++)
            array[lowerBound + j] = workSpace[j];
    }

    /**
     * 1. Build Max Heap from unordered array;
     * 2. Find maximum element A[1];
     * 3. Swap elements A[n] and A[1]:
     * now max element is at the end of the array!
     * 4. Discard node n from heap
     * (by decrementing heap-size variable)
     * 5. New root may violate max heap property, but its
     * children are max heaps. Run max_heapify to fix this.
     * 6. Go to Step 2 unless heap is empty
     *
     * Time Complexity: O(n * log n)
     * Auxiliary Space: O(1)
     * Sorting In Place: Yes
     *
     * @param array
     */
    public static void heapSort(int[] array) {

        // Build heap (rearrange array)
        MaxBinaryHeap heap = new MaxBinaryHeap(array);
        heap.buildMaxHeap();

        // One by one extract an element from heap
        for (int i = heap.getHeapSize(); i > 0; i--) {
            // Move current root to end, swap
            array[0] = Utils.gSwap(array[i], array[i] = array[0]);
            heap.setHeapSize(heap.getHeapSize() - 1);
            // call max heapify on the reduced heap
            heap.maxHeapify(0);
        }
    }
}
