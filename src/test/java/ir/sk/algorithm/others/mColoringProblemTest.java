package ir.sk.algorithm.others;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 9/5/2021.
 */
public class mColoringProblemTest {

    MColoringProblem Coloring;

    @Before
    public void setUp() throws Exception {
        /* Create following graph and
           test whether it is
           3 colorable
          (3)---(2)
           |   / |
           |  /  |
           | /   |
          (0)---(1)
        */
        int graph[][] = {
                { 0, 1, 1, 1 },
                { 1, 0, 1, 0 },
                { 1, 1, 0, 1 },
                { 1, 0, 1, 0 },
        };
        Coloring = new MColoringProblem(graph);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void graphColoring() {
        int m = 3; // Number of colors
        Coloring.graphColoring(m);
    }
}