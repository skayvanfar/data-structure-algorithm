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
}
