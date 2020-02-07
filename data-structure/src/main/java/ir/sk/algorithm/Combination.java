package ir.sk.algorithm;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/6/2020.
 */
public class Combination {

    /**
     * Pascal
     * @param n
     * @param m
     * @return
     */
    public static int combinationByRecursive(int n, int m) {
        if(n == m || m == 0)
            return 1;
        else
            return combinationByRecursive(n - 1, m) + combinationByRecursive(n - 1, m - 1);
    }
}
