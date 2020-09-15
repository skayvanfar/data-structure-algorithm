package ir.sk.algorithm.treeandgraph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by sad.kayvanfar on 9/15/2020.
 */
public class TopologicalSortTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void givenDirectedGraph_whenDFS_thenPrintAllValues() {
        TopologicalSort graph = createDirectedGraph();
        graph.dfs(0);
        System.out.println();
        graph.dfsWithoutRecursion(0);
    }

    @Test
    public void givenDirectedGraph_whenGetTopologicalSort_thenPrintValuesSorted() {
        TopologicalSort graph = createDirectedGraph();
        List<Integer> list = graph.topologicalSortByDFS(0);
        System.out.println(list);
    }

    private TopologicalSort createDirectedGraph() {
        TopologicalSort graph = new TopologicalSort();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        return graph;
    }
}