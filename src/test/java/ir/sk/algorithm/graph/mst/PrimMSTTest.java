package ir.sk.algorithm.graph.mst;

import ir.sk.algorithm.graph.Edge;
import ir.sk.algorithm.graph.EdgeWeightedGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimMSTTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void edges() {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(5);
        graph.addEdge(new Edge(0, 1, 1));
        graph.addEdge(new Edge(0, 2, 2));
        graph.addEdge(new Edge(1, 3, 3));
        graph.addEdge(new Edge(2, 3, 4));
        PrimMST mst = new PrimMST(graph);
        for (Edge e : mst.edges()) {
            System.out.println(e);
        }
        System.out.printf("%.5f\n", mst.weight());
    }

    @Test
    public void weight() {
    }
}