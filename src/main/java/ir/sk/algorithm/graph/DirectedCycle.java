package ir.sk.algorithm.graph;

import java.util.Stack;

/**
 * A directed path in a digraph is a sequence of vertices in which there is
 * a (directed) edge pointing from each vertex in the sequence to its successor in the
 * sequence. A directed cycle is a directed path with at least one edge whose first and
 * last vertices are the same. A simple cycle is a cycle with no repeated edges or vertices
 * (except the requisite repetition of the first and last vertices). The length of a path or
 * a cycle is its number of edges.
 */
public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle; // vertices on a cycle (if one exists)
    private boolean[] onStack; // vertices on recursive call stack

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.vertexSize()];
        edgeTo = new int[G.vertexSize()];
        marked = new boolean[G.vertexSize()];
        for (int v = 0; v < G.vertexSize(); v++)
            if (!marked[v]) dfs(G, v);

    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.getNeighborsFor(v))
            if (this.hasCycle())
                return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

}
