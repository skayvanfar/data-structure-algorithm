package ir.sk.datastructure.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/10/2017.
 */
public class FixedArrayStackTest {

    FixedArrayStack<Integer> theArrayStack;

    @Before
    public void setUp() throws Exception {
        theArrayStack = new FixedArrayStack<>(10); // make new stack
        theArrayStack.push(20); // push items onto stack
        theArrayStack.push(40);
        theArrayStack.push(60);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void push() throws Exception {
        theArrayStack.display();
        theArrayStack.push(80);
        theArrayStack.display();
    }

    @Test
    public void pop() throws Exception {
        theArrayStack.display();
        long value = theArrayStack.pop();
        System.out.print(value);
        theArrayStack.display();
    }

    @Test
    public void peek() throws Exception {
    }

    @Test
    public void isEmpty() throws Exception {
        System.out.println(theArrayStack.isEmpty());
    }

    @Test
    public void isFull() throws Exception {
        System.out.println(theArrayStack.isFull());
    }

}