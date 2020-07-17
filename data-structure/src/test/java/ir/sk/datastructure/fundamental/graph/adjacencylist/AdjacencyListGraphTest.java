package ir.sk.datastructure.fundamental.graph.adjacencylist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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

    @Test
    public void dagShortestPath() {
        AdjacencyListGraph<Character> graph = createDirectedWeightedGraph();
        Map<Vertex<Character>, Vertex<Character>> map = graph.dagShortestPath('B');
        System.out.println(map);
        printDistance(map);
    }

    private AdjacencyListGraph<Character> createDirectedWeightedGraph() {
        AdjacencyListGraph<Character> graph = new AdjacencyListGraph<>(true);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addEdge('A', 'B', 5);
        graph.addEdge('A', 'C', 3);
        graph.addEdge('B', 'C', 2);
        graph.addEdge('B', 'D', 6);
        graph.addEdge('C', 'D', 7);
        graph.addEdge('C', 'E', 4);
        graph.addEdge('C', 'F', 2);
        graph.addEdge('D', 'E', -1);
        graph.addEdge('D', 'F', 1);
        graph.addEdge('E', 'F', -2);

        return graph;
    }

    private <T> void printDistance(Map<Vertex<T>, Vertex<T>> vertexMap) {
        for (Vertex<T> key : vertexMap.keySet()) {
            Vertex<T> value = vertexMap.get(key);
            System.out.println(key.toString() + "->" + value);
        }
    }
}