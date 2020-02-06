package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/6/2020.
 */
public class CombinationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void combinationByRecursive() {
        int expectedValue = 6;
        Assert.assertEquals(expectedValue, Combination.combinationByRecursive(4, 2));
    }
}