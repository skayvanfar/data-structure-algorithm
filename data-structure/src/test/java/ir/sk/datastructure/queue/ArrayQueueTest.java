package ir.sk.datastructure.queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/10/2017.
 */
public class ArrayQueueTest {

    ArrayQueue<Integer> theArrayQueue;

    @Before
    public void setUp() throws Exception {
        theArrayQueue = new ArrayQueue<>(10);
        theArrayQueue.add(10); // insert 4 items
        theArrayQueue.add(20);
        theArrayQueue.add(30);
        theArrayQueue.add(40);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        theArrayQueue.display();
        theArrayQueue.add(50);
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