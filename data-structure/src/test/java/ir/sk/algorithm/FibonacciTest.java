package ir.sk.algorithm;

import ir.sk.algorithm.mathematic.Fibonacci;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void naiveFibonacciByRecursive() {
        long number = 45;
        long expectedValue = 1134903170;
        long startTime = System.nanoTime();
        long result = Fibonacci.naiveFibonacciByRecursive(number);
        long endTime = System.nanoTime();
        System.out.println("time duration for naiveFibonacciByRecursive by n= " + number + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);
    }


    @Test
    public void memoizedDPFibonacciByRecursive() {
        int number = 45;
        int expectedValue = 1134903170;
        long startTime = System.nanoTime();
        long result = Fibonacci.memoizedDPFibonacciByRecursive(number);
        long endTime = System.nanoTime();
        System.out.println("time duration for memoizedDPFibonacciByRecursive by n= " + number + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void fibonacciByArray() {
        int number = 45;
        int expectedValue = 1134903170;
        long startTime = System.nanoTime();
        int result = Fibonacci.memoizedDPFibonacciByIterative(number);
        long endTime = System.nanoTime();
        System.out.println("time duration for fibonacciByArray by n= " + number + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void fibonacciThird() {
        int number = 45;
        int expectedValue = 1134903170;
        long startTime = System.nanoTime();
        int result = Fibonacci.bottomUpDPFibonacci(number);
        long endTime = System.nanoTime();
        System.out.println("time duration for fibonacciThird by n= " + number + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void allFibonacci() {
        Fibonacci.allFibonacci(20);
    }

    @Test
    public void allFibonacciMemoized() {
        Fibonacci.allFibonacciMemoized(20);
    }
}