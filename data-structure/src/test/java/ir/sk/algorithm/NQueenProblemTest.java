package ir.sk.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
    public void findAllNQueen() {
        queen.findAllNQueen(4);
    }

}