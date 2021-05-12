package ir.sk.algorithm.graph;

import java.util.Stack;

/**
 * A directed path in a digraph is a sequence of vertices in which there is
 * a (directed) edge pointing from each vertex in the sequence to its successor in the
 * sequence. A directed cycle is a directed path with at least one edge whose first and
 * last vertices are the same. A simple cycle is a cycle with no repeated edges or vertices
 * (except the requisite repetition of the first and last vertices). The length of a path or
 * a cycle is its number of edges.
 *
 * The {@code DirectedCycle} class represents a data type for
 * determining whether a digraph has a directed cycle.
 * The <em>hasCycle</em> operation determines whether the digraph has
 * a simple directed cycle and, if so, the <em>cycle</em> operation
 * returns one.
 * <p>
 * This implementation uses depth-first search.
 * The constructor takes &Theta;(<em>V</em> + <em>E</em>) time in the worst
 * case, where <em>V</em> is the number of vertices and <em>E</em> is
 * the number of edges.
 * Each instance method takes &Theta;(1) time.
 * It uses &Theta;(<em>V</em>) extra space (not including the digraph).
 * <p>
 * See {@link Topological} to compute a topological order if the
 * digraph is acyclic.
 */
public class DirectedCycle {

    private boolean[] visited;      // visited[v] = has vertex v been marked?
    private int[] edgeTo;           // edgeTo[v] = previous vertex on path to v
    private Stack<Integer> cycle;   // vertices on a cycle (if one exists)
    private boolean[] onStack;      // vertices on recursive call stack

    /**
     * Determines whether the digraph {@code G} has a directed cycle and, if so,
     * finds such a cycle.
     * @param digraph the digraph
     */
    public DirectedCycle(Digraph digraph) {
        onStack = new boolean[digraph.vertexSize()];
        edgeTo = new int[digraph.vertexSize()];
        visited = new boolean[digraph.vertexSize()];
        for (int v = 0; v < digraph.vertexSize(); v++)
            if (!visited[v]) dfs(digraph, v);

    }

    // run DFS and find a directed cycle (if one exists)
    private void dfs(Digraph digraph, int currVertex) {
        onStack[currVertex] = true;
        visited[currVertex] = true;
        for (int w : digraph.getNeighborsFor(currVertex))
            // short circuit if directed cycle found
            if (this.hasCycle())
                return;
            // found new vertex, so recur
            else if (!visited[w]) {
                edgeTo[w] = currVertex;
                dfs(digraph, w);
            } else if (onStack[w]) { // trace back directed cycle
                cycle = new Stack<>();
                for (int x = currVertex; x != w; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(currVertex);
                assert check();
            }
        onStack[currVertex] = false;
    }

    /**
     * Does the digraph have a directed cycle?
     * @return {@code true} if the digraph has a directed cycle, {@code false} otherwise
     */
    public boolean hasCycle() {
        return cycle != null;
    }


    /**
     * Returns a directed cycle if the digraph has a directed cycle, and {@code null} otherwise.
     * @return a directed cycle (as an iterable) if the digraph has a directed cycle,
     *    and {@code null} otherwise
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }

    // certify that digraph has a directed cycle if it reports one
    private boolean check() {

        if (hasCycle()) {
            // verify cycle
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }


        return true;
    }
}
