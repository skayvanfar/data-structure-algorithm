package ir.sk.helper.technique;

/**
 * Created by sad.kayvanfar on 2/9/2021.
 */
public enum DynamicProgrammingType {

    /*
    * In this approach, we try to solve the bigger problem by recursively finding the solution to smaller sub-problems.
    * Whenever we solve a sub-problem, we cache its result so that we don’t end up solving it repeatedly if it’s called multiple times.
    * Instead, we can just return the saved result. This technique of storing the results of already solved subproblems is called Memoization.
    * */
    TOP_DAWN_MEMOIZATION,
    /*
     * Tabulation is the opposite of the top-down approach and avoids recursion.
     * In this approach, we solve the problem “bottom-up” (i.e. by solving all the related sub-problems first).
     *  This is typically done by filling up an n-dimensional table. Based on the results in the table,
     *  the solution to the top/original problem is then computed.
     * Tabulation is the opposite of Memoization, as in Memoization we solve the problem and maintain a map of already solved sub-problems.
     * In other words, in memoization, we do it top-down in the sense that we solve the top problem first (which typically recurses down to solve the sub-problems).
     * */
    DOWN_TOP_TABULATION
}
