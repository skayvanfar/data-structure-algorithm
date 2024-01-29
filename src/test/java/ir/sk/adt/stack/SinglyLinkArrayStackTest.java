package ir.sk.adt.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="sad.keyvanfar@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class SinglyLinkArrayStackTest {

    LinkStack<Integer> theStack;

    @Before
    public void setUp() throws Exception {
        theStack = new LinkStack<>(); // make new stack
        theStack.push(20); // push items onto stack
        theStack.push(40);
        theStack.push(60);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void push() {
        theStack.display();
        theStack.push(80);
        theStack.display();
    }

    @Test
    public void pop() {
        theStack.display();
        long value = theStack.pop();
        System.out.print(value);
        theStack.display();
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void display() {
    }
}