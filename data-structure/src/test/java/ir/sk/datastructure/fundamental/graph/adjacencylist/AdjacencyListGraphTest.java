package ir.sk.datastructure.fundamental.graph.adjacencylist;

import ir.sk.datastructure.fundamental.graph.adjacencylist.AdjacencyListGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.keyvanfar on 7/1/2020.
 */
public class AdjacencyListGraphTest {

    private AdjacencyListGraph graph;

    @Before
    public void setUp() throws Exception {
        graph = new AdjacencyListGraph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice", 1);
        graph.addEdge("Bob", "Rob", 1);
        graph.addEdge("Alice", "Mark", 1);
        graph.addEdge("Rob", "Mark", 1);
        graph.addEdge("Alice", "Maria", 1);
        graph.addEdge("Rob", "Maria", 1);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void givenAGraph_whenTraversingDepthFirst_thenExpectedResult() {
        assertEquals("[Bob, Rob, Maria, Alice, Mark]",
                graph.depthFirstSearch("Bob").toString());
    }

    @Test
    public void givenAGraph_whenTraversingBreadthFirst_thenExpectedResult() {
        assertEquals("[Bob, Alice, Rob, Mark, Maria]",
                graph.breathFirstSearch("Bob").toString());
    }

    @Test
    public void givenAGraph_whenRemoveVertex_thenVertedNotFound() {
        assertEquals("[Bob, Alice, Rob, Mark, Maria]",
                graph.breathFirstSearch("Bob").toString());

        graph.removeVertex("Maria");
        assertEquals("[Bob, Alice, Rob, Mark]",
                graph.breathFirstSearch("Bob").toString());
    }

}