package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 5/30/2021.
 */
public class AllPairsTest {

    private int[] array;

    @Before
    public void setUp() throws Exception {
        array = new int[] {1, 2, 3};
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void allPairs() {
        AllPairs.allPairs(array);

    }

    @Test
    public void allOrderPairs() {
        AllPairs.allOrderPairs(array);
    }
}