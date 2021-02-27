package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void countContinuosOccurenceEachChar() {
        String text = "ccccOddEEE";
        String expectedValue = "c4O1d2E3";
        Assert.assertEquals(expectedValue, Strings.countContinuosOccurenceEachChar(text.toCharArray()));
    }

    @Test
    public void longestCommonSubStringNaive() {
        System.out.println(Strings.longestCommonSubStringNaive("babcdddfr", "aabscdfrggsb"));
    }

    @Test
    public void compareStringsContainingBackspaces() {
        Assert.assertEquals(true, Strings.compareStringsContainingBackspaces("xy#z", "xzz#"));
    }

    @Test
    public void areRotation() {
        Assert.assertEquals(true, Strings.areRotation("abcd", "cdab"));
    }
}