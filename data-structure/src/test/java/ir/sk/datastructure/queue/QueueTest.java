package ir.sk.datastructure.queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/10/2017.
 */
public class QueueTest {

    Queue theQueue;

    @Before
    public void setUp() throws Exception {
        theQueue = new Queue(10);
        theQueue.insert(10); // insert 4 items
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        theQueue.display();
        theQueue.insert(50);
        theQueue.display();
    }

    @Test
    public void remove() throws Exception {
        theQueue.display();
        theQueue.remove();
        theQueue.display();
    }

    @Test
    public void peekFront() throws Exception {
    }

    @Test
    public void isEmpty() throws Exception {
    }

    @Test
    public void isFull() throws Exception {
    }

}