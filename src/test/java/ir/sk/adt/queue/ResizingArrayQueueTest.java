package ir.sk.adt.queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 3/6/2021.
 */
public class ResizingArrayQueueTest {

    ResizingArrayQueue<Integer> theArrayQueue;

    @Before
    public void setUp() throws Exception {
        theArrayQueue = new ResizingArrayQueue<>();
        theArrayQueue.enqueue(10); // insert 4 items
        theArrayQueue.enqueue(20);
        theArrayQueue.enqueue(30);
        theArrayQueue.enqueue(40);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void enqueue() {
        theArrayQueue.enqueue(50);
    }

    @Test
    public void dequeue() {
    }

    @Test
    public void peek() {
    }
}