package ir.sk.algorithm.graph.Shortestpath;

import ir.sk.algorithm.graph.DirectedEdge;
import ir.sk.algorithm.graph.Edge;
import ir.sk.algorithm.graph.EdgeWeightedDigraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DijkstraSPTest {

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

        // compute shortest paths
        DijkstraSP sp = new DijkstraSP(graph, 0);

        // print shortest path
        for (int t = 0; t < graph.vertexSize(); t++) {
            if (sp.hasPathTo(t)) {
                System.out.printf("%d to %d (%.2f)  ", 0, t, sp.distTo(t));
                for (DirectedEdge e : sp.pathTo(t)) {
                    System.out.print(e + "   ");
                }
                System.out.println();
            }
            else {
                System.out.printf("%d to %d         no path\n", 0, t);
            }
        }
    }
}