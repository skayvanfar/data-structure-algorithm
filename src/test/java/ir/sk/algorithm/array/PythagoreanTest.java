package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 7/7/2021.
 */
public class PythagoreanTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isTripletNaive() {
        int ar[] = { 3, 1, 4, 6, 5 };
        if (Pythagorean.isTripletNaive(ar) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}