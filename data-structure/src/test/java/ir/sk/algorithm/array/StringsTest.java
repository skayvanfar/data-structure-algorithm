package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 10/31/2020.
 */
public class StringsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void minWindow() {
        Assert.assertEquals("BANC", Strings.minWindow("ADOBECODEBANC", "ABC"));
    }
}