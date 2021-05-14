package ir.sk.algorithm.graph.Shortestpath;

import ir.sk.algorithm.graph.DirectedEdge;
import ir.sk.algorithm.graph.EdgeWeightedDigraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DijkstraAllPairsSPTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void path() {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(5);
        G.addEdge(new DirectedEdge(0, 1, 1));
        G.addEdge(new DirectedEdge(0, 2, 2));
        G.addEdge(new DirectedEdge(1, 3, 3));
        G.addEdge(new DirectedEdge(2, 3, 4));

        // compute shortest paths between all pairs of vertices
        DijkstraAllPairsSP spt = new DijkstraAllPairsSP(G);

        // print all-pairs shortest path distances
        System.out.printf("  ");
        for (int v = 0; v < G.vertexSize(); v++) {
            System.out.printf("%6d ", v);
        }
        System.out.println();
        for (int v = 0; v < G.vertexSize(); v++) {
            System.out.printf("%3d: ", v);
            for (int w = 0; w < G.vertexSize(); w++) {
                if (spt.hasPath(v, w)) System.out.printf("%6.2f ", spt.dist(v, w));
                else System.out.printf("  Inf ");
            }
            System.out.println();
        }
        System.out.println();

        // print all-pairs shortest paths
        for (int v = 0; v < G.vertexSize(); v++) {
            for (int w = 0; w < G.vertexSize(); w++) {
                if (spt.hasPath(v, w)) {
                    System.out.printf("%d to %d (%5.2f)  ", v, w, spt.dist(v, w));
                    for (DirectedEdge e : spt.path(v, w))
                        System.out.print(e + "  ");
                    System.out.println();
                }
                else {
                    System.out.printf("%d to %d no path\n", v, w);
                }
            }
        }
    }
}