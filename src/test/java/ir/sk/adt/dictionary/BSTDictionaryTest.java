package ir.sk.adt.dictionary;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 5/5/2021.
 */
public class BSTDictionaryTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void put() {
        BSTDictionary<String, Integer> st = new BSTDictionary<String, Integer>();
        for (int i = 0; i<10; i++) {
            String key = "" + i;
            st.put(key, i);
        }

        for (String s : st.levelOrder())
            System.out.println(s + " " + st.get(s));

        System.out.println();

        for (String s : st.keys())
            System.out.println(s + " " + st.get(s));
    }
}