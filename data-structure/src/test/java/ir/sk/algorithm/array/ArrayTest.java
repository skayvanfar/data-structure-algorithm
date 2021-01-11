package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 1/10/2021.
 */
public class ArrayTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findWord() {
        boolean result = Array.findWord(new char[][] {  {'F', 'A', 'C', 'I'},
                                        {'O', 'B', 'Q', 'P'},
                                        {'A', 'N', 'O', 'B'},
                                        {'M', 'A', 'S', 'S'}}, "FOAM".toCharArray());
        System.out.println(result);
    }
}