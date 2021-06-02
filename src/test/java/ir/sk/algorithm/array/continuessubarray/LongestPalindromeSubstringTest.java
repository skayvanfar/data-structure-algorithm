package ir.sk.algorithm.array.continuessubarray;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 6/2/2021.
 */
public class LongestPalindromeSubstringTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void longestPalindromeSubstring() {
        System.out.println(LongestPalindromeSubstring.longestPalindromeSubstring("banana".toCharArray()));
    }
}