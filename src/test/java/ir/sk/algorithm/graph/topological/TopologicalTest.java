package ir.sk.algorithm.graph.topological;

import ir.sk.algorithm.graph.Digraph;
import ir.sk.algorithm.graph.topological.Topological;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TopologicalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void order() {
        Digraph digraph = new Digraph(4);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 2);
        digraph.addEdge(1, 3);
        digraph.addEdge(2, 3);
        Topological top = new Topological(digraph);
        for (int v : top.order())
            System.out.println(v);
    }

    @Test
    public void isDAG() {
    }
}