package ir.sk.datastructure.fundamental.graph.adjacencylist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by sad.keyvanfar on 7/1/2020.
 */
public class AdjacencyListGraphTest {

    private AdjacencyListGraph graph;

    @Before
    public void setUp() throws Exception {
        graph = new AdjacencyListGraph(false);
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

    @Test
    public void depthFirstSearchRecursive() {
        AdjacencyListGraph<Integer> graph = createDirectedGraph();
        System.out.println(Arrays.toString(new Collection[]{graph.depthFirstSearchRecursive(0)}));
    }

    @Test
    public void topologicalSort() {
        AdjacencyListGraph<Integer> graph = createDirectedGraph();
        List<Integer> list = graph.topologicalSort(0);
        System.out.println(list);
    }

    private AdjacencyListGraph<Integer> createDirectedGraph() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true);
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 1);
        graph.addEdge(4, 5, 1);
        return graph;
    }

}