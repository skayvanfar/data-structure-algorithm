package ir.sk.algorithm.mathematic;

import ir.sk.algorithm.mathematic.Factorial;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by sad.keyvanfar on 8/22/2020.
 */
public class FactorialTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void factorialByRecursive() {
        int number = 6;
        int expectedValue = 720;
        Assert.assertEquals(expectedValue, Factorial.factorialByRecursive(number));
    }

    @Test
    public void factorialByLoop() {
        int number = 6;
        int expectedValue = 720;
        Assert.assertEquals(expectedValue, Factorial.factorialByLoop(number));
    }

    @Test
    public void factorialByBigInteger() {
        int number = 100;
        BigInteger expectedValue = new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000");
        Assert.assertEquals(expectedValue, Factorial.factorialByBigInteger(number));
    }

    @Test
    public void factorialLargeNumber() {
        int number = 100;
        String expectedValue = "93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000";
        Assert.assertEquals(expectedValue, Factorial.factorialLargeNumber(number));

    }
}