package ir.sk.algorithm.stack.parsingarithmeticexpression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class InFixToPostFixTest {

    InFixToPostFix inFixToPostFix;
    String input = "(D+C(A*B))";

    @Before
    public void setUp() throws Exception {
        inFixToPostFix = new InFixToPostFix(input);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void doTrans() {
        System.out.println(input);
        String output = inFixToPostFix.doTrans(); // do the translation
        System.out.println(output);
    }

    @Test
    public void gotOper() {
    }

    @Test
    public void gotParen() {
    }
}