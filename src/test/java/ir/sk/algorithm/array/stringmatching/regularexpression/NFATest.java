package ir.sk.algorithm.array.stringmatching.regularexpression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 5/24/2021.
 */
public class NFATest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void recognizes() {
        String regexp = "((a|(bc)*d)*)";
        String txt = "abcbcd";
        NFA nfa = new NFA(regexp);
        System.out.println(nfa.recognizes(txt));
    }
}