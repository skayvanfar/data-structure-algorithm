package ir.sk.algorithm.others;

import ir.sk.algorithm.mathematic.CatalanNumber;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="sad.keyvanfar@gmail.com">Saeed Kayvanfar</a> on 7/10/2020.
 */
public class CatalanNumberTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void catalanByRecursive() {
        int number = 5;
        long expectedValue = 42;
        long startTime = System.nanoTime();
        long result = CatalanNumber.catalanByRecursive(number);
        long endTime = System.nanoTime();
        System.out.println("time duration for catalanByRecursive by n= " + number + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void catalanDynamic() {
        int number = 5;
        long expectedValue = 42;
        long startTime = System.nanoTime();
        long result = CatalanNumber.catalanDynamic(number);
        long endTime = System.nanoTime();
        System.out.println("time duration for catalanDynamic by n= " + number + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);
    }
}