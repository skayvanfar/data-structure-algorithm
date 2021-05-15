package ir.sk.algorithm.graph.shortestpath;

import ir.sk.algorithm.graph.DirectedEdge;
import ir.sk.algorithm.graph.EdgeWeightedDigraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BellmanFordSPTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void pathTo() {
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(5);
        graph.addEdge(new DirectedEdge(0, 1, 1));
        graph.addEdge(new DirectedEdge(0, 2, 2));
        graph.addEdge(new DirectedEdge(1, 3, 3));
        graph.addEdge(new DirectedEdge(2, 3, 4));

        BellmanFordSP sp = new BellmanFordSP(graph, 0);

        // print negative cycle
        if (sp.hasNegativeCycle()) {
            for (DirectedEdge e : sp.negativeCycle())
                System.out.println(e);
        }

        // print shortest paths
        else {
            for (int v = 0; v < graph.vertexSize(); v++) {
                if (sp.hasPathTo(v)) {
                    System.out.printf("%d to %d (%5.2f)  ", 0, v, sp.distTo(v));
                    for (DirectedEdge e : sp.pathTo(v)) {
                        System.out.print(e + "   ");
                    }
                    System.out.println();
                }
                else {
                    System.out.printf("%d to %d           no path\n", 0, v);
                }
            }
        }
    }
}