package ir.sk.algorithm.array.continuessubarray;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 5/30/2021.
 */
public class LongestSubstringDistinctTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void longestSubstringDistinct() {
        Assert.assertEquals(4, LongestSubstringDistinct.longestSubstringDistinct("araaci".toCharArray(), 2));
    }

    @Test
    public void longestSubstringAtMostDistinct() {
        Assert.assertEquals(4, LongestSubstringDistinct.longestSubstringAtMostDistinct("araaci".toCharArray(), 2));
    }

    @Test
    public void longestSubstringAllDistinct() {
        Assert.assertEquals(3, LongestSubstringDistinct.longestSubstringAllDistinct("aabccde".toCharArray()));
    }

    @Test
    public void longestSubstringAllDistinct2() {
        Assert.assertEquals(3, LongestSubstringDistinct.longestSubstringAllDistinct2("aabccde".toCharArray()));
    }

    @Test
    public void longestSubstringAllDistinct3() {
        Assert.assertEquals(3, LongestSubstringDistinct.longestSubstringAllDistinct3("aabccde".toCharArray()));
    }

    @Test
    public void minimumWindowSubstring() {
        Assert.assertEquals("banc", ContinuesSubArray.minimumWindowSubstring("ebbancf".toCharArray(), "abc".toCharArray()));
    }

    @Test
    public void longestSubstringDistinctNaive() {
        Assert.assertEquals(3, LongestSubstringDistinct.longestSubstringDistinctNaive("aabccde"));
    }
}