package ir.sk.algorithm.array;

import ir.sk.algorithm.math.Factorial;
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
    public void insert() {
        Strings.Trie trie = new Strings.Trie();

        trie.insert("abc");
        trie.insert("abd");
        System.out.println();
    }

    @Test
    public void longestCommonPrefixByTrie() {
        String[] arrays = new String[]{"abce", "abcd", "cab", "car", "asddssaaeeert", "asddssaarr"};
        System.out.println(Strings.longestCommonPrefixByTrie(arrays));
    }
}