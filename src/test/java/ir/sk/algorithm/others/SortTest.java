package ir.sk.algorithm.others;

import ir.sk.algorithm.array.ArrayAlgorithms;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class SortTest {

    private int[] actual;
    private int[] expected;

    @Before
    public void setUp() throws Exception {
        actual = new int[]{1, 5, 2, 4, 9, 7};
        expected = new int[]{1, 2, 4, 5, 7, 9};
        //   actual = new Random().ints(10000, 0, 100000).toArray();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void bubbleSort() throws Exception {
        long start = System.currentTimeMillis();
        Sort.bubbleSort(actual);
        long end = System.currentTimeMillis();
        System.out.println("Logic bubbleSort took " + (end - start) + " MilliSeconds");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void selectionSort() throws Exception {
        long start = System.currentTimeMillis();
        Sort.selectionSort(actual);
        long end = System.currentTimeMillis();
        System.out.println("Logic selectionSort took " + (end - start) + " MilliSeconds");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void insertionSort() throws Exception {
        long start = System.currentTimeMillis();
        Sort.insertionSort(actual);
        long end = System.currentTimeMillis();
        System.out.println("Logic insertionSort took " + (end - start) + " MilliSeconds");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void modularInsertionSortTest() {
        long start = System.currentTimeMillis();
        Sort.modularInsertionSort(actual);
        long end = System.currentTimeMillis();
        System.out.println("Logic ModularInsertionSort took" + (end - start) + "MilliSeconds");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void binaryInsertionSort() {
        long start = System.currentTimeMillis();
        Sort.binaryInsertionSort(actual);
        long end = System.currentTimeMillis();
        System.out.println("Logic binaryInsertionSort took " + (end - start) + " MilliSeconds");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shellSort() {
        long start = System.currentTimeMillis();
        Sort.shellSort(actual);
        long end = System.currentTimeMillis();
        System.out.println("Logic shellSort took " + (end - start) + " MilliSeconds");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void mergeSort() {
        long start = System.currentTimeMillis();
        Sort.mergeSortRecursive(actual, actual.length);
        long end = System.currentTimeMillis();
        System.out.println("Logic mergeSort took " + (end - start) + " MilliSeconds");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void inPlaceMergeSort() {
        long start = System.currentTimeMillis();
        Sort.inPlaceMergeSort(actual);
        long end = System.currentTimeMillis();
        System.out.println("Logic inPlaceMergeSort took " + (end - start) + " MilliSeconds");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void mergeSortIterative() {
        long start = System.currentTimeMillis();
        Sort.mergeSortIterative(actual);
        long end = System.currentTimeMillis();
        System.out.println("Logic mergeSortIterative took " + (end - start) + " MilliSeconds");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void modularMergeSortTest() {
        long start = System.currentTimeMillis();
        actual = Sort.modularMergeSort(actual);
        long end = System.currentTimeMillis();
        System.out.println("Logic modularMergeSort took: " + (end - start) + "milliseconds");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void heapSort() {
        long start = System.currentTimeMillis();
        Sort.heapSort(actual);
        long end = System.currentTimeMillis();
        System.out.println("Logic heapSort took " + (end - start) + " MilliSeconds");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void treeSort() {
        long start = System.currentTimeMillis();
        Sort.treeSort(actual);
        long end = System.currentTimeMillis();
        System.out.println("Logic treeSort took " + (end - start) + " MilliSeconds");
    }

    @Test
    public void countingSort() {
        long start = System.currentTimeMillis();
        Sort.basicCountSort(actual);
        long end = System.currentTimeMillis();
        System.out.println("Logic countingSort took " + (end - start) + " MilliSeconds");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void countingSortWithNegative() {
        int[] arr = new int[]{-3, 2, 1, 5, 5, 6};
        int[] expected = new int[]{-3, 1, 2, 5, 5, 6};
        long start = System.currentTimeMillis();
        Sort.countingSortWithNegative(arr);
        long end = System.currentTimeMillis();
        System.out.println("Logic countingSortWithNegative took " + (end - start) + " MilliSeconds");
        assertArrayEquals(expected, arr);
    }

    @Test
    public void basicCountingSort() {
        int[] arr = new int[]{9, 2, 1, 5, 5, 6, -2};
        int[] expected = new int[]{-2, 1, 2, 5, 5, 6, 9};
        long start = System.currentTimeMillis();
        Sort.basicCountingSortWithNegative(arr);
        long end = System.currentTimeMillis();
        System.out.println("Logic countingSortWithNegative took " + (end - start) + " MilliSeconds");
        assertArrayEquals(expected, arr);
    }

    @Test
    public void quickSort() {
        long start = System.currentTimeMillis();
        Sort.quickSort(actual, 0, actual.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("Logic quickSort took " + (end - start) + " MilliSeconds");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void separateEvenOdd() {
        int arr[] = {9, 11, 8, 5, 7, 10};

        Sort.separateEvenOdd(arr);
        System.out.println(arr);
    }

    @Test
    public void separateEvenOdd2() {
        int arr[] = {9, 11, 8, 5, 7, 10};

        Sort.separateEvenOdd2(arr);
        System.out.println(arr);
    }

    @Test
    public void sortJustThreeTypeNumber() {
        int[] array = new int[]{1, 0, 2, 1, 0};
        Sort.sortJustThreeTypeNumber(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void minimumWindowSort() {
        System.out.println(Sort.minimumWindowSort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
    }

    @Test
    public void cyclicSort() {
        int[] array = new int[]{3, 1, 5, 4, 2};
        Sort.cyclicSort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void radixSort() {
        int[] array = new int[]{170, 45, 75, 90, 2, 802, 2, 66};
        Sort.radixSortLSD(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void radixSortMSD() {
        String[] array = new String[]{"asd", "aafefe", "hyh", "f", "grgrg", "wwqq", "nbm", "fghhhgfhgf"};
        Sort.radixSortMSD(array);
        System.out.println(Arrays.toString(array));
    }   
    
    @Test
    public void bucketSort() {
        float[] array = new float[]{0.23f, 0.34f, 0.54f, 0.12f, 0.33f};
        Sort.bucketSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}