package ir.sk.algorithm.graph;

import java.util.Stack;

/**
 * Cycle detection: Is a given graph acylic?
 * is G acyclic? (assumes no self-loops or parallel edges)
 *
 * The {@code Cycle} class represents a data type for
 * determining whether an undirected graph has a simple cycle.
 * The <em>hasCycle</em> operation determines whether the graph has
 * a cycle and, if so, the <em>cycle</em> operation returns one.
 * <p>
 * This implementation uses depth-first search.
 * The constructor takes &Theta;(<em>V</em> + <em>E</em>) time in the
 * worst case, where <em>V</em> is the number of vertices and
 * <em>E</em> is the number of edges.
 *
 * (The depth-first search part takes only <em>O</em>(<em>V</em>) time;
 * however, checking for self-loops and parallel edges takes
 * &Theta;(<em>V</em> + <em>E</em>) time in the worst case.)
 * Each instance method takes &Theta;(1) time.
 * It uses &Theta;(<em>V</em>) extra space (not including the graph).
 *
 * Created by sad.kayvanfar on 5/9/2021.
 */
public class Cycle {

    private boolean[] visited;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    /**
     * Determines whether the undirected graph {@code G} has a cycle and,
     * if so, finds such a cycle.
     *
     * @param graph the undirected graph
     */
    public Cycle(Graph graph) {
        // need special case to identify parallel edge as a cycle
        if (hasParallelEdges(graph)) return;

        // don't need special case to identify self-loop as a cycle
        // if (hasSelfLoop(G)) return;

        visited = new boolean[graph.vertexSize()];
        for (int s = 0; s < graph.vertexSize(); s++)
            if (!visited[s])
                dfs(graph, s, s);
    }

    /**
     * @param graph
     * @param currVertex current vertex
     * @param prevVertex previous vertex
     */
    private void dfs(Graph graph, int currVertex, int prevVertex) {
        visited[currVertex] = true;
        for (int w : graph.getNeighborsFor(currVertex)) {
            // short circuit if cycle already found
            if (cycle != null) return;

            if (!visited[w]) {
                edgeTo[w] = prevVertex;
                dfs(graph, w, currVertex);
            }
            // check for cycle (but disregard reverse of edge leading to v)
            else if (w != prevVertex) {
                cycle = new Stack<>();
                for (int x = prevVertex; x != w; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(prevVertex);
            }
        }
    }

    /**
     * Returns true if the graph {@code G} has a cycle.
     *
     * @return {@code true} if the graph has a cycle; {@code false} otherwise
     */
    public boolean hasCycle() {
        return cycle != null;
    }

    /**
     * Returns a cycle in the graph {@code G}.
     * @return a cycle if the graph {@code G} has a cycle,
     *         and {@code null} otherwise
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }

    // does this graph have a self loop?
    // side effect: initialize cycle to be self loop
    private boolean hasSelfLoop(Graph G) {
        for (int v = 0; v < G.vertexSize(); v++) {
            for (int w : G.getNeighborsFor(v)) {
                if (v == w) {
                    cycle = new Stack<>();
                    cycle.push(v);
                    cycle.push(v);
                    return true;
                }
            }
        }
        return false;
    }

    // does this graph have two parallel edges?
    // side effect: initialize cycle to be two parallel edges
    private boolean hasParallelEdges(Graph G) {
        visited = new boolean[G.vertexSize()];

        for (int v = 0; v < G.vertexSize(); v++) {

            // check for parallel edges incident to v
            for (int w : G.getNeighborsFor(v)) {
                if (visited[w]) {
                    cycle = new Stack<>();
                    cycle.push(v);
                    cycle.push(w);
                    cycle.push(v);
                    return true;
                }
                visited[w] = true;
            }

            // reset so marked[v] = false for all v
            for (int w : G.getNeighborsFor(v)) {
                visited[w] = false;
            }
        }
        return false;
    }
}
