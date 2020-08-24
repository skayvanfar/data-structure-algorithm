package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 8/24/2020.
 */
public class NumeralSystemTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void convertFromBase() {
        NumeralSystem.convertFromBase(124, 2);
    }

    @Test
    public void convertToBase() {
        int number = 1111100;
        int expectedValue = 124;
        Assert.assertEquals(expectedValue, NumeralSystem.convertToBase(number, 2));
    }
}