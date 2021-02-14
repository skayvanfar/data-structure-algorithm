package ir.sk.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 9/22/2020.
 */
public class TripleStepTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void naiveCountWays() {
        int n = 4;
        System.out.println(TripleStep.naiveCountWays(n));
    }

    @Test
    public void memoizedDPCountWaysByRecursive() {
        int n = 4;
        System.out.println(TripleStep.memoizedDPCountWaysByRecursive(n));
    }

    @Test
    public void bottomUpCountWays() {
        int n = 4;
        System.out.println(TripleStep.bottomUpCountWays(n));
    }

    @Test
    public void magicIndexNaive() {
        System.out.println(TripleStep.magicIndexNaive(new int[]{8,9,2,3,4}));
    }

    @Test
    public void magicIndexBinarySearch() {
        System.out.println(TripleStep.magicIndexBinarySearch(new int[]{8,9,2,3,4}));
    }
}