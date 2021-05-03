package ir.sk.adt.queue;

import ir.sk.adt.queue.priorityqueue.OrderedArrayPriorityQueue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class OrderedArrayPriorityArrayQueueTest {

    OrderedArrayPriorityQueue<Integer> theQueue;

    @Before
    public void setUp() throws Exception {
        theQueue = new OrderedArrayPriorityQueue<>(10);
        theQueue.insert(10); // insert 4 items
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        theQueue.display();
        theQueue.insert(50);
        theQueue.display();
    }

    @Test
    public void remove() {
        theQueue.display();
        theQueue.extractMax();
        theQueue.display();
    }

    @Test
    public void peekMin() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void isFull() {
    }

    @Test
    public void display() {
    }
}