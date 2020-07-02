package ir.sk.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class SortTest {

    private int[] actual;
    private int[] expected;

    @Before
    public void setUp() throws Exception {
        actual = new int[] {1, 5, 2, 4, 9, 7};
        expected = new int[] {1, 2, 4, 5, 7, 9};
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
    public void binaryInsertionSort() {
        long start = System.currentTimeMillis();
        Sort.binaryInsertionSort(actual);
        long end = System.currentTimeMillis();
        System.out.println("Logic binaryInsertionSort took " + (end - start) + " MilliSeconds");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void mergeSort() {
        long start = System.currentTimeMillis();
        Sort.mergeSort(actual, actual.length);
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
    public void heapSort() {
        long start = System.currentTimeMillis();
        Sort.heapSort(actual);
        long end = System.currentTimeMillis();
        System.out.println("Logic heapSort took " + (end - start) + " MilliSeconds");
        assertArrayEquals(expected, actual);
    }
}