package ir.sk.algorithm.graph.mst;

import ir.sk.adt.queue.LinkQueue;
import ir.sk.adt.queue.Queue;
import ir.sk.algorithm.graph.Edge;
import ir.sk.algorithm.graph.EdgeWeightedGraph;
import ir.sk.adt.set.disjointset.QuickUnionDisjointSet;
import ir.sk.adt.set.disjointset.DisjointSet;
import ir.sk.helper.technique.GreedyAlgorithm;

import java.util.Arrays;

/**
 *  The {@code KruskalMST} class represents a data type for computing a
 *  <em>minimum spanning tree</em> in an edge-weighted graph.
 *  The edge weights can be positive, zero, or negative and need not
 *  be distinct. If the graph is not connected, it computes a <em>minimum
 *  spanning forest</em>, which is the union of minimum spanning trees
 *  in each connected component. The {@code weight()} method returns the
 *  weight of a minimum spanning tree and the {@code edges()} method
 *  returns its edges.
 *  <p>
 *  This implementation uses <em>Krusal's algorithm</em> and the
 *  union-find data type.
 *  The constructor takes &Theta;(<em>E</em> log <em>E</em>) time in
 *  the worst case.
 *  Each instance method takes &Theta;(1) time.
 *  It uses &Theta;(<em>E</em>) extra space (not including the graph).
 *  <p>
 *  This {@code weight()} method correctly computes the weight of the MST
 *  if all arithmetic performed is without floating-point rounding error
 *  or arithmetic overflow.
 *  This is the case if all edge weights are non-negative integers
 *  and the weight of the MST does not exceed 2<sup>52</sup>.
 */
@GreedyAlgorithm
public class KruskalMST implements MST {
    private static final double FLOATING_POINT_EPSILON = 1E-12;

    private double weight;                        // weight of MST
    private Queue<Edge> mst = new LinkQueue<>();  // edges in MST

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     * @param G the edge-weighted graph
     */
    public KruskalMST(EdgeWeightedGraph G) {

        // create array of edges, sorted by weight
        Edge[] edges = new Edge[G.edgeSize()];
        int t = 0;
        for (Edge e: G.edges()) {
            edges[t++] = e;
        }
        Arrays.sort(edges);

        // run greedy algorithm
        DisjointSet disjointSet = new QuickUnionDisjointSet(G.vertexSize());
        for (int i = 0; i < G.edgeSize() && mst.size() < G.vertexSize() - 1; i++) {
            Edge e = edges[i];
            int v = e.either();
            int w = e.other(v);

            // v-w does not create a cycle
            if (disjointSet.find(v) != disjointSet.find(w)) {
                disjointSet.union(v, w);     // merge v and w components
                mst.enqueue(e);     // add edge e to mst
                weight += e.weight();
            }
        }

        // check optimality conditions
        assert check(G);
    }

    /**
     * Returns the edges in a minimum spanning tree (or forest).
     * @return the edges in a minimum spanning tree (or forest) as
     *    an iterable of edges
     */
    public Iterable<Edge> edges() {
        return mst;
    }

    /**
     * Returns the sum of the edge weights in a minimum spanning tree (or forest).
     * @return the sum of the edge weights in a minimum spanning tree (or forest)
     */
    public double weight() {
        return weight;
    }

    // check optimality conditions (takes time proportional to E V lg* V)
    private boolean check(EdgeWeightedGraph G) {

        // check total weight
        double total = 0.0;
        for (Edge e : edges()) {
            total += e.weight();
        }
        if (Math.abs(total - weight()) > FLOATING_POINT_EPSILON) {
            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", total, weight());
            return false;
        }

        // check that it is acyclic
        DisjointSet disjointSet = new QuickUnionDisjointSet(G.vertexSize());
        for (Edge e : edges()) {
            int v = e.either(), w = e.other(v);
            if (disjointSet.find(v) == disjointSet.find(w)) {
                System.err.println("Not a forest");
                return false;
            }
            disjointSet.union(v, w);
        }

        // check that it is a spanning forest
        for (Edge e : G.edges()) {
            int v = e.either(), w = e.other(v);
            if (disjointSet.find(v) != disjointSet.find(w)) {
                System.err.println("Not a spanning forest");
                return false;
            }
        }

        // check that it is a minimal spanning forest (cut optimality conditions)
        for (Edge e : edges()) {

            // all edges in MST except e
            disjointSet = new QuickUnionDisjointSet(G.vertexSize());
            for (Edge f : mst) {
                int x = f.either(), y = f.other(x);
                if (f != e) disjointSet.union(x, y);
            }

            // check that e is min weight edge in crossing cut
            for (Edge f : G.edges()) {
                int x = f.either(), y = f.other(x);
                if (disjointSet.find(x) != disjointSet.find(y)) {
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
