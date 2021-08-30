package ir.sk.algorithm.others;

import ir.sk.adt.datastructure.tree.binarytree.heaptree.MaxBinaryHeap;
import ir.sk.adt.datastructure.tree.binarytree.binarysearchtree.BinarySearchTree;
import ir.sk.algorithm.array.Merge;
import ir.sk.algorithm.basic.RotationShift;
import ir.sk.algorithm.basic.Utils;
import ir.sk.helper.*;
import ir.sk.helper.complexity.InPlace;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.Stability;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.CyclicSortPattern;
import ir.sk.helper.pattern.MultiplePointerPattern;
import ir.sk.helper.technique.BacktrackingDFS;
import ir.sk.helper.technique.DivideAndConquer;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * main operations are compare and swap
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/7/2017.
 */
public class Sort {

    /**
     * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
     * <p>
     * In bubble sort, we start at the beginning of the array and swap the first two elements if the first is greater
     * than the second. Then, we go to the next pair, and so on, continuously making sweeps of the array until it is
     * sorted. In doing so, the smaller items slowly"bubble" up to the beginning of the list.
     * <p>
     * compare: O(n-1) + O(n - 2) + ... + 2 + 1 = n(n-1)/2 ~ n^2/2 = o(n^2)
     * swap: O(n-1) + O(n - 2) + ... + 2 + 1 = n(n-1)/2 ~ n^2/2 = o(n^2)
     *
     * @param array
     */
    @TimeComplexity("O(n^2) + O(n^2) = O(n^2)")
    @SpaceComplexity("O(1)")
    @InPlace
    @Stability
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++)
            for (int j = 0; j < array.length - i - 1; j++)
                if (array[j] > array[j + 1])
                    array[j + 1] = Utils.gSwap(array[j], array[j] = array[j + 1]); // swap them A[j], A[j - 1]
    }


    /**
     * Selection sort is a simple sorting algorithm. This sorting algorithm is
     * an in-place comparison-based algorithm in which the list is divided into two parts,
     * the sorted part at the left end and the unsorted part at the right end. Initially,
     * the sorted part is empty and the unsorted part is the entire list.
     * The smallest element is selected from the unsorted array and swapped with the leftmost element,
     * and that element becomes a part of the sorted array.
     * This process continues moving unsorted array boundary by one element to the right.
     * <p>
     * compare and swap
     * The selection sort performs the same number of comparisons as the bubble sort.
     * Data movement is minimal.
     * Running time is insensitive to input.
     * compare: O(n-1) + O(n - 2) + ... + 2 + 1 = n(n-1)/2 ~ n^2/2 = o(n^2)
     * swap: O(n)
     *
     * @param array
     */
    @TimeComplexity("O(n^2) + O(n) = O(n^2)")
    @SpaceComplexity("O(1)")
    @InPlace
    @Stability(value = false)
    public static void selectionSort(int[] array) {
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < array.length - 1; i++) {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[min])
                    min = j;
            // Swap the found minimum element with the first element
            array[i] = Utils.gSwap(array[min], array[min] = array[i]); // swap them
        }
    }

    /**
     * compare and copy
     * <p>
     * an in-place comparison-based algorithm in which the list is divided into two parts,
     * the partly sorted part at the left end and the unsorted part at the right end.
     * <p>
     * a few advantages: simple implementation, efficient for small data sets,
     * more efficient than selection sort or bubble sort, does not need much memory.
     * <p>
     * Insertion sort: inserts the next element at the correct position;
     * <p>
     * Selection sort: selects the smallest element and exchange it with the current item;
     * Insertion sort is an efficient method for partially sorted arrays; selection sort is not. Indeed, when
     * the number of inversions is low, insertion sort is likely to be faster than any sorting method
     * <p>
     * compare: O(n-1) + O(n - 2) + ... + 2 + 1 = n(n-1)/2 ~ n^2/2 = o(n^2)
     * swap: O(n-1) + O(n - 2) + ... + 2 + 1 = n(n-1)/2 ~ n^2/2 = o(n^2)
     *
     * @param array
     */
    @TimeComplexity("O(n ^ 2)")
    @SpaceComplexity("O(1)")
    @InPlace
    @Stability
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
     *
     * @param array
     */
    @TimeComplexity("O(n * 2)")
    @SpaceComplexity("O(1)")
    public static void binaryInsertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];

            // Find location to insert using binary search
            int loc = Math.abs(Arrays.binarySearch(array, 0, i, key) + 1);

            // Move all elements after location to create space
            // Shifting array to one location right
            RotationShift.rightRotate(array, loc, i);
            // System.arraycopy(array, loc, array, loc + 1, i - loc);
            // Placing element at its correct location
            // array[loc] = key;
        }
    }

    /**
     * Shell sort is a simple extension of insertion sort that gains
     * speed by allowing exchanges of array entries that are far apart, to produce partially
     * sorted arrays that can be efficiently sorted, eventually by insertion sort.
     * <p>
     * In insertion sort, we move elements only one position ahead. When an element has to be moved far ahead, many movements are involved.
     * The idea of shellSort is to allow exchange of far items. In shellSort, we make the array h-sorted for a large value of h.
     * We keep reducing the value of h until it becomes 1.
     * An array is said to be h-sorted if all sublists of every h’th element is sorted.
     * <p>
     * shell sort is much faster than insertion sort and
     * selection sort, and its speed advantage increases with the array size.
     * <p>
     * performance characteristics of shellsort requires mathematical arguments that are beyond
     *
     * @param array
     */
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(1)")
    @InPlace
    public static void shellSort(int[] array) {
        int N = array.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1) { // h-sort the array.
            for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && array[j] < array[j - h]; j -= h)
                    array[j] = Utils.gSwap(array[j - h], array[j - h] = array[j]);
                //    exch(a, j, j-h);
            }
            h = h / 3;
        }
    }

    /**
     * Top-down mergesort
     * <p>
     * recursive sort method known as mergesort
     * : to sort an array, divide it into two halves, sort the two halves (recursively), and
     * then merge the results. As you will see, one of mergesort’s most attractive properties is
     * that it guarantees to sort any array of N items in time proportional to N log N. Its prime
     * disadvantage is that it uses extra space proportional to N.
     * <p>
     * T(n) = 2T(n/2) + O(n)
     * Sorting In Place: No
     * n             n        n
     * / \
     * /    \
     * n/2     n/2       2 n/2     n
     * /  \    /  \
     * /    \  /    \
     * n/4   n/4 n/4   n/4  4 n/4     n
     * <p>
     * height of tree: log n
     *
     * @param a
     * @param n
     */
    @TimeComplexity("O(n * Log n)")
    @SpaceComplexity("O(n)")
    @Implementation(type = ImplementationType.Recursive)
    @RecurrenceRelation("T(n) = 2 T(n/2) + O(n)")
    @Stability
    @DivideAndConquer
    @BacktrackingDFS
    public static void mergeSortRecursive(int[] a, int n) {

        // base case
        if (n < 2)
            return;

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = a[i];
        }
        mergeSortRecursive(left, mid);
        mergeSortRecursive(right, n - mid);

        Merge.mergeByTwoFinger(a, left, right, mid, n - mid);
    }

    private static int[] aux;

    /**
     * Divide-and-conquer algorithm and recursive
     * <p>
     * Sorting In Place: Yes
     *
     * @param a
     */
    @TimeComplexity("O(n * Log n)")
    @SpaceComplexity("O(1) improved over normal merge sort O(n)")
    @DivideAndConquer
    public static void inPlaceMergeSort(int[] a) {
        aux = new int[a.length];
        // Allocate space just once.
        inPlaceMergeSort(a, 0, a.length - 1);
    }


    private static void inPlaceMergeSort(int[] a, int lo, int hi) { // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        inPlaceMergeSort(a, lo, mid);
        // Sort left half.
        inPlaceMergeSort(a, mid + 1, hi);
        // Sort right half.
        merge(a, lo, mid, hi); // Merge results (code on page 271).
    }


    /**
     * Bottom-up mergesort
     * Another way to implement mergesort is to organize the merges so that we do
     * all the merges of tiny subarrays on one pass, then do a second pass to merge those sub-
     * arrays in pairs, and so forth, continuing until we
     * do a merge that encompasses the whole array.
     * <p>
     * A version of bottom-up mergesort is the method of choice for sorting data organized in a linked list.
     *
     * @param array
     */
    @DivideAndConquer
    @Implementation(type = ImplementationType.Iterative)
    public static void mergeSortIterative(int[] array) { // Do lg N passes of pairwise merges.
        int n = array.length;
        aux = new int[n];
        for (int subarraySize = 1; subarraySize < n; subarraySize = subarraySize + subarraySize)
            for (int subarrayIndex = 0; subarrayIndex < n - subarraySize; subarrayIndex += subarraySize + subarraySize)
                merge(array, subarrayIndex, subarrayIndex + subarraySize - 1, Math.min(subarrayIndex + subarraySize + subarraySize - 1, n - 1));
    }

    public static void merge(int[] a, int lo, int mid, int hi) { // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
            // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (aux[j] < aux[i])
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
    }


    /**
     * In quick sort we pick a random element and partition the array, such that all numbers that are less than the
     * partitioning element come before all elements that are greater than it. The partitioning can be performed
     * efficiently through a series of swaps
     * <p>
     * Quicksort vs Mergesort
     * Quicksort is complementary to mergesort: for mergesort, we break the array
     * into two subarrays to be sorted and then combine the ordered subarrays to make the
     * whole ordered array; for quicksort, we rearrange the array such that, when the two
     * subarrays are sorted, the whole array is ordered. In the first instance, we do the two
     * recursive calls before working on the whole array; in the second instance, we do the two
     * recursive calls after working on the whole array. For mergesort, the array is divided in
     * half; for quicksort, the position of the partition depends on the contents of the array.
     *
     * @param arr
     * @param left
     * @param right
     */
    @TimeComplexity("O(n * Log n)")
    @SpaceComplexity("O(1)")
    @InPlace
    @Stability(false)
    @DivideAndConquer
    public static void quickSort(int[] arr, int left, int right) {
        if (left <= right) return;
        int index = partition(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }

    /**
     * @return index of pivot
     */
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2]; // Pick pivot point
        while (left <= right) {
            // Find element on left that should be on right
            while (arr[left] < pivot) left++;

            // Find element on right that should be on left
            while (arr[right] > pivot) right--;

            // Swap elements, and move left and right indices
            if (left <= right) {
                Utils.gSwap(arr[left], arr[left] = arr[right]); // swaps elements
                left++;
                right--;
            }
        }
        return left;
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
     * <p>
     * Sorting In Place: Yes
     *
     * @param array
     */
    @TimeComplexity("O(n * Log n)")
    @SpaceComplexity("O(1)")
    @InPlace
    public static void heapSort(int[] array) {

        // Build heap (rearrange array)
        MaxBinaryHeap heap = new MaxBinaryHeap(array);
        heap.buildMaxHeap();

        // One by one extract an element from heap
        for (int i = heap.getSize(); i > 0; i--) {
            // Move current root to end, swap
            array[0] = Utils.gSwap(array[i], array[i] = array[0]);
            heap.setSize(heap.getSize() - 1);
            // call max heapify on the reduced heap
            heap.heapifyDown(0);
        }
    }

    /**
     * Tree sort is a sorting algorithm that is based on Binary Search Tree data structure
     * It first creates a binary search tree from the elements of the input list or array
     * and then performs an in-order traversal on the created binary search tree to get the elements in sorted order.
     * <p>
     * Sorting In Place: No
     *
     * @param array
     */
    @TimeComplexity("O(n * log h) - h is height o tree and if tree is balanced(AVL,Red Black Tree,...), h = Log n")
    @SpaceComplexity("O(n) heapsort is better")
    public static void treeSort(int[] array) {
        // Build BST
        BinarySearchTree bst = new BinarySearchTree();

        // fill it
        for (int value : array) {
            bst.add(value);
        }

        // traverse in-order
        bst.traverseInOrder(bst.getRoot());
    }

    /**
     * It works by counting the number of objects having distinct key values (kind of hashing).
     * Then doing some arithmetic to calculate the position of each object in the output sequence.
     * <p>
     * we could not sort the elements if we have negative numbers in it. Because there are no negative array indices.
     * <p>
     * Time Complexity: O(n + k) + O(n) = O(2n + k) = O(n + k) where n is the number of elements in input array and k is the range of input.
     * Auxiliary Space: O(n+k)
     * <p>
     * Counting sort is efficient if the range of input data is not significantly greater than the number of objects to be sorted. (1-9)(a-b-...-z (256 character))
     * Consider the situation where the input sequence is between range 1 to 10K and the data is 10, 5, 10K, 5K.
     * It is not a comparison based sorting. It running time complexity is O(n) with space proportional to the range of data.
     * It is often used as a sub-routine to another sorting algorithm like radix sort.
     * Counting sort uses a partial hashing to count the occurrence of the data object in O(1).
     * Counting sort can be extended to work for negative inputs also.
     *
     * @param input
     */
    @TimeComplexity("O(n + k) + O(n) = O(2n + k) = O(n + k) where n is the number of elements in input array and k is the range of input.")
    @SpaceComplexity("nO(n + k)")
    public static void countSort(int[] input) {
        int max = Arrays.stream(input).max().getAsInt();

        // create buckets
        int counter[] = new int[max + 1];
        // fill buckets
        for (int i : input) {
            counter[i]++;
        }
        // sort array
        int ndx = 0;
        for (int i = 0; i < counter.length; i++) {
            while (0 < counter[i]) {
                input[ndx++] = i;
                counter[i]--;
            }
        }
    }


    /**
     * Counting sort which takes negative numbers as well
     * We find the minimum element and we will store count of that minimum element at zero index.
     *
     * @param arr
     */
    @TimeComplexity("O(n + k) + O(n) = O(2n + k) = O(n + k) where n is the number of elements in input array and k is the range of input.")
    @SpaceComplexity("nO(n + k)")
    public static void countingSortWithNegative(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        int range = max - min + 1;

        int count[] = new int[range];
        int output[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    /**
     * @param input
     * @param k
     */
    private static void verifyPreconditions(int[] input, int k) {
        if (input == null) {
            throw new IllegalArgumentException("Input is required");
        }

        int min = IntStream.of(input).min().getAsInt();
        int max = IntStream.of(input).max().getAsInt();

        if (min < 0 || max > k) {
            throw new IllegalArgumentException("The input numbers should be between zero and " + k);
        }
    }

    /**
     * Radix sort uses a stable sorting algorithm as a subroutine to sort the digits.
     * We've used a variation of counting sort as a subroutine here that uses the radix to sort the digits in every position.
     * Counting sort is a stable sorting algorithm and it works well in practice.
     * Radix sort works by sorting digits from the Least Significant Digit (LSD) to the Most Significant Digit (MSD).
     * <p>
     * The radix sorting algorithm is an integer sorting algorithm, that sorts by grouping numbers by their individual digits (or by their radix).
     * It uses each radix/digit as a key, and implements counting sort or bucket sort under the hood in order to do the work of sorting.
     *
     * @param numbers
     */
    @TimeComplexity("O(kn) where n is the number of elements in input array and k represented this number of digits of maximum value.")
    @SpaceComplexity("nO(n + k)")
    @Stability
    public static void radixSortLSD(int numbers[]) {
        int maximumNumber = findMaximumNumberIn(numbers);

        int numberOfDigits = calculateNumberOfDigitsIn(maximumNumber);

        int placeValue = 1;

        while (numberOfDigits-- > 0) {
            applyCountingSortOn(numbers, placeValue);
            placeValue *= 10;
        }
    }

    private static void applyCountingSortOn(int[] numbers, int placeValue) {
        int range = 10; // radix or the base

        int length = numbers.length;
        // Using count sort
        int[] frequency = new int[range];
        int[] sortedValues = new int[length];

        for (int i = 0; i < length; i++) {

            int digit = getDigit(numbers[i], placeValue, range);
            frequency[digit]++;
        }

        for (int i = 1; i < range; i++) {
            frequency[i] += frequency[i - 1];
        }

        for (int i = length - 1; i >= 0; i--) {
            int digit = getDigit(numbers[i], placeValue, range);
            sortedValues[frequency[digit] - 1] = numbers[i];
            frequency[digit]--;
        }

        System.arraycopy(sortedValues, 0, numbers, 0, length);
    }

    @Point("how to get a digit in a number by its place")
    private static int getDigit(int number, int placeValue, int range) {
        return (number / placeValue) % range;
    }

    private static int calculateNumberOfDigitsIn(int number) {
        return (int) Math.log10(number) + 1; // valid only if number > 0
    }

    private static int findMaximumNumberIn(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    /**
     * Rearranges the array of extended ASCII strings in ascending order.
     *
     * @param a the array to be sorted
     */
    public static void radixSortMSD(String[] a) {
        int n = a.length;
        String[] aux = new String[n];
        radixSortMSD(a, 0, n - 1, 0, aux);
    }

    // return dth character of s, -1 if d = length of string
    private static int charAt(String s, int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) return -1;
        return s.charAt(d);
    }

    // sort from a[lo] to a[hi], starting at the dth character
    private static void radixSortMSD(String[] a, int lo, int hi, int d, String[] aux) {

        // cutoff to insertion sort for small subarrays
        if (hi <= lo + 15) {
            insertion(a, lo, hi, d);
            return;
        }

        // compute frequency counts
        int[] count = new int[256 + 2];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            count[c + 2]++;
        }

        // transform counts to indicies
        for (int r = 0; r < 256 + 1; r++)
            count[r + 1] += count[r];

        // distribute
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            aux[count[c + 1]++] = a[i];
        }

        // copy back
        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];


        // recursively sort for each character (excludes sentinel -1)
        for (int r = 0; r < 256; r++)
            radixSortMSD(a, lo + count[r], lo + count[r + 1] - 1, d + 1, aux);
    }


    // insertion sort a[lo..hi], starting at dth character
    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--)
                exch(a, j, j - 1);
    }

    // exchange a[i] and a[j]
    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // is v less than w, starting at character d
    private static boolean less(String v, String w, int d) {
        // assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Your input is an array of integers, and you have to reorder its entries so that the even entries appear first.
     *
     * @param array
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @MultiplePointerPattern
    public static void separateEvenOdd(int[] array) {
        int pointer1 = 0, pointer2 = 1;

        while (pointer2 < array.length) {
            if (array[pointer2] % 2 == 0) {
                int tmp = array[pointer1];
                array[pointer1] = array[pointer2];
                array[pointer2] = tmp;
                pointer1++;
            }
            pointer2++;
        }
    }

    /**
     * For this problem, we can partition the array into
     * three subarrays: Even, Unclassified, and Odd, appearing in that order. Initially
     * Even and Odd are empty, and Unclassified is the entire array. We iterate through
     * Unclassified, moving its elements to the boundaries of the Even and Odd subarrays
     * via swaps, thereby expanding Even and Odd, and shrinking Unclassified.
     *
     * @param array
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @MultiplePointerPattern
    public static void separateEvenOdd2(int[] array) {
        int nextEven = 0, nextOdd = array.length - 1;
        while (nextEven < nextOdd) {
            if (array[nextEven] % 2 == 0) {
                nextEven++;
            } else {
                int temp = array[nextEven];
                array[nextEven] = array[nextOdd];
                array[nextOdd--] = temp;
            }
        }
    }

    /**
     * Given an array containing 0s, 1s and 2s, sort the array in-place.
     * You should treat numbers of the array as objects, hence,
     * we can’t count 0s, 1s, and 2s to recreate the array.
     * <p>
     * The flag of the Netherlands consists of three colors:
     * red, white and blue; and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.
     * <p>
     * Input: [1, 0, 2, 1, 0]
     * Output: [0 0 1 1 2]
     * <p>
     * The brute force solution will be to use an in-place sorting algorithm like Heapsort which will take O(N*logN)O(N∗logN). Can we do better than this? Is it possible to sort the array in one iteration?
     * <p>
     * We can use a Two Pointers approach while iterating through the array.
     * Let’s say the two pointers are called low and high which are pointing to the first and the last element of the array respectively.
     * So while iterating, we will move all 0s before low and all 2s after high so that in the end, all 1s will be between low and high.
     *
     * @see #quickSort(int[], int, int)
     * @see #separateEvenOdd2(int[])
     *
     * Keep the following invariants during partitioning:
     * unclassified group: A .subList (0 , array.size()).
     * bottom group: A .subList (0 , low) .
     * middle group: A .subList (low , high).
     * top group: A .subList (high , array.size()) .
     * @param array
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @MultiplePointerPattern
    @Difficulty(type = DifficultyType.MEDIUM)
    @InPlace
    public static void sortJustThreeTypeNumber(int[] array) {
        // all elements  < low are 0 and all elements > high are 2
        // all elements from >= low < i are 1
        int low = 0, high = array.length - 1;
        for (int i = 0; i <= high; ) {
            if (array[i] == 0) {
                Utils.swapInArray(array, i, low);
                // increment 'i' and 'low'
                i++;
                low++;
            } else if (array[i] == 1) {
                i++;
            } else { // the case for array[i] == 2
                Utils.swapInArray(array, i, high);
                // decrement 'high' only, after the swap the number at index 'i' could be 0, 1 or 2
                high--;
            }
        }
    }

    /**
     * Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
     * <p>
     * Input: [1, 2, 5, 3, 7, 10, 9, 12]
     * Output: 5
     * Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
     * <p>
     * As we know, once an array is sorted (in ascending order), the smallest number is at the beginning and the largest number is at the end of the array. So if we start from the beginning of the array to find the first element which is out of sorting order i.e.,
     * which is smaller than its previous element,
     * and similarly from the end of array to find the first element which is bigger than its previous element, will sorting the subarray between these two numbers result in the whole array being sorted?
     * <p>
     * Let’s try to understand this with Example-2 mentioned above. In the following array, what are the first numbers out of sorting order from the beginning and the end of the array:
     * <p>
     * [1, 3, 2, 0, -1, 7, 10]
     * Starting from the beginning of the array the first number out of the sorting order is ‘2’ as it is smaller than its previous element which is ‘3’.
     * Starting from the end of the array the first number out of the sorting order is ‘0’ as it is bigger than its previous element which is ‘-1’
     * As you can see, sorting the numbers between ‘3’ and ‘-1’ will not sort the whole array. To see this, the following will be our original array after the sorted subarray:
     * <p>
     * [1, -1, 0, 2, 3, 7, 10]
     * The problem here is that the smallest number of our subarray is ‘-1’ which dictates that we need to include more numbers from the beginning of the array to make the whole array sorted. We will have a similar problem if the maximum of the subarray is bigger than some elements at the end of the array.
     * To sort the whole array we need to include all such elements that are smaller than the biggest element of the subarray. So our final algorithm will look like:
     * <p>
     * From the beginning and end of the array, find the first elements that are out of the sorting order. The two elements will be our candidate subarray.
     * Find the maximum and minimum of this subarray.
     * Extend the subarray from beginning to include any number which is bigger than the minimum of the subarray.
     * Similarly, extend the subarray from the end to include any number which is smaller than the maximum of the subarray.
     *
     * @param array
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @MultiplePointerPattern
    @Difficulty(type = DifficultyType.MEDIUM)
    public static int minimumWindowSort(int[] array) {
        int low = 0, high = array.length - 1;
        // find the first number out of sorting order from the beginning
        while (low < array.length - 1 && array[low] <= array[low + 1])
            low++;

        if (low == array.length - 1) // if array is sorted
            return 0;

        // find the first number out of sorting order from the end
        while (high > 0 && array[high] >= array[high - 1])
            high--;

        // find the maximum and minimum of the subarray
        int subarrayMax = Integer.MIN_VALUE, subarrayMin = Integer.MAX_VALUE;
        for (int k = low; k < high; k++) {
            subarrayMax = Math.max(subarrayMax, array[k]);
            subarrayMin = Math.min(subarrayMin, array[k]);
        }

        // extend the subarray to include any number which is bigger than the minimum of the subarray
        while (low > 0 && array[low - 1] > subarrayMin)
            low--;

        // extend the subarray to include any number which is smaller than the maximum of the subarray
        while (high < array.length - 1 && array[high + 1] < subarrayMax)
            high++;

        return high - low + 1;
    }

    /**
     * Cycle sort is a comparison sorting algorithm which forces array to be factored into the number of cycles where each of them can be rotated to produce a sorted array.
     * It is theoretically optimal in the sense that it reduces the number of writes to the original array.
     *
     * @param numbers
     */
    @InPlace
    @TimeComplexity("O(n)+O(n-1) = O(n)")
    @SpaceComplexity("O(1)")
    @Stability(false)
    @Difficulty(type = DifficultyType.EASY)
    @CyclicSortPattern
    public static void cyclicSort(int[] numbers) {
        int i = 0;
        while (i < numbers.length) {
            int j = numbers[i] - 1;
            if (numbers[i] != numbers[j])
                Utils.swapInArray(numbers, i, j);
            else
                i++;
        }
    }
}
