package ir.sk.datastructure.queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/10/2017.
 */
public class ArrayQueueTest {

    ArrayQueue theArrayQueue;

    @Before
    public void setUp() throws Exception {
        theArrayQueue = new ArrayQueue(10);
        theArrayQueue.insert(10); // insert 4 items
        theArrayQueue.insert(20);
        theArrayQueue.insert(30);
        theArrayQueue.insert(40);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        theArrayQueue.display();
        theArrayQueue.insert(50);
        theArrayQueue.display();
    }

    @Test
    public void remove() throws Exception {
        theArrayQueue.display();
        theArrayQueue.remove();
        theArrayQueue.display();
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