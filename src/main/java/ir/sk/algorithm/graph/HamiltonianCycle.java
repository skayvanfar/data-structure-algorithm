package ir.sk.algorithm.graph;

import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.Backtracking;

/**
 * Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once.
 * A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge (in the graph) from the last vertex to the first vertex of the Hamiltonian Path.
 *
 * Created by sad.kayvanfar on 9/5/2021.
 */
@Difficulty(type = DifficultyType.HARD)
@Backtracking
public class HamiltonianCycle {

    int vertexSize;
    int[][] graph;
    int[] path;

    public HamiltonianCycle( int[][] graph) {
        this.graph = graph;
        this.vertexSize = graph.length;

        this.path = new int[vertexSize];
        for (int i = 0; i < vertexSize; i++)
            path[i] = -1;
    }

    /* This function solves the Hamiltonian Cycle problem using
           Backtracking. It mainly uses hamCycleUtil() to solve the
           problem. It returns false if there is no Hamiltonian Cycle
           possible, otherwise return true and prints the path.
           Please note that there may be more than one solutions,
           this function prints one of the feasible solutions. */
    public int hamCycle() {
        /* Let us put vertex 0 as the first vertex in the path.
           If there is a Hamiltonian Cycle, then the path can be
           started from any point of the cycle as the graph is
           undirected */
        path[0] = 0;
        if (hamCycle(graph, path, 1) == false) {
            System.out.println("\nSolution does not exist");
            return 0;
        }

        printSolution(path);
        return 1;
    }

    /* A recursive utility function to solve hamiltonian
       cycle problem */
    private boolean hamCycle(int graph[][], int path[], int pos) {
        /* base case: If all vertices are included in
           Hamiltonian Cycle */
        if (pos == vertexSize) {
            // And if there is an edge from the last included
            // vertex to the first vertex
            if (graph[path[pos - 1]][path[0]] == 1)
                return true;
            else
                return false;
        }

        // Try different vertices as a next candidate in
        // Hamiltonian Cycle. We don't try for 0 as we
        // included 0 as starting point in hamCycle()
        for (int v = 1; v < vertexSize; v++) {
            /* Check if this vertex can be added to Hamiltonian
               Cycle */
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;

                /* recur to construct rest of the path */
                if (hamCycle(graph, path, pos + 1) == true)
                    return true;

                /* If adding vertex v doesn't lead to a solution,
                   then remove it */
                path[pos] = -1;
            }
        }

        /* If no vertex can be added to Hamiltonian Cycle
           constructed so far, then return false */
        return false;
    }

    /* A utility function to check if the vertex v can be
   added at index 'pos'in the Hamiltonian Cycle
   constructed so far (stored in 'path[]') */
    private boolean isSafe(int v, int graph[][], int path[], int pos) {
        /* Check if this vertex is an adjacent vertex of
           the previously added vertex. */
        if (graph[path[pos - 1]][v] == 0)
            return false;

        /* Check if the vertex has already been included.
           This step can be optimized by creating an array
           of size V */
        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;

        return true;
    }

    /* A utility function to print solution */
    private void printSolution(int path[]) {
        System.out.println("Solution Exists: Following is one Hamiltonian Cycle");
        for (int i = 0; i < vertexSize; i++)
            System.out.print(" " + path[i] + " ");

        // Let us print the first vertex again to show the
        // complete cycle
        System.out.println(" " + path[0] + " ");
    }
}
