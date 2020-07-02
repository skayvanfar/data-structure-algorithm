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

    private int[] array;

    @Before
    public void setUp() throws Exception {
           array = new int[] {1,5,2,4,9,7};
     //   array = new Random().ints(10000, 0, 100000).toArray();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void bubbleSort() throws Exception {
        long start = System.currentTimeMillis();
        Sort.bubbleSort(array);
        long end = System.currentTimeMillis();
        System.out.println("Logic bubbleSort took " + (end - start) + " MilliSeconds");
        System.out.println(Arrays.toString(array));

    }

    @Test
    public void selectionSort() throws Exception {
        long start = System.currentTimeMillis();
        Sort.selectionSort(array);
        long end = System.currentTimeMillis();
        System.out.println("Logic selectionSort took " + (end - start) + " MilliSeconds");
        System.out.println(Arrays.toString(array));
    }


    @Test
    public void insertionSort() throws Exception {
        long start = System.currentTimeMillis();
        Sort.insertionSort(array);
        long end = System.currentTimeMillis();
        System.out.println("Logic insertionSort took " + (end - start) + " MilliSeconds");
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void binaryInsertionSort() {
        long start = System.currentTimeMillis();
        Sort.binaryInsertionSort(array);
        long end = System.currentTimeMillis();
        System.out.println("Logic binaryInsertionSort took " + (end - start) + " MilliSeconds");
        System.out.println(Arrays.toString(array));
    }

}