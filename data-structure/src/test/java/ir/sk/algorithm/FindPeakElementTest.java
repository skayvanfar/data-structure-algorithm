package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
    public void findPeak() {
        int[] array = new int[] {1,5,2,4,9,7};
        int expectedValue = 5;
        long startTime = System.nanoTime();
        int result = FindPeakElement.findPeak(array, 0, array.length);
        long endTime = System.nanoTime();
        System.out.println("time duration for fibonacciByArray by array size: "+array.length + " = "+(endTime-startTime)+ " nano");
        Assert.assertEquals(expectedValue, result);
    }
}