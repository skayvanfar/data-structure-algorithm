package ir.sk.datastructure.queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StequeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void enqueue() {
    }

    @Test
    public void push() {
        Steque<Integer> s = new Steque<>();
        for (int i = 0; i < 10; i++)
            s.push(i);
        System.out.println();
    }

    @Test
    public void pop() {
    }
}