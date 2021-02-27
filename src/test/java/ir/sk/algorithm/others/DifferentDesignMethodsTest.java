package ir.sk.algorithm.others;

import ir.sk.algorithm.others.DifferentDesignMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/5/2020.
 */
public class DifferentDesignMethodsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void firstRepeatedCharByTwoLoops() {
        char[] array = new char[]{'a', 'b', 'l', 'b', 'x'};
        char expectedValue = 'b';
        long startTime = System.nanoTime();
        char result = DifferentDesignMethods.firstRepeatedCharByTwoLoops(array);
        long endTime = System.nanoTime();
        System.out.println("time duration for firstRepeatedCharByTwoLoops by n= " + array.length + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void firstRepeatedCharByHash() {
        char[] array = new char[]{'a', 'b', 'l', 'b', 'x'};
        char expectedValue = 'b';
        long startTime = System.nanoTime();
        char result = DifferentDesignMethods.firstRepeatedCharByHash(array);
        long endTime = System.nanoTime();
        System.out.println("time duration for firstRepeatedCharByHash by n= " + array.length + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void firstMaximumRepeatedCharByTwoLoops() {
        char[] array = new char[]{'a', 'b', 'l', 'b', 'x'};
        char expectedValue = 'b';
        long startTime = System.nanoTime();
        char result = DifferentDesignMethods.maximumRepeatedCharByTwoLoops(array);
        long endTime = System.nanoTime();
        System.out.println("time duration for maximumRepeatedCharByTwoLoops by n= " + array.length + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void maximumRepeatedCharByHash() {
        char[] array = new char[]{'a', 'b', 'l', 'b', 'x'};
        char expectedValue = 'b';
        long startTime = System.nanoTime();
        char result = DifferentDesignMethods.maximumRepeatedCharByHash(array);
        long endTime = System.nanoTime();
        System.out.println("time duration for maximumRepeatedCharByHash by n= " + array.length + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);
    }
}