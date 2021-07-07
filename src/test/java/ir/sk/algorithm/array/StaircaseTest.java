package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 7/7/2021.
 */
public class StaircaseTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void naiveCountWays() {
        int n = 4;
        System.out.println(Staircase.naiveCountWays(n));
    }

    @Test
    public void memoizedDPCountWaysByRecursive() {
        int n = 4;
        System.out.println(Staircase.memoizedDPCountWaysByRecursive(n));
    }

    @Test
    public void bottomUpCountWays() {
        int n = 4;
        System.out.println(Staircase.bottomUpCountWays(n));
    }
}