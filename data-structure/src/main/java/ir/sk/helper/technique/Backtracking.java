package ir.sk.helper.technique;

/**
 * Backtracking is a general algorithm for finding all (or some) solutions to some computational problems,
 * that incrementally builds candidates to the solutions, and abandons each partial candidate (“backtracks”)
 * as soon as it determines that the candidate cannot possibly be completed to a valid solution.
 *
 * Backtracking is an algorithmic-technique for solving problems recursively by trying to build a solution incrementally.
 * Solving one piece at a time,
 * and removing those solutions that fail to satisfy the constraints of the problem at any point of time is the process of backtracking.
 *
 * The idea is that we can build a solution step by step using recursion;
 * if during the process we realise that is not going to be a valid solution,
 * then we stop computing that solution and we return back to the step before (backtrack).
 * the sooner we realize invalid solution, algorithm is faster.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/29/2020.
 */
public @interface Backtracking {
}
