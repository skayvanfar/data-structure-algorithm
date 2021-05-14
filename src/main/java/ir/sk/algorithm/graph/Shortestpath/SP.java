package ir.sk.algorithm.graph.Shortestpath;

import ir.sk.algorithm.graph.DirectedEdge;

public interface SP {
    /**
     * distance from s to v, ∞ if no path
     */
    double distTo(int v);

    /**
     * path from s to v?
     */
    boolean hasPathTo(int v);

    /**
     * path from s to v,
     * null if none
     */
    Iterable<DirectedEdge> pathTo(int v);
}
