package ir.sk.adt.queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ir.sk.adt.queue.circulararrayqueue.CircularArrayQueue;

public class ArrayCircularQueueTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void enqueue() {
        CircularArrayQueue<Integer> c = new CircularArrayQueue<>(10);
        for (int i = 0; i < 10; i++) {
            c.enqueue(i);
        }

        System.out.println("\nTest dequeue():");
        for (int i = 0; i < 5; i++) {
            System.out.printf("(%d) %s\n", c.dequeue(), c);
        }

        System.out.printf("\nSize: %d, MaxSize: %d\n", c.size(), c.maxSize());

        System.out.println("\nTest enqueue():");
        for (int i = 10; i < 15; i++) {
            c.enqueue(i);
            System.out.printf("(%d) %s\n", i, c);
        }
    }

    @Test
    public void dequeue() {
    }

    @Test
    public void peek() {
    }
}