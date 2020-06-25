package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.keyvanfar on 6/25/2020.
 */
public class FibonacciTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void fibonacciByRecursive() {
        long number = 45;
        long expectedValue = 1134903170;
        long startTime = System.nanoTime();
        long result = Fibonacci.fibonacciByRecursive(number);
        long endTime = System.nanoTime();
        System.out.println("time duration for fibonacciByRecursive by n= "+number + " = "+(endTime-startTime)+ " nano");
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void fibonacciByArray() {
        int number = 45;
        int expectedValue = 1134903170;
        long startTime = System.nanoTime();
        int result = Fibonacci.fibonacciByArray(number);
        long endTime = System.nanoTime();
        System.out.println("time duration for fibonacciByArray by n= "+number + " = "+(endTime-startTime)+ " nano");
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void fibonacciThird() {
        int number = 45;
        int expectedValue = 1134903170;
        long startTime = System.nanoTime();
        int result = Fibonacci.fibonacciThird(number);
        long endTime = System.nanoTime();
        System.out.println("time duration for fibonacciThird by n= "+number + " = "+(endTime-startTime)+ " nano");
        Assert.assertEquals(expectedValue, result);
    }
}