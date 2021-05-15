package ir.sk.algorithm.graph.topological;

/**
 * Reverse postorder in a DAG is a topological sort.
 * Compute topological ordering of a DAG or edge-weighted DAG.
 * Runs in O(E + V) time.
 */

import ir.sk.algorithm.graph.DepthFirstOrder;
import ir.sk.algorithm.graph.Digraph;
import ir.sk.algorithm.graph.EdgeWeightedDigraph;
import ir.sk.algorithm.graph.cycle.EdgeWeightedDirectedCycle;
import ir.sk.algorithm.graph.cycle.DirectedCycle;

/**
 *  The {@code Topological} class represents a data type for
 *  determining a topological order of a <em>directed acyclic graph</em> (DAG).
 *  A digraph has a topological order if and only if it is a DAG.
 *  The <em>hasOrder</em> operation determines whether the digraph has
 *  a topological order, and if so, the <em>order</em> operation
 *  returns one.
 *  <p>
 *  This implementation uses depth-first search.
 *  The constructor takes &Theta;(<em>V</em> + <em>E</em>) time in the
 *  worst case, where <em>V</em> is the number of vertices and <em>E</em>
 *  is the number of edges.
 *  Each instance method takes &Theta;(1) time.
 *  It uses &Theta;(<em>V</em>) extra space (not including the digraph).
 *  <p>
 *  See {@link DirectedCycle}, {@link DirectedCycleX}, and
 *  {@link EdgeWeightedDirectedCycle} for computing a directed cycle
 *  if the digraph is not a DAG.
 *  See {@link TopologicalX} for a nonrecursive queue-based algorithm
 *  for computing a topological order of a DAG.
 */
public class Topological {

    private Iterable<Integer> order;  // topological order
    private int[] rank;               // rank[v] = rank of vertex v in order

    /**
     * Determines whether the digraph {@code G} has a topological order and, if so,
     * finds such a topological order.
     * @param G the digraph
     */
    public Topological(Digraph G) {
        DirectedCycle finder = new DirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
            rank = new int[G.vertexSize()];
            int i = 0;
            for (int v : order)
                rank[v] = i++;
        }
    }

    /**
     * Determines whether the edge-weighted digraph {@code G} has a topological
     * order and, if so, finds such an order.
     * @param G the edge-weighted digraph
     */
    public Topological(EdgeWeightedDigraph G) {
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
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
    public boolean hasOrder() {
        return order != null;
    }

    /**
     * Does the digraph have a topological order?
     * @return {@code true} if the digraph has a topological order (or equivalently,
     *    if the digraph is a DAG), and {@code false} otherwise
     * @deprecated Replaced by {@link #hasOrder()}.
     */
    @Deprecated
    public boolean isDAG() {
        return hasOrder();
    }

    /**
     * The the rank of vertex {@code v} in the topological order;
     * -1 if the digraph is not a DAG
     *
     * @param v the vertex
     * @return the position of vertex {@code v} in a topological order
     *    of the digraph; -1 if the digraph is not a DAG
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int rank(int v) {
        validateVertex(v);
        if (hasOrder()) return rank[v];
        else            return -1;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = rank.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

}
