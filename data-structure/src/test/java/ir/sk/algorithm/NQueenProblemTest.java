package ir.sk.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/14/2021.
 */
public class NQueenProblemTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void solveNQ() {
        NQueenProblem Queen = new NQueenProblem();
        Queen.solveNQ();
    }
}