package ir.sk.algorithm.graph;

import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.Backtracking;

/**
 * Given an undirected graph and a number m, determine if the graph can be coloured with at most m colours such that no two adjacent vertices of the graph are colored with the same color.
 * Here coloring of a graph means the assignment of colors to all vertices.
 *
 * Created by sad.kayvanfar on 9/5/2021.
 */
@Difficulty(type = DifficultyType.MEDIUM)
@Backtracking
@TimeComplexity("O(m^V)")
@SpaceComplexity("O(V), Recursive Stack of graphColoring(…) function will require O(V) space")
public class MColoringProblem {

    int vertexSize;
    int[][] graph;
    int[] color;

    public MColoringProblem(int[][] graph) {
        this.graph = graph;
        this.vertexSize = graph.length;
        this.color = new int[vertexSize];

        // Initialize all color values as 0. This
        // initialization is needed correct
        // functioning of isSafe()
        for (int i = 0; i < vertexSize; i++)
            color[i] = 0;
    }

    /* This function solves the m Coloring problem using
       Backtracking. It mainly uses graphColoringUtil()
       to solve the problem. It returns false if the m
       colors cannot be assigned, otherwise return true
       and  prints assignments of colors to all vertices.
       Please note that there  may be more than one
       solutions, this function prints one of the
       feasible solutions.*/
    public boolean graphColoring(int m) {

        // Call graphColoringUtil() for vertex 0
        if (!graphColoring(graph, m, color, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        // Print the solution
        printSolution(color);
        return true;
    }

    /* A recursive utility function
       to solve m coloring  problem */
    private boolean graphColoring(int graph[][], int m, int color[], int v) {
        /* base case: If all vertices are
           assigned a color then return true */
        if (v == vertexSize)
            return true;

        /* Consider this vertex v and try
           different colors */
        for (int c = 1; c <= m; c++) {
            /* Check if assignment of color c to v
               is fine*/
            if (isSafe(v, graph, color, c)) {
                color[v] = c;

                /* recur to assign colors to rest
                   of the vertices */
                if (graphColoring(graph, m, color, v + 1))
                    return true;

                /* If assigning color c doesn't lead
                   to a solution then remove it */
                color[v] = 0;
            }
        }

        /* If no color can be assigned to
           this vertex then return false */
        return false;
    }

    /* A utility function to check
   if the current color assignment
   is safe for vertex v */
    private boolean isSafe(int v, int graph[][], int color[], int c) {
        for (int i = 0; i < vertexSize; i++)
            if (graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }

    /* A utility function to print solution */
    private void printSolution(int color[]) {
        System.out.println("Solution Exists: Following are the assigned colors");
        for (int i = 0; i < vertexSize; i++)
            System.out.print(" " + color[i] + " ");
        System.out.println();
    }
}
