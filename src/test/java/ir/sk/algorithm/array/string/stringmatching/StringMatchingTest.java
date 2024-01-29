package ir.sk.algorithm.array.string.stringmatching;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="sad.keyvanfar@gmail.com">Saeid Keyvanfar</a> on 7/6/2020.
 */
public class StringMatchingTest {

    private String text;
    private String pattern;

    @Before
    public void setUp() throws Exception {
        text = "String Search and Pattern Matching is one of the import part of computer science." +
                " There are various String Searching and Pattern Matching Algorithm are available in the internet. “Naive String Search Pattern Matching Algorithm\" " +
                "one of them and its easy to write and test.";
        pattern = "write";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void naiveStringSearch() {
        int expectedValue = 5;
        int actual = StringMatching.naiveStringSearch(text, pattern);
        Assert.assertEquals(expectedValue, actual);
    }

    @Test
    public void rabinKarp() {
        boolean expectedValue = true;
        boolean actual = StringMatching.rabinKarp(text, pattern, 101);
        Assert.assertEquals(expectedValue, actual);
    }
}