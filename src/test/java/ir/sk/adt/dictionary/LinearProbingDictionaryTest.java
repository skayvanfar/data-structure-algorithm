package ir.sk.adt.dictionary;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/7/2020.
 */
public class LinearProbingDictionaryTest {

    private LinearProbingDictionary<String, Integer> dictionary;

    @Before
    public void setUp() throws Exception {
        dictionary = new LinearProbingDictionary<>(10, 0.5f);
        dictionary.add("a", 1);
        dictionary.add("b", 2);
        dictionary.add("c", 3);
        dictionary.add("d", 4);
        dictionary.add("e", 5);
        dictionary.add("f", 6);
        dictionary.add("g", 7);
        dictionary.add("h", 8);
        dictionary.add("l", 9);
        dictionary.add("m", 10);
        dictionary.add("c", 30);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        dictionary.add("That", 6);
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
        dictionary.remove("g");
    }
}