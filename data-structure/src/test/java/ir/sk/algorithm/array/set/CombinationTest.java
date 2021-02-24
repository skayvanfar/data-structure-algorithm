package ir.sk.algorithm.array.set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CombinationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void combinationByBacktracking() {
        List<List<Integer>> result = Combination.combinationByBacktracking(4, 2);
        System.out.println("here are all the combination: " + result);
    }
}