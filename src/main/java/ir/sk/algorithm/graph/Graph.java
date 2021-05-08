package ir.sk.algorithm.graph;

import ir.sk.adt.bag.Bag;
import ir.sk.adt.bag.LinkBag;

import java.util.Stack;

/**
 * Created by sad.kayvanfar on 5/8/2021.
 */
public class Graph {

    private final int vertexSize;
    private int edgeSize;
    private Bag<Integer>[] adj;

    /**
     * Initializes an empty graph with {@code V} vertices and 0 edges.
     * param V the number of vertices
     *
     * @param  vertexSize number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public Graph(int vertexSize) {
        if (vertexSize < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.vertexSize = vertexSize;
        this.edgeSize = 0;
        adj = (Bag<Integer>[]) new Bag[vertexSize];
        for (int v = 0; v < vertexSize; v++) {
            adj[v] = new LinkBag<>();
        }
    }

    /**
     * Initializes a new graph that is a deep copy of {@code G}.
     *
     * @param  graph the graph to copy
     * @throws IllegalArgumentException if {@code G} is {@code null}
     */
    public Graph(Graph graph) {
        this.vertexSize = graph.vertexSize();
        this.edgeSize = graph.edgeSize();
        if (vertexSize < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");

        // update adjacency lists
        adj = (Bag<Integer>[]) new Bag[vertexSize];
        for (int v = 0; v < vertexSize; v++) {
            adj[v] = new LinkBag<>();
        }

        for (int v = 0; v < graph.vertexSize(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<>();
            for (int w : graph.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }

    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int vertexSize() {
        return vertexSize;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int edgeSize() {
        return edgeSize;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= vertexSize)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (vertexSize -1));
    }

    /**
     * Adds the undirected edge v-w to this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        edgeSize++;
        adj[v].add(w);
        adj[w].add(v);
    }


    /**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> getNeighborsFor(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }


    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertexSize + " vertices, " + edgeSize + " edges \n ");
        for (int v = 0; v < vertexSize; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
