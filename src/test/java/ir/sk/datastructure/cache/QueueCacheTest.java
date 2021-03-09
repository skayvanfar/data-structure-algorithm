package ir.sk.datastructure.cache;

import ir.sk.datastructure.fundamental.linklist.DoublyLinkedList;
import ir.sk.datastructure.queue.Queue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 3/9/2021.
 */
public class QueueCacheTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void enqueue() {
        // Create linked list
        QueueCache<String> d = new QueueCache<>();

        d.enqueue("a");
        d.enqueue("b");
        d.enqueue("c");
        d.enqueue("d");
        d.enqueue("c");
        d.display();
    }
}