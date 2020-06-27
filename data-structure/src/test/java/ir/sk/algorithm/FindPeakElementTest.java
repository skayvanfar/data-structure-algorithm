package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.keyvanfar on 6/27/2020.
 */
public class FindPeakElementTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void findPeakByLoop() {
        int[] array = new int[] {1,5,2,4,9,7};
        boolean expectedValue = true;
        long startTime = System.nanoTime();
        boolean result = FindPeakElement.findPeakByLoop(array, 0, array.length);
        long endTime = System.nanoTime();
        System.out.println("time duration for findPeakByLoop by array size: "+array.length + " = "+(endTime-startTime)+ " nano");
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void findPeakByRecursive() {
        int[] array = new int[] {1,5,2,4,9,7};
        boolean expectedValue = true;
        long startTime = System.nanoTime();
        boolean result = FindPeakElement.findPeakByRecursive(array, 0, array.length);
        long endTime = System.nanoTime();
        System.out.println("time duration for fibonacciByArray by array size: "+array.length + " = "+(endTime-startTime)+ " nano");
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void findPeakIn2DArrayByLoop() {
        int[][] array = new int[][] {{1,5,6},{2,4,1},{9,7,9}};
        boolean expectedValue = true;
        long startTime = System.nanoTime();
        boolean result = FindPeakElement.findPeakIn2DArrayByLoop(array, 0, array.length);
        long endTime = System.nanoTime();
        System.out.println("time duration for findPeakIn2DArrayByLoop by array size: "+array.length + " = "+(endTime-startTime)+ " nano");
        Assert.assertEquals(expectedValue, result);
    }
}