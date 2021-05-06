package ir.sk.adt.dictionary;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RedBlackBSTDictionaryTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void put() {
        RedBlackBSTDictionary<String, Integer> st = new RedBlackBSTDictionary<String, Integer>();
        for (int i = 0; i < 10; i++) {
            st.put(i + "", i);
        }
        System.out.println();
        for (String s : st.keys())
            System.out.println(s + " " + st.get(s));
        System.out.println();
    }
}