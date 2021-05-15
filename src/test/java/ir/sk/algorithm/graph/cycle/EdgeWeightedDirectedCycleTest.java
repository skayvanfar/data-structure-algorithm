package ir.sk.algorithm.graph.cycle;

import ir.sk.algorithm.graph.DirectedEdge;
import ir.sk.algorithm.graph.EdgeWeightedDigraph;
import ir.sk.algorithm.graph.cycle.EdgeWeightedDirectedCycle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EdgeWeightedDirectedCycleTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void hasCycle() {
    }

    @Test
    public void cycle() {
        int V = 5;
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(V);

        graph.addEdge(new DirectedEdge(0, 1, 1));
        graph.addEdge(new DirectedEdge(0, 2, 2));
        graph.addEdge(new DirectedEdge(1, 3, 3));
        graph.addEdge(new DirectedEdge(2, 3, 4));

        // find a directed cycle
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(graph);
        if (finder.hasCycle()) {
            System.out.print("Cycle: ");
            for (DirectedEdge e : finder.cycle()) {
                System.out.print(e + " ");
            }
            System.out.println();
        }

        // or give topologial sort
        else {
            System.out.println("No directed cycle");
        }
    }
}