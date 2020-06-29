package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.keyvanfar on 6/27/2020.
 */
public class FindPeakElementTest {

    private int[] array;
    private int[][] array2D;

    @Before
    public void setUp() throws Exception {
        array = new int[]{1, 5, 2, 4, 9, 7};
        array2D = new int[][]{{1, 5, 6},
                {2, 4, 1},
                {6, 4, 6}};
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void findPeakByLoop() {
        boolean expectedValue = true;
        long startTime = System.nanoTime();
        boolean result = FindPeakElement.findPeakByLoop(array, 0, array.length);
        long endTime = System.nanoTime();
        System.out.println("time duration for findPeakByLoop by array size: " + array.length + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void findPeakByRecursive() {
        boolean expectedValue = true;
        long startTime = System.nanoTime();
        boolean result = FindPeakElement.findPeakByRecursive(array, 0, array.length);
        long endTime = System.nanoTime();
        System.out.println("time duration for fibonacciByArray by array size: " + array.length + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void findPeakIn2DArrayByLoop() {
        boolean expectedValue = true;
        long startTime = System.nanoTime();
        boolean result = FindPeakElement.findPeakIn2DArrayByLoop(array2D, 0, array.length);
        long endTime = System.nanoTime();
        System.out.println("time duration for findPeakIn2DArrayByLoop by array size: " + array2D.length + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void greedyAscentAlgorithmByRecursive() {
        int expectedValue = 6;
        long startTime = System.nanoTime();
        int result = FindPeakElement.greedyAscentAlgorithmByRecursive(array2D, 0, 0);
        long endTime = System.nanoTime();
        System.out.println("time duration for greedyAscentAlgorithmByRecursive by array size: " + array2D.length + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);

    }

    @Test
    public void decreaseAndConquerByRecursive() {
        int expectedValue = 6;
        long startTime = System.nanoTime();
        int result = FindPeakElement.decreaseAndConquerByRecursive(array2D, 0, array2D[0].length - 1);
        long endTime = System.nanoTime();
        System.out.println("time duration for decreaseAndConquerByRecursive by array size: " + array2D.length + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);
    }
}