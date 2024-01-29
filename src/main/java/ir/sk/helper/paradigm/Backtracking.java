package ir.sk.helper.paradigm;

/**
 * Backtracking is a general algorithm for finding all (or some) solutions to some computational problems,
 * that incrementally builds candidates to the solutions, and abandons each partial candidate (“backtracks”)
 * as soon as it determines that the candidate cannot possibly be completed to a valid solution.
 *
 * Backtracking is an algorithmic-technique for solving problems recursively by trying to build a solution incrementally.
 * Solving one piece at a time,
 * and removing those solutions that fail to satisfy the constraints of the problem at any point of time is the process of backtracking.
 *
 * usually appears in constraint-based searches rather than optimization problems.
 * It is a depth-first technique in which elements are added to a solution until the potential solution can either be accepted or ruled out.
 * In the latter case, we go back to an earlier choice and make a different selection Backtracking is also a method of exhaustive search,
 * though the context is usually one where we want any solution rather than some “best” solution.
 *
 * The idea is that we can build a solution step by step using recursion;
 * if during the process we realise that is not going to be a valid solution,
 * then we stop computing that solution and we return back to the step before (backtrack).
 * the sooner we realize invalid solution, algorithm is faster.
 *
 * here Recursion is decision
 *
 * There is a template for backtracking algorithms:
 * result = []
 * def backtrack(Path, selection List):
 *     if meet the End Condition:
 *         result.add(Path)
 *         return
 *
 *     for selection in selection List:
 *         select
 *         (Remove this Selection from the Selection List, Path.add(Selection))
 *         backtrack(Path, selection List)
 *         deselect (Path.remove(selection), Add the selection to the Selection List)
 *
 * @author <a href="sad.keyvanfar@gmail.com">Saeid Keyvanfar</a> on 12/29/2020.
 */
@CompleteSearch
public @interface Backtracking {
}
