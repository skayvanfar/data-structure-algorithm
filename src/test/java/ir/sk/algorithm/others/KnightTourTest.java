package ir.sk.algorithm.others;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 9/5/2021.
 */
public class KnightTourTest {

    KnightTour knightTour;

    @Before
    public void setUp() throws Exception {
        knightTour = new KnightTour(8);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void solveKT() {
        knightTour.solveKT();
    }
}