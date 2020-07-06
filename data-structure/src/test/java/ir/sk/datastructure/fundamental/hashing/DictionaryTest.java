package ir.sk.datastructure.fundamental.hashing;

import ir.sk.algorithm.Search;
import ir.sk.algorithm.Sort;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.keyvanfar on 7/6/2020.
 */
public class DictionaryTest {

    private Dictionary<String, Integer> dictionary;

    @Before
    public void setUp() throws Exception {
        dictionary = new Dictionary<>();
        dictionary.add("this",1 );
        dictionary.add("coder",2 );
        dictionary.add("this",4 );
        dictionary.add("hi",5 );
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void get() {
        int expectedValue = 2;
        long startTime = System.nanoTime();
        int resultIndex = dictionary.get("coder");
        long endTime = System.nanoTime();
        System.out.println("time duration for DictionaryTest.get() with n: " + dictionary.size() + " length = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, resultIndex);
    }

    @Test
    public void add() {
        dictionary.add("That", 6);
    }

    @Test
    public void remove() {
        dictionary.remove("coder");
    }

}