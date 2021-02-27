package ir.sk.algorithm.others;

import ir.sk.algorithm.others.RatInMaze;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 2/15/2021.
 */
public class RatInMazeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void solveMaze() {
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};

        RatInMaze rat = new RatInMaze(maze.length);

        rat.solveMaze(maze);
    }
}