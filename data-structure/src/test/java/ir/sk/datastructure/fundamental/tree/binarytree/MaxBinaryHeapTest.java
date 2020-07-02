package ir.sk.datastructure.fundamental.tree.binarytree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/2/2020.
 */
public class MaxBinaryHeapTest {

    private MaxBinaryHeap maxBinaryHeap;

    @Before
    public void setUp() throws Exception {
        maxBinaryHeap = new MaxBinaryHeap(15);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        maxBinaryHeap.insert(4);
        maxBinaryHeap.insert(10);
        maxBinaryHeap.insert(1);
        maxBinaryHeap.printArray();
    }

    @Test
    public void maxHeapify() {
        int[] unOrderedArray = new int[] {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        maxBinaryHeap = new MaxBinaryHeap(unOrderedArray);
        maxBinaryHeap.maxHeapify(1);
        maxBinaryHeap.printArray();
    }

    @Test
    public void buildMaxHeap() {
        int[] unOrderedArray = new int[] {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        maxBinaryHeap = new MaxBinaryHeap(unOrderedArray);
        maxBinaryHeap.buildMaxHeap();
        maxBinaryHeap.printArray();
    }

    @Test
    public void max() {
        maxBinaryHeap.insert(4);
        maxBinaryHeap.insert(10);
        maxBinaryHeap.insert(1);
        assertEquals(10, maxBinaryHeap.max());
    }

    @Test
    public void extractMaximum() {
        maxBinaryHeap.insert(4);
        maxBinaryHeap.insert(10);
        maxBinaryHeap.insert(1);
        assertEquals(10, maxBinaryHeap.extractMax());
        maxBinaryHeap.printArray();
    }
}