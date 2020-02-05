package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/6/2020.
 */
public class TriangleNumbersTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void triangleByLoop() {
        int number = 1000;
        int expectedValue = 500500;
        Assert.assertEquals(expectedValue, TriangleNumbers.triangleByLoop(number));

    }

    @Test
    public void triangleByRecursive() {
        int number = 1000;
        int expectedValue = 500500;
        Assert.assertEquals(expectedValue, TriangleNumbers.triangleByRecursive(number));
    }
}