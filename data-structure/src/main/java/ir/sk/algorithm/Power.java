package ir.sk.algorithm;

/**
 * f(n, m) =
 *  n             m = 1
 *  n * f(n, m - 1)    m > 1
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/6/2020.
 */
public class Power {

    public static int powerByRecursive(int n, int m) {
        if(m==1)
            return n;
        else
            return (n * powerByRecursive(n, m - 1) );
    }
}
