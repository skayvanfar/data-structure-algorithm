package ir.sk.algorithm.others;

import ir.sk.algorithm.others.NQueenProblem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="sad.keyvanfar@gmail.com">Saeid Keyvanfar</a> on 1/14/2021.
 */
public class NQueenProblemTest {

    NQueenProblem queen;

    @Before
    public void setUp() throws Exception {
        queen = new NQueenProblem(4);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAllNQueen() {
        queen.findAllNQueen();
    }

}