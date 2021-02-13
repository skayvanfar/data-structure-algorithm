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

    @Test
    public void findAllMissingNumbers() {
        System.out.println(CyclicSortPattern.findAllMissingNumbers(new int[]{2, 3, 1, 8, 2, 3, 5, 1}));
    }
}