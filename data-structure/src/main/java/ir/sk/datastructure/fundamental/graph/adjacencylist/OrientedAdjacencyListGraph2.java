package ir.sk.datastructure.fundamental.graph.adjacencylist;

import java.util.*;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/18/2020.
 */
public class OrientedAdjacencyListGraph2 {
    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * The code can be used for undirected graph as well as directed graph
     * it cannot be used for negative weights
     *
     * Set distance to startNode to zero.
     * Set all other distances to an infinite value.
     * We add the startNode to the unsettled nodes set.
     * While the unsettled nodes set is not empty we:
     * Choose an evaluation node from the unsettled nodes set, the evaluation node should be the one with the lowest distance from the source.
     * Calculate new distances to direct neighbors by keeping the lowest distance at each evaluation.
     * Add neighbors that are not yet settled to the unsettled nodes set.
     *
     * Time complexity: O(v2), if using ArrayPriorityQueue
     * Time complexity: O(e log v), if using MinHeapPriorityQueue
     *
     * @param source
     */
    public void dijkstraShortestPath(Node source) {

        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        // it must be priority Queue
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                // relaxation
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, edgeWeigh, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
    }

    /**
     * DIJKSTRA single-source, single-target
     * Speedup techniques covered here do not change worst-case behavior, but reduce
     * the number of visited vertices in practice.
     *
     * @param source
     * @param target
     */
    public void dijkstraShortestPathSingleSourceSingleTarget(Node source, Node target) {

        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        // it must be priority Queue
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);

            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                // relaxation
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, edgeWeigh, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);

            // If only shortest path from s to t is required, stop when t is removedfrom Q, i.e., when u = t
            if (currentNode == target) {
                break;
            }
        }
    }

    /**
     * compares the actual distance with the newly calculated one while following the newly explored path
     *
     * @param evaluationNode
     * @param edgeWeigh
     * @param sourceNode
     */
    private void CalculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    /**
     * returns the node with the lowest distance from the unsettled nodes set
     *
     * It's better to use MinHeapPriorityQueue
     *
     * @param unsettledNodes
     * @return
     */
    private Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
}

class Node {

    private String name;

    private LinkedList<Node> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    private Map<Node, Integer> adjacentNodes = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

}
