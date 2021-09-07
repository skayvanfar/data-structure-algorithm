package ir.sk.helper.paradigm;

/**
 * Dynamic Programming (DP) is an algorithmic technique for solving an optimization problem
 * by breaking it down into simpler subproblems and utilizing the fact that
 * the optimal solution to the overall problem depends upon the optimal solution to its subproblems.
 *
 * Characteristics of Dynamic Programming:
 * 1. Overlapping Subproblems
 * 2. Optimal Substructure Property for example for Fibonacci: Fib(n) = Fib(n-1) + Fib(n-2)
 *
 * Created by sad.kayvanfar on 2/9/2021.
 */
public @interface DynamicProgramming {
    DynamicProgrammingType type();
}
