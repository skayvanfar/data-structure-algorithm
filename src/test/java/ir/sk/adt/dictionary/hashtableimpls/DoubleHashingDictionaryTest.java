package ir.sk.adt.dictionary.hashtableimpls;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.keyvanfar on 7/8/2020.
 */
public class DoubleHashingDictionaryTest {

    private DoubleHashingDictionary<String, Integer> dictionary;

    @Before
    public void setUp() throws Exception {
        dictionary = new DoubleHashingDictionary<>(10, 0.5f);
        dictionary.put("a", 1);
        dictionary.put("b", 2);
        dictionary.put("c", 3);
        dictionary.put("d", 4);
        dictionary.put("e", 5);
        dictionary.put("f", 6);
        dictionary.put("g", 7);
        dictionary.put("h", 8);
        dictionary.put("l", 9);
        dictionary.put("m", 10);
        dictionary.put("c", 30);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        dictionary.put("That", 6);
    }

    @Test
    public void get() {
        int expectedValue = 7;
        long startTime = System.nanoTime();
        int resultIndex = dictionary.get("g");
        long endTime = System.nanoTime();
        System.out.println("time duration for LinearProbingDictionaryTest.get() with n: " + dictionary.size() + " length = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, resultIndex);
    }

    @Test
    public void remove() {
       // dictionary.remove("g");
    }
}