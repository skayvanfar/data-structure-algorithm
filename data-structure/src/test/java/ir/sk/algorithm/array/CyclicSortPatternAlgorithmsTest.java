package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sad.kayvanfar on 2/13/2021.
 */
public class CyclicSortPatternAlgorithmsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findMissingNumber() {
        System.out.println(CyclicSortPatternAlgorithms.findMissingNumber(new int[]{4, 0, 3, 1}));
    }

    @Test
    public void findAllMissingNumbers() {
        System.out.println(CyclicSortPatternAlgorithms.findAllMissingNumbers(new int[]{2, 3, 1, 8, 2, 3, 5, 1}));
    }

    @Test
    public void findDuplicateNumber() {
        System.out.println(CyclicSortPatternAlgorithms.findDuplicateNumber(new int[]{1, 4, 4, 3, 2}));
    }

    @Test
    public void findDuplicateByFastAndSlow() {
        System.out.println(CyclicSortPatternAlgorithms.findDuplicateByFastAndSlow(new int[]{1, 4, 4, 3, 2}));
    }

    @Test
    public void findAllDuplicates() {
        System.out.println(CyclicSortPatternAlgorithms.findAllDuplicates(new int[]{1, 4, 4, 5, 5}));
    }

    @Test
    public void findCorruptNumbers() {
        System.out.println(Arrays.toString(CyclicSortPatternAlgorithms.findCorruptNumbers(new int[]{3, 1, 2, 5, 2})));
    }
}