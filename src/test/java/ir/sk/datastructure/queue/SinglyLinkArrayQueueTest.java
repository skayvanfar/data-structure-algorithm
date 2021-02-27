package ir.sk.datastructure.queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * demonstrates queue implemented as double-ended list
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class SinglyLinkArrayQueueTest {

    LinkQueue<Integer> theQueue;

    @Before
    public void setUp() throws Exception {
        theQueue = new LinkQueue<>();
        theQueue.enqueue(10); // insert 4 items
        theQueue.enqueue(20);
        theQueue.enqueue(30);
        theQueue.enqueue(40);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void insert() {
        theQueue.display();
        theQueue.enqueue(50);
        theQueue.display();
    }

    @Test
    public void remove() {
        theQueue.display();
        theQueue.dequeue();
        theQueue.display();
    }

    @Test
    public void displayQueue() {
    }
}