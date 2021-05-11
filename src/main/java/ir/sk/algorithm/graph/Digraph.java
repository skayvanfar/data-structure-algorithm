package ir.sk.algorithm.graph;

import ir.sk.adt.bag.Bag;
import ir.sk.adt.bag.LinkBag;

/**
 * A directed graph (or digraph) is a set of vertices and a collection of directed edges.
 * Each directed edge connects an ordered pair of vertices.
 */
public class Digraph {
    private final int vertexSize;
    private int edgeSize;
    private Bag<Integer>[] adj;

    public Digraph(int vertexSize) {
        this.vertexSize = vertexSize;
        this.edgeSize = 0;
        adj = (Bag<Integer>[]) new Bag[vertexSize];
        for (int v = 0; v < vertexSize; v++)
            adj[v] = new LinkBag<>();
    }

    public int vertexSize() {
        return vertexSize;
    }

    public int edgeSize() {
        return edgeSize;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        edgeSize++;
    }

    public Iterable<Integer> getNeighborsFor(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(vertexSize);
        for (int v = 0; v < vertexSize; v++)
            for (int w : getNeighborsFor(v))
                R.addEdge(w, v);
        return R;
    }

}
