package ir.sk.algorithm.others;

import ir.sk.algorithm.others.BitManipulation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        System.out.println(BitManipulation.getBit(40, 3));
    }

    @Test
    public void setBit() {
        System.out.println(BitManipulation.setBit(40, 1));
    }

    @Test
    public void countSetBits() {
        System.out.println(BitManipulation.countSetBits(9));
    }

    @Test
    public void countSetBitsRecursive() {
        System.out.println(BitManipulation.countSetBitsRecursive(9));
    }

    @Test
    public void maxSoFar() {
        int[] arr = new int[]{1, 5, 2, 4, 9, 7};
        System.out.println(BitManipulation.maxSoFar(arr));
    }
}