package ir.sk.adt.dictionary;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TSTDictionaryTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void put() {
        // build symbol table from standard input
        TSTDictionary<Integer> st = new TSTDictionary<>();
        st.put("ali", 0);
        st.put("vali", 1);
        st.put("Hali", 2);
        st.put("dali", 3);

        // print results
        if (st.size() < 100) {
            System.out.println("keys(\"\"):");
            for (String key : st.keys()) {
                System.out.println(key + " " + st.get(key));
            }
            System.out.println();
        }

        System.out.println("longestPrefixOf(\"shellsort\"):");
        System.out.println(st.longestPrefixOf("shellsort"));
        System.out.println();

        System.out.println("longestPrefixOf(\"shell\"):");
        System.out.println(st.longestPrefixOf("shell"));
        System.out.println();

        System.out.println("keysWithPrefix(\"shor\"):");
        for (String s : st.keysWithPrefix("shor"))
            System.out.println(s);
        System.out.println();

        System.out.println("keysThatMatch(\".he.l.\"):");
        for (String s : st.keysThatMatch(".he.l."))
            System.out.println(s);
    }
}