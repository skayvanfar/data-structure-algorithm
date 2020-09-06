package ir.sk.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 9/6/2020.
 */
public class BitManipulationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void repeatedArithmeticShift() {
        System.out.println(BitManipulation.repeatedArithmeticShift(-40, 1));
    }

    @Test
    public void repeatedLogicalShift() {
        System.out.println(BitManipulation.repeatedLogicalShift(-40, 1));
    }

    @Test
    public void getBit() {
        System.out.println(BitManipulation.getBit(40, 1));
    }

    @Test
    public void setBit() {
        System.out.println(BitManipulation.setBit(40, 1));
    }
}