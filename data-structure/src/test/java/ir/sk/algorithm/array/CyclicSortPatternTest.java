package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 2/13/2021.
 */
public class CyclicSortPatternTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findMissingNumber() {
        System.out.println(CyclicSortPattern.findMissingNumber(new int[]{4, 0, 3, 1}));
    }
}