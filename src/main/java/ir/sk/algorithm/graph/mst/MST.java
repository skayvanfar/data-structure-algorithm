package ir.sk.algorithm.graph.mst;

import ir.sk.algorithm.graph.Edge;

/**
 * Minimum spanning tree api
 *
 *  Recall that a spanning tree of a graph is a
 *  connected subgraph with no cycles that includes all
 *  the vertices. A minimum spanning tree (MST ) of an
 *  edge-weighted graph is a spanning tree whose weight
 *  (the sum of the weights of its edges) is no larger than
 *  the weight of any other spanning tree.
 */
public interface MST {

    /**
     * all of the MST edges
     */
    Iterable<Edge> edges();

    /**
     * weight of MST
     */
    double weight();

}
