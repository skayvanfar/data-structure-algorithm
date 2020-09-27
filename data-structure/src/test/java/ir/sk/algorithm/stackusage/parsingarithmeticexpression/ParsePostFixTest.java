package ir.sk.algorithm.stackusage.parsingarithmeticexpression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class ParsePostFixTest {

    ParsePostFix parsePostFix;
    String input = "345+*612+/-";

    @Before
    public void setUp() throws Exception {
        parsePostFix = new ParsePostFix(input);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void doParse() {
        System.out.println(input);
        int output = parsePostFix.doParse();
        System.out.println(output);
    }
}