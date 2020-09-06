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
}
