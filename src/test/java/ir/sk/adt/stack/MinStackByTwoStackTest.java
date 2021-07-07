package ir.sk.adt.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 7/7/2021.
 */
public class MinStackByTwoStackTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void min() {
        MinStackByTwoStack s = new MinStackByTwoStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.min());
        s.push(5);
        System.out.println(s.min());
    }
}