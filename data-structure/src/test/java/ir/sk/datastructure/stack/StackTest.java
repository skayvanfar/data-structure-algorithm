package ir.sk.datastructure.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/10/2017.
 */
public class StackTest {

    Stack theStack;

    @Before
    public void setUp() throws Exception {
        theStack = new Stack(10); // make new stack
        theStack.push(20); // push items onto stack
        theStack.push(40);
        theStack.push(60);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void push() throws Exception {
        theStack.display();
        theStack.push(80);
        theStack.display();
    }

    @Test
    public void pop() throws Exception {
        theStack.display();
        long value = theStack.pop();
        System.out.print(value);
        theStack.display();
    }

    @Test
    public void peek() throws Exception {
    }

    @Test
    public void isEmpty() throws Exception {
        System.out.println(theStack.isEmpty());
    }

    @Test
    public void isFull() throws Exception {
        System.out.println(theStack.isFull());
    }

}