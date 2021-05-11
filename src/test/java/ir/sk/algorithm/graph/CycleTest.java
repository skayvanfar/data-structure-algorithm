package ir.sk.algorithm.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CycleTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void hasCycle() {
        Graph graph = new Graph(6);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        Cycle finder = new Cycle(graph);
        System.out.println(finder.hasCycle());
    }
}