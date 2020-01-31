package ir.sk.algorithm;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class Factorial {

    /**
     * @param n
     * @return
     */
    public static int factorialByRecursive(int n)
    {
        if(n==0)
            return 1;
        else
            return (n * factorialByRecursive(n-1) );
    }
}
