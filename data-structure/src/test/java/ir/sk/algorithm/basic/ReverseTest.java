package ir.sk.algorithm.basic;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sad.kayvanfar on 9/16/2020.
 */
public class ReverseTest {

    private int[] array;

    @Before
    public void setUp() throws Exception {
        array = new int[]{1, 2, 3, 4, 5, 6};
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void reverse() {
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        int[] result = Reverse.reverse(array);
        long end = System.currentTimeMillis();
        System.out.println("reverse took " + (end - start) + " MilliSeconds");
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void inPlaceReverse() {
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        Reverse.inPlaceReverse(array);
        long end = System.currentTimeMillis();
        System.out.println("inPlaceReverse took " + (end - start) + " MilliSeconds");
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void recursiveReverse() {
        long start = System.currentTimeMillis();
        String result = Reverse.recursiveReverse("test");
        long end = System.currentTimeMillis();
        System.out.println("recursiveReverse took " + (end - start) + " MilliSeconds");
        Assert.assertEquals("tset", result);
    }


    @Test
    public void reverseByStack() {
        long start = System.currentTimeMillis();
        Reverse.reverseByStack(array);
        long end = System.currentTimeMillis();
        System.out.println("recursiveReverse took " + (end - start) + " MilliSeconds");
        System.out.println(Arrays.toString(array));
    }
}