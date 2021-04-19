package ir.sk.adt.queue;

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
        theArrayQueue.enqueue(10); // insert 4 items
        theArrayQueue.enqueue(20);
        theArrayQueue.enqueue(30);
        theArrayQueue.enqueue(40);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        theArrayQueue.display();
        theArrayQueue.enqueue(50);
        theArrayQueue.display();
    }

    @Test
    public void remove() throws Exception {
        theArrayQueue.display();
        theArrayQueue.dequeue();
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