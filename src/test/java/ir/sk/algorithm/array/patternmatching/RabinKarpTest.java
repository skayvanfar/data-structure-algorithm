package ir.sk.algorithm.array.patternmatching;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RabinKarpTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void search() {
        String pat = "ABCDABD";
        String txt = "ABC ABCDAB ABCDABCDABDE";

        RabinKarp searcher = new RabinKarp(pat);
        int offset = searcher.search(txt);

        // print results
        System.out.println("text:    " + txt);

        // from brute force search method 1
        System.out.print("pattern: ");
        for (int i = 0; i < offset; i++)
            System.out.print(" ");
        System.out.println(pat);
    }
}