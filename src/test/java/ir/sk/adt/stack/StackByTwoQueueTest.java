package ir.sk.adt.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 3/10/2021.
 */
public class StackByTwoQueueTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void push() {
        Stack s = new StackByTwoQueue();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

    @Test
    public void pop() {
    }
}