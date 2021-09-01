package ir.sk.algorithm.graph.mst;

import ir.sk.adt.queue.LinkQueue;
import ir.sk.adt.queue.Queue;
import ir.sk.algorithm.graph.Edge;
import ir.sk.algorithm.graph.EdgeWeightedGraph;
import ir.sk.adt.set.unionfind.QuickUnionUF;
import ir.sk.adt.set.unionfind.UF;
import ir.sk.helper.technique.GreedyAlgorithm;

import java.util.PriorityQueue;

/**
 * Compute a minimum spanning forest using a lazy version of Prim's algorithm.
 *
 * The {@code LazyPrimMST} class represents a data type for computing a
 * <em>minimum spanning tree</em> in an edge-weighted graph.
 * The edge weights can be positive, zero, or negative and need not
 * be distinct. If the graph is not connected, it computes a <em>minimum
 * spanning forest</em>, which is the union of minimum spanning trees
 * in each connected component. The {@code weight()} method returns the
 * weight of a minimum spanning tree and the {@code edges()} method
 * returns its edges.
 * <p>
 * This implementation uses a lazy version of <em>Prim's algorithm</em>
 * with a binary heap of edges.
 * The constructor takes &Theta;(<em>E</em> log <em>E</em>) time in
 * the worst case, where <em>V</em> is the number of vertices and
 * <em>E</em> is the number of edges.
 * Each instance method takes &Theta;(1) time.
 * It uses &Theta;(<em>E</em>) extra space in the worst case
 * (not including the edge-weighted graph).
 */
@GreedyAlgorithm
public class LazyPrimMST implements MST {

    private static final double FLOATING_POINT_EPSILON = 1E-12;

    private double weight;       // total weight of MST
    private Queue<Edge> mst;     // MST edges
    private boolean[] visited;   // MST vertices
    private PriorityQueue<Edge> priorityQueue;    // crossing (and ineligible) edges. edges with one endpoint in tree

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     * @param graph the edge-weighted graph
     */
    public LazyPrimMST(EdgeWeightedGraph graph) {
        mst = new LinkQueue<>();
        priorityQueue = new PriorityQueue<>();
        visited = new boolean[graph.vertexSize()];
        for (int v = 0; v < graph.vertexSize(); v++)     // run Prim from all vertices to
            if (!visited[v]) prim(graph, v);     // get a minimum spanning forest

        // check optimality conditions
        assert check(graph);
    }

    // run Prim's algorithm
    private void prim(EdgeWeightedGraph graph, int s) {
        scan(graph, s);
        while (!priorityQueue.isEmpty()) {                        // better to stop when mst has V-1 edges
            Edge e = priorityQueue.poll();                      // smallest edge on pq
            int v = e.either(), w = e.other(v);        // two endpoints
            assert visited[v] || visited[w];
            if (visited[v] && visited[w]) continue;      // lazy, both v and w already scanned
            mst.enqueue(e);                            // add e to MST
            weight += e.weight();
            if (!visited[v]) scan(graph, v);               // v becomes part of tree
            if (!visited[w]) scan(graph, w);               // w becomes part of tree
        }
    }

    // add all edges e incident to v onto pq if the other endpoint has not yet been scanned
    private void scan(EdgeWeightedGraph graph, int v) {
        assert !visited[v];
        visited[v] = true;
        for (Edge e : graph.getNeighborsFor(v))
            if (!visited[e.other(v)]) priorityQueue.add(e);
    }

    /**
     * Returns the edges in a minimum spanning tree (or forest).
     * @return the edges in a minimum spanning tree (or forest) as
     *    an iterable of edges
     */
    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    /**
     * Returns the sum of the edge weights in a minimum spanning tree (or forest).
     * @return the sum of the edge weights in a minimum spanning tree (or forest)
     */
    @Override
    public double weight() {
        return weight;
    }

    // check optimality conditions (takes time proportional to E V lg* V)
    private boolean check(EdgeWeightedGraph graph) {

        // check weight
        double totalWeight = 0.0;
        for (Edge e : edges()) {
            totalWeight += e.weight();
        }
        if (Math.abs(totalWeight - weight()) > FLOATING_POINT_EPSILON) {
            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", totalWeight, weight());
            return false;
        }

        // check that it is acyclic
        UF uf = new QuickUnionUF(graph.vertexSize());
        for (Edge e : edges()) {
            int v = e.either(), w = e.other(v);
            if (uf.find(v) == uf.find(w)) {
                System.err.println("Not a forest");
                return false;
            }
            uf.union(v, w);
        }

        // check that it is a spanning forest
        for (Edge e : graph.edges()) {
            int v = e.either(), w = e.other(v);
            if (uf.find(v) != uf.find(w)) {
                System.err.println("Not a spanning forest");
                return false;
            }
        }

        // check that it is a minimal spanning forest (cut optimality conditions)
        for (Edge e : edges()) {

            // all edges in MST except e
            uf = new QuickUnionUF(graph.vertexSize());
            for (Edge f : mst) {
                int x = f.either(), y = f.other(x);
                if (f != e) uf.union(x, y);
            }

            // check that e is min weight edge in crossing cut
            for (Edge f : graph.edges()) {
                int x = f.either(), y = f.other(x);
                if (uf.find(x) != uf.find(y)) {
                    if (f.weight() < e.weight()) {
                        System.err.println("Edge " + f + " violates cut optimality conditions");
                        return false;
                    }
                }
            }

        }

        return true;
    }
}
