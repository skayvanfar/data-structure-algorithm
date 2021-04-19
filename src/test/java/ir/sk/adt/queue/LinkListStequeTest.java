package ir.sk.adt.queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkListStequeTest {

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
        LinkListSteque<Integer> s = new LinkListSteque<>();
        for (int i = 0; i < 10; i++)
            s.push(i);
        System.out.println();
    }

    @Test
    public void pop() {
    }
}