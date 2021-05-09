package ir.sk.algorithm.graph;

import ir.sk.helper.Point;
import ir.sk.helper.pattern.HashingIndexPattern;

import java.util.Stack;

/**
 * Depth-first search to find paths in a graph. It doesn't give shortest path
 *
 * Created by sad.kayvanfar on 5/8/2021.
 */
public class DepthFirstPaths {
    @Point("First think about adt and the implementation, if you can use data structure like hear")
    private boolean[] marked; // Has dfs() been called for this vertex? // instead of Set adt, use hashtable data structure
    @HashingIndexPattern
    private int[] edgeTo; // last vertex on known path to this vertex // instead of Map adt, use hashtable data structure
    private final int sourceVertex; // source

    /**
     * Path Detection
     *
     * Computes a path between {@code s} and every other vertex in graph {@code G}.
     * @param graph the graph
     * @param sourceVertex the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    public DepthFirstPaths(Graph graph, int sourceVertex) {
        this.sourceVertex = sourceVertex;
        edgeTo = new int[graph.vertexSize()];
        marked = new boolean[graph.vertexSize()];
        validateVertex(sourceVertex);
        dfs(graph, sourceVertex);
    }

    // depth first search from v
    private void dfs(Graph graph, int vertex) {
        marked[vertex] = true;
        for (int w : graph.getNeighborsFor(vertex)) {
            if (!marked[w]) {
                edgeTo[w] = vertex;
                dfs(graph, w);
            }
        }
    }

    /**
     * Is there a path between the source vertex {@code s} and vertex {@code v}?
     * @param v the vertex
     * @return {@code true} if there is a path, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }

    /**
     * Single-source paths
     *
     * Returns a path between the source vertex {@code s} and vertex {@code v}, or
     * {@code null} if no such path.
     * @param  v the vertex
     * @return the sequence of vertices on a path between the source vertex
     *         {@code s} and vertex {@code v}, as an Iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != sourceVertex; x = edgeTo[x])
            path.push(x);
        path.push(sourceVertex);
        return path;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}
