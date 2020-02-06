package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/6/2020.
 */
public class PowerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void powerByRecursive() {
        int expectedValue = 81;
        Assert.assertEquals(expectedValue, Power.powerByRecursive(3, 4));
    }
}