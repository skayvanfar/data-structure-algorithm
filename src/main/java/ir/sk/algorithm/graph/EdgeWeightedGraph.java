package ir.sk.algorithm.graph;

import ir.sk.adt.bag.Bag;
import ir.sk.adt.bag.LinkBag;
import ir.sk.adt.stack.ResizingArrayStack;
import ir.sk.adt.stack.Stack;

/**
 *  The {@code EdgeWeightedGraph} class represents an edge-weighted
 *  graph of vertices named 0 through <em>V</em> – 1, where each
 *  undirected edge is of type {@link Edge} and has a real-valued weight.
 *  It supports the following two primary operations: add an edge to the graph,
 *  iterate over all of the edges incident to a vertex. It also provides
 *  methods for returning the degree of a vertex, the number of vertices
 *  <em>V</em> in the graph, and the number of edges <em>E</em> in the graph.
 *  Parallel edges and self-loops are permitted.
 *  By convention, a self-loop <em>v</em>-<em>v</em> appears in the
 *  adjacency list of <em>v</em> twice and contributes two to the degree
 *  of <em>v</em>.
 *  <p>
 *  This implementation uses an <em>adjacency-lists representation</em>, which
 *  is a vertex-indexed array of {@link Bag} objects.
 *  It uses &Theta;(<em>E</em> + <em>V</em>) space, where <em>E</em> is
 *  the number of edges and <em>V</em> is the number of vertices.
 *  All instance methods take &Theta;(1) time. (Though, iterating over
 *  the edges returned by {@link #getNeighborsFor(int)} takes time proportional
 *  to the degree of the vertex.)
 *  Constructing an empty edge-weighted graph with <em>V</em> vertices takes
 *  &Theta;(<em>V</em>) time; constructing a edge-weighted graph with
 *  <em>E</em> edges and <em>V</em> vertices takes
 *  &Theta;(<em>E</em> + <em>V</em>) time.
 */
public class EdgeWeightedGraph {

    private static final String NEWLINE = System.getProperty("line.separator");

    private final int vertexSize;
    private int edgeSize;
    private Bag<Edge>[] adj;

    /**
     * Initializes an empty edge-weighted graph with {@code V} vertices and 0 edges.
     *
     * @param  vertexSize the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public EdgeWeightedGraph(int vertexSize) {
        if (vertexSize < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.vertexSize = vertexSize;
        this.edgeSize = 0;
        adj = (Bag<Edge>[]) new Bag[vertexSize];
        for (int v = 0; v < vertexSize; v++) {
            adj[v] = new LinkBag<>();
        }
    }

    /**
     * Initializes a new edge-weighted graph that is a deep copy of {@code G}.
     *
     * @param  G the edge-weighted graph to copy
     */
    public EdgeWeightedGraph(EdgeWeightedGraph G) {
        this(G.vertexSize());
        this.edgeSize = G.edgeSize();
        for (int v = 0; v < G.vertexSize(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Edge> reverse = new ResizingArrayStack<>();
            for (Edge e : G.adj[v]) {
                reverse.push(e);
            }
            for (Edge e : reverse) {
                adj[v].add(e);
            }
        }
    }


    /**
     * Returns the number of vertices in this edge-weighted graph.
     *
     * @return the number of vertices in this edge-weighted graph
     */
    public int vertexSize() {
        return vertexSize;
    }

    /**
     * Returns the number of edges in this edge-weighted graph.
     *
     * @return the number of edges in this edge-weighted graph
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
     * Adds the undirected edge {@code e} to this edge-weighted graph.
     *
     * @param  e the edge
     * @throws IllegalArgumentException unless both endpoints are between {@code 0} and {@code V-1}
     */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        edgeSize++;
    }

    /**
     * Returns the edges incident on vertex {@code v}.
     *
     * @param  v the vertex
     * @return the edges incident on vertex {@code v} as an Iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Edge> getNeighborsFor(int v) {
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
     * Returns all edges in this edge-weighted graph.
     * To iterate over the edges in this edge-weighted graph, use foreach notation:
     * {@code for (Edge e : G.edges())}.
     *
     * @return all edges in this edge-weighted graph, as an iterable
     */
    public Iterable<Edge> edges() {
        Bag<Edge> list = new LinkBag<>();
        for (int v = 0; v < vertexSize; v++) {
            int selfLoops = 0;
            for (Edge e : getNeighborsFor(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // add only one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }

    /**
     * Returns a string representation of the edge-weighted graph.
     * This method takes time proportional to <em>E</em> + <em>V</em>.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists of edges
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertexSize + " " + edgeSize + NEWLINE);
        for (int v = 0; v < vertexSize; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
