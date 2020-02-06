package ir.sk.algorithm;

/**
 * f(n) =
 *  1             n = 1
 *  n + f(n-1)    n > 1
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class TriangleNumbers {

    /**
     * Using loop
     * @param n
     * @return
     */
    public static int triangleByLoop(int n)
    {
        int total = 0;
        while(n > 0) // until n is 1
        {
            total = total + n; // add n (column height) to total
            --n; // decrement column height
        }
        return total;
    }

    /**
     * Using Recursion
     * @param n
     * @return
     */
    public static int triangleByRecursive(int n) {
        if(n==1)
            return 1;
        else
            return  ( n + triangleByRecursive(n-1) );
    }
}
