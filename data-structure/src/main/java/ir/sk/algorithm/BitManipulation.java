package ir.sk.algorithm;

/**
 * Created by sad.kayvanfar on 9/6/2020.
 */
public class BitManipulation {

    public static int repeatedArithmeticShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>= 1; // Arithmetic shift by 1
        }
        return x;
    }

    public static int repeatedLogicalShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>>= 1; // Logical shift by 1
        }
        return x;
    }

    /**
     * This method shifts 1 over by i bits, creating a value that looks like 00010000. By performing an AND with
     * num, we clear all bits other than the bit at bit i. Finally, we compare that to 0. If that new value is not zero,
     * then bit i must have a 1. Otherwise, biti is a 0.
     *
     * @param num
     * @param i
     * @return
     */
    public static boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }

    /**
     * Set Bit shifts 1 over byi bits, creating a value like 00010000. By performing an OR with num, only the
     * value at bit i will change. All other bits of the mask are zero and will not affect num.
     *
     * @param num
     * @param i
     * @return
     */
    public static int setBit(int num, int i) {
        return num | (1 << i);
    }
}
