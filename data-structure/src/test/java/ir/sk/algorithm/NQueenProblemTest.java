package ir.sk.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/14/2021.
 */
public class NQueenProblemTest {

    NQueenProblem queen;

    @Before
    public void setUp() throws Exception {
        queen = new NQueenProblem();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void solveNQueen() {
        printSolution(queen.solveNQueen());
    }

    @Test
    public void findAllNQueen() {
        System.out.println(queen.findAllNQueen(4));
    }

    /**
     * A utility function to print solution
     *
     * @param board
     */
    private void printSolution(int board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }


}