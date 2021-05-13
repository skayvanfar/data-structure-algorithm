package ir.sk.algorithm.graph;

/**
 * Reverse postorder in a DAG is a topological sort.
 */
public class Topological {

    private Iterable<Integer> order;

    // topological order
    public Topological(Digraph G) {
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle()) {
            DFSOrder dfs = new DFSOrder(G);
            order = dfs.reversePostOrder();
        }
    }

    /**
     * Returns a topological order if the digraph has a topologial order,
     * and {@code null} otherwise.
     * @return a topological order of the vertices (as an interable) if the
     *    digraph has a topological order (or equivalently, if the digraph is a DAG),
     *    and {@code null} otherwise
     */
    public Iterable<Integer> order() {
        return order;
    }

    /**
     * Does the digraph have a topological order?
     * @return {@code true} if the digraph has a topological order (or equivalently,
     *    if the digraph is a DAG), and {@code false} otherwise
     */
    public boolean isDAG() {
        return order == null;
    }

}
