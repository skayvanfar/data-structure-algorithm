package ir.sk.datastructure.fundamental.graph;

import com.sun.corba.se.impl.orbutil.graph.Graph;
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
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void givenAGraph_whenTraversingDepthFirst_thenExpectedResult() {
        assertEquals("[Bob, Rob, Maria, Alice, Mark]",
                graph.depthFirstTraversal(graph, "Bob").toString());
    }

    @Test
    public void givenAGraph_whenTraversingBreadthFirst_thenExpectedResult() {
        assertEquals("[Bob, Alice, Rob, Mark, Maria]",
                graph.breadthFirstTraversal(graph, "Bob").toString());
    }

    @Test
    public void givenAGraph_whenRemoveVertex_thenVertedNotFound() {
        assertEquals("[Bob, Alice, Rob, Mark, Maria]",
                graph.breadthFirstTraversal(graph, "Bob").toString());

        graph.removeVertex("Maria");
        assertEquals("[Bob, Alice, Rob, Mark]",
                graph.breadthFirstTraversal(graph, "Bob").toString());
    }

}