package ir.sk.algorithm.graph;

/**
 * Minimum spanning tree api
 */
public interface MST {

    /**
     * all of the MST edges
     *
     * @return
     */
    Iterable<Edge> edges();

    /**
     * weight of MST
     * @return
     */
    double weight();

}
