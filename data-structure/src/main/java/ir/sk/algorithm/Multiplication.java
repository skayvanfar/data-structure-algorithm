package ir.sk.algorithm;

import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.math.BigInteger;

/**
 * A multiplication algorithm is an algorithm (or method) to multiply two numbers. Depending on the size of the numbers, different algorithms are used.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/10/2020.
 */
public class Multiplication {

    /**
     * Naive Multiplication
     * multiplying numbers is taught in schools as long multiplication, sometimes called grade-school multiplication,
     * sometimes called Standard Algorithm:
     * multiply the multiplicand by each digit of the multiplier and then add up all the properly shifted results.
     *
     * @param a
     * @param b
     * @return
     */
    @TimeComplexity("O(n2) n: a array length")
    @SpaceComplexity("O(n+m) m: b array length")
    public static int[] nativeMultiply(int[] a, int[] b, int base) {
        int[] product = new int[a.length + b.length];
        for (int j = 0; j < b.length; j++) {
            int carry = 0;
            for (int i = 0; i < a.length; i++) {
                product[i + j] += carry + a[i] * b[j];
                carry = product[i + j] / base;
                product[i + j] = product[i + j] % base;
            }
            product[j + a.length] = carry;
        }
        return product;
    }

    /**
     * Karatsuba algorithm for fast multiplication using Divide and Conquer algorithm
     *
     * @param n
     * @param m
     * @return
     */
    @TimeComplexity("O(n^log3) = O(n^1.59)")
    public static BigInteger karatsubaMultiplyByBigInteger(BigInteger n, BigInteger m) {
        if (isSingle(n) && isSingle(m)) {
            return n.multiply(m);
        }
        int numAndSumOfN[] = getNumAndSumOfDigits(n);
        int numAndSumOfM[] = getNumAndSumOfDigits(m);

        // Returns an array of two BigIntegers containing (this / val) followed
        // by (this % val).
/*		BigInteger[] splitN = n.divideAndRemainder(BigInteger.valueOf(10 ^ (numAndSumOfN[0] / 2)));
		BigInteger[] splitM = m.divideAndRemainder(BigInteger.valueOf(10 ^ (numAndSumOfM[0] / 2)));
		*/

        BigInteger firstHalfN = n.divide(BigInteger.valueOf((long) Math.pow(10.0, (numAndSumOfN[0] / 2))));
        BigInteger secondHalfN = n.mod(BigInteger.valueOf((long) Math.pow(10.0, (numAndSumOfN[0] / 2))));


        BigInteger firstHalfM = m.divide(BigInteger.valueOf((long) Math.pow(10.0, (numAndSumOfM[0] / 2))));
        BigInteger secondHalfM = m.mod(BigInteger.valueOf((long) Math.pow(10.0, (numAndSumOfM[0] / 2))));

        BigInteger a = karatsubaMultiplyByBigInteger(firstHalfN, firstHalfM);
        BigInteger d = karatsubaMultiplyByBigInteger(secondHalfN, secondHalfM);
        // Note that numAndSumOfN[1] has the sum of digits at 1st index,
        // similarly for M
        // Below is same as finding e(i.e result) = [(Sum of firstHalfN + secondHalfN) * (Sum of firstHalfM + secondHalfM)]-a-d
        BigInteger e = karatsubaMultiplyByBigInteger((firstHalfN.add(secondHalfN)), (firstHalfM.add(secondHalfM))).subtract(a).subtract(d);


        BigInteger aResult = a.multiply(BigInteger.valueOf((long) Math.pow(10, numAndSumOfN[0])));
        BigInteger eResult = e.multiply(BigInteger.valueOf((long) Math.pow(10, numAndSumOfN[0] / 2)));
        //xy  = a*10^n + e * r^n/2 + d
        return aResult.add(eResult).add(d);


    }

    /**
     * @param n
     * @return
     */
    public static boolean isSingle(BigInteger n) {
        if (n.intValue() <= 9 && n.intValue() >= 0)
            return true;
        return false;
    }

    /**
     * @param n
     * @return
     */
    public static int[] getNumAndSumOfDigits(BigInteger n) {
        int numOfDigits = 0;
        int sumOfDigits = 0;

        // Convert BigInteger to String and then count the digits and also sum
        // of digits, faster than using mod 10
        String digits = n.toString();
        for (int i = 0; i < digits.length(); i++) {
            sumOfDigits += Character.getNumericValue(digits.charAt(i));
            numOfDigits++;
        }
        int[] numAndSum = {numOfDigits, sumOfDigits};
        return numAndSum;

    }

    /**
     * Karatsuba algorithm for fast multiplication using Divide and Conquer algorithm
     * <p>
     * Time complexity: (n^log3) = O(n^1.59)
     *
     * @param x
     * @param y
     * @return
     */
    @TimeComplexity("O(n^log3) = O(n^1.59)")
    public static BigInteger karatsuba2ByBigInteger(BigInteger x, BigInteger y) {

        // cutoff to brute force
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 2000) return x.multiply(y);                // optimize this parameter

        // number of bits divided by 2, rounded up
        N = (N / 2) + (N % 2);

        // x = a + 2^N b,   y = c + 2^N d
        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        // compute sub-expressions
        BigInteger ac = karatsuba2ByBigInteger(a, c);
        BigInteger bd = karatsuba2ByBigInteger(b, d);
        BigInteger abcd = karatsuba2ByBigInteger(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2 * N));
    }

    /**
     * @param i
     * @param j
     * @return
     */
    public static long karatsuba2(long i, long j) {
        if (i < 10 || j < 10)
            return i * j;
        double n = getLength(Math.max(i, j));
        if (n % 2 == 1)
            n++;
        long a = (long) (i / Math.pow(10, (n / 2)));
        long b = (long) (i % Math.pow(10, (n / 2)));
        long c = (long) (j / Math.pow(10, (n / 2)));
        long d = (long) (j % Math.pow(10, (n / 2)));

        long first = karatsuba2(a, c);
        long second = karatsuba2(b, d);
        long third = karatsuba2(a + b, c + d);

        return ((long) ((first * Math.pow(10, n)) + ((third - first - second) * Math.pow(10, (n / 2))) + second));
    }

    public static int getLength(long a) {
        String b = Long.toString(a);
        return b.length();
    }

    /**
     * computes the product of a and b
     *
     * @param a
     * @param b
     * @return
     */
    @TimeComplexity("O(b)")
    @SpaceComplexity("O(1)")
    public static int product(int a, int b) {
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += a;
        }
        return sum;
    }

}
