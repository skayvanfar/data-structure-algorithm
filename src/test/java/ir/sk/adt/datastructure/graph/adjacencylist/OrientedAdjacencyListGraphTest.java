package ir.sk.adt.datastructure.graph.adjacencylist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="sad.keyvanfar@gmail.com">Saeed Kayvanfar</a> on 7/11/2020.
 */
public class OrientedAdjacencyListGraphTest {

    private OrientedAdjacencyListGraph<String> graph;

    @Before
    public void setUp() throws Exception {
        graph = new OrientedAdjacencyListGraph<>();
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
    public void getNeighborsFor() {
    }

    @Test
    public void depthSearch() {
    }

    @Test
    public void breathSearch() {
    }
}