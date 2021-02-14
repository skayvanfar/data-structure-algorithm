package ir.sk.algorithm.mathematic;

import ir.sk.helper.RecurrenceRelation;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.BruteForce;

import java.math.BigInteger;

/**
 * f(n) =
 * 1             n = 1
 * n * f(n-1)    n > 1
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class Factorial {

    /**
     * Factorial of a non-negative integer, is multiplication of all integers smaller than or equal to n.
     * For example factorial of 6 is 6*5*4*3*2*1 which is 720
     *
     * @param n
     * @return
     */
    @BruteForce
    @RecurrenceRelation("T(n) = T(n-1) + O(1)")
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static int factorialByRecursive(int n) {
        if (n == 0)
            return 1;
        else
            return (n * factorialByRecursive(n - 1));
    }

    /**
     * @param n
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static int factorialByLoop(int n) {
        int res = 1, i;
        for (i = 2; i <= n; i++)
            res *= i;
        return res;
    }

    // Java Program to Calculate Factorial of Large Number

    /**
     * BigInteger has no limit it can hold large values
     *
     * @param number
     * @return
     */
    public static BigInteger factorialByBigInteger(int number) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = number; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }

    /**
     * @param n
     */
    public static String factorialLargeNumber(int n) {
        int res[] = new int[500];

        // Initialize result
        res[0] = 1;
        int res_size = 1;

        // Apply simple factorial formula
        // n! = 1 * 2 * 3 * 4...*n
        for (int x = 2; x <= n; x++)
            res_size = multiply(x, res, res_size);

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = res_size - 1; i >= 0; i--)
            stringBuffer.append(res[i]);
        return stringBuffer.toString();
    }

    // This function multiplies x with the number
    // represented by res[]. res_size is size of res[] or
    // number of digits in the number represented by res[].
    // This function uses simple school mathematics for
    // multiplication. This function may value of res_size
    // and returns the new value of res_size
    static int multiply(int x, int res[], int res_size) {
        int carry = 0; // Initialize carry

        // One by one multiply n with individual
        // digits of res[]
        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10; // Store last digit of
            // 'prod' in res[]
            carry = prod / 10; // Put rest in carry
        }

        // Put carry in res and increase result size
        while (carry != 0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }


}
