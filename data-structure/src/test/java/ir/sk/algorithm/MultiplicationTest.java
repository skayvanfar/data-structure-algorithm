package ir.sk.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/10/2020.
 */
public class MultiplicationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void karatsubaMultiply() {
        BigInteger n = new BigInteger("1234");
        BigInteger m = new BigInteger("4321");
        System.out.println(Multiplication.karatsubaMultiplyByBigInteger(n, m));
    }
}