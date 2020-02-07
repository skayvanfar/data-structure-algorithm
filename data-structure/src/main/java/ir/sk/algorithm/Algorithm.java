package ir.sk.algorithm;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/7/2020.
 */
public class Algorithm {

    public static int fibonacciByRecursive(int n) {
        if(n == 0 || n == 1)
            return n;
        else
            return fibonacciByRecursive(n -1 ) + fibonacciByRecursive(n - 2);
    }

    public static int mod(int a, int b) {
        if (a < b)
            return a;
        else
            return mod(a - 1, b) +  mod(a - 1,b - 1);
    }

    /**
     * the Euclidean algorithm, or Euclid's algorithm, is an efficient method for
     * computing the greatest common divisor (GCD) of two numbers, the largest number
     * that divides both of them without leaving a remainder.
     * @param a
     * @param b
     * @return
     */
    public static int gcdByEuclidean(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcdByEuclidean(b, mod(a,  b));
    }

}
