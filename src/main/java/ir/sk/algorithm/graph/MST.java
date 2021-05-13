package ir.sk.algorithm.graph;

/**
 * Minimum spanning tree api
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
