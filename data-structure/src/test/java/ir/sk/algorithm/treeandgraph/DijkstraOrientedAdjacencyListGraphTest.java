package ir.sk.algorithm.treeandgraph;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/18/2020.
 */
public class DijkstraOrientedAdjacencyListGraphTest {

    @Test
    public void dijkstraShortestPath() {

    }

    @Test
    public void whenSPPSolved_thenCorrect() {

        Vertix nodeA = new Vertix("A");
        Vertix nodeB = new Vertix("B");
        Vertix nodeC = new Vertix("C");
        Vertix nodeD = new Vertix("D");
        Vertix nodeE = new Vertix("E");
        Vertix nodeF = new Vertix("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        DijkstraOrientedAdjacencyListGraph graph = new DijkstraOrientedAdjacencyListGraph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph.dijkstraShortestPath(nodeA);

        List<Vertix> shortestPathForNodeB = Arrays.asList(nodeA);
        List<Vertix> shortestPathForNodeC = Arrays.asList(nodeA);
        List<Vertix> shortestPathForNodeD = Arrays.asList(nodeA, nodeB);
        List<Vertix> shortestPathForNodeE = Arrays.asList(nodeA, nodeB, nodeD);
        List<Vertix> shortestPathForNodeF = Arrays.asList(nodeA, nodeB, nodeD);

        for (Vertix node : graph.getVertices()) {
            switch (node.getName()) {
                case "B":
                    assertTrue(node
                            .getShortestPath()
                            .equals(shortestPathForNodeB));
                    break;
                case "C":
                    assertTrue(node
                            .getShortestPath()
                            .equals(shortestPathForNodeC));
                    break;
                case "D":
                    assertTrue(node
                            .getShortestPath()
                            .equals(shortestPathForNodeD));
                    break;
                case "E":
                    assertTrue(node
                            .getShortestPath()
                            .equals(shortestPathForNodeE));
                    break;
                case "F":
                    assertTrue(node
                            .getShortestPath()
                            .equals(shortestPathForNodeF));
                    break;
            }
        }
    }

    @Test
    public void dijkstraShortestPathSingleSourceSingleTarget() {
    }
}