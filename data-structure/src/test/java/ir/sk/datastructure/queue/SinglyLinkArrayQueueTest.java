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
        theQueue.add(10); // insert 4 items
        theQueue.add(20);
        theQueue.add(30);
        theQueue.add(40);
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
        theQueue.add(50);
        theQueue.display();
    }

    @Test
    public void remove() {
        theQueue.display();
        theQueue.remove();
        theQueue.display();
    }

    @Test
    public void displayQueue() {
    }
}