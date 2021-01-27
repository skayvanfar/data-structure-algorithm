package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 1/20/2021.
 */
public class MathematicalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isHappyNumberNaive() {
        System.out.println(Mathematical.isHappyNumberNaive(23));
    }

    @Test
    public void isHappyNumberByRunner() {
        System.out.println(Mathematical.isHappyNumberByRunner(23));
    }
}