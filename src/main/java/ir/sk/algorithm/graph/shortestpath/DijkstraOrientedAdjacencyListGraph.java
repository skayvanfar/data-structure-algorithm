package ir.sk.algorithm.graph.shortestpath;

import ir.sk.helper.technique.GreedyAlgorithm;

import java.util.*;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/18/2020.
 */
@GreedyAlgorithm
public class DijkstraOrientedAdjacencyListGraph {

    private Set<Vertix> vertices = new HashSet<>();

    public void addNode(Vertix nodeA) {
        vertices.add(nodeA);
    }

    public Set<Vertix> getVertices() {
        return vertices;
    }

    public void setVertices(Set<Vertix> vertices) {
        this.vertices = vertices;
    }

    /**
     * The code can be used for undirected graph as well as directed graph
     * it cannot be used for negative weights
     * <p>
     * Set distance to startNode to zero.
     * Set all other distances to an infinite value.
     * We add the startNode to the unsettled nodes set.
     * While the unsettled nodes set is not empty we:
     * Choose an evaluation node from the unsettled nodes set, the evaluation node should be the one with the lowest distance from the source.
     * Calculate new distances to direct neighbors by keeping the lowest distance at each evaluation.
     * Add neighbors that are not yet settled to the unsettled nodes set.
     * <p>
     * Time complexity: O(v2), if using ArrayPriorityQueue
     * Time complexity: O(e log v), if using MinHeapPriorityQueue
     *
     * @param source
     */
    public void dijkstraShortestPath(Vertix source) {

        source.setDistance(0);

        Set<Vertix> settledVertexes = new HashSet<>();
        // it must be priority Queue
        Set<Vertix> unsettledVertexes = new HashSet<>();
        unsettledVertexes.add(source);

        while (unsettledVertexes.size() != 0) {
            Vertix currentVertex = getLowestDistanceNode(unsettledVertexes);
            unsettledVertexes.remove(currentVertex);
            for (Map.Entry<Vertix, Integer> adjacencyPair : currentVertex.getAdjacentVertexes().entrySet()) {
                // relaxation
                Vertix adjacentNode = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();

                if (!settledVertexes.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, edgeWeigh, currentVertex);
                    unsettledVertexes.add(adjacentNode);
                }
            }
            settledVertexes.add(currentVertex);
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
    public void dijkstraShortestPathSingleSourceSingleTarget(Vertix source, Vertix target) {

        source.setDistance(0);

        Set<Vertix> settledVertexes = new HashSet<>();
        // it must be priority Queue
        Set<Vertix> unsettledVertexes = new HashSet<>();
        unsettledVertexes.add(source);

        while (unsettledVertexes.size() != 0) {
            Vertix currentVertex = getLowestDistanceNode(unsettledVertexes);
            unsettledVertexes.remove(currentVertex);

            for (Map.Entry<Vertix, Integer> adjacencyPair : currentVertex.getAdjacentVertexes().entrySet()) {
                // relaxation
                Vertix adjacentVertex = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();

                if (!settledVertexes.contains(adjacentVertex)) {
                    CalculateMinimumDistance(adjacentVertex, edgeWeigh, currentVertex);
                    unsettledVertexes.add(adjacentVertex);
                }
            }
            settledVertexes.add(currentVertex);

            // If only shortest path from s to t is required, stop when t is removedfrom Q, i.e., when u = t
            if (currentVertex == target) {
                break;
            }
        }
    }

    /**
     * compares the actual distance with the newly calculated one while following the newly explored path
     *
     * @param evaluationVertex
     * @param edgeWeigh
     * @param sourceVertex
     */
    private void CalculateMinimumDistance(Vertix evaluationVertex, Integer edgeWeigh, Vertix sourceVertex) {
        Integer sourceDistance = sourceVertex.getDistance();
        if (sourceDistance + edgeWeigh < evaluationVertex.getDistance()) {
            evaluationVertex.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Vertix> shortestPath = new LinkedList<>(sourceVertex.getShortestPath());
            shortestPath.add(sourceVertex);
            evaluationVertex.setShortestPath(shortestPath);
        }
    }

    /**
     * returns the node with the lowest distance from the unsettled nodes set
     * <p>
     * It's better to use MinHeapPriorityQueue
     *
     * @param unsettledVertexes
     * @return
     */
    private Vertix getLowestDistanceNode(Set<Vertix> unsettledVertexes) {
        Vertix lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Vertix node : unsettledVertexes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
}

class Vertix {

    private String name;

    private LinkedList<Vertix> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    // cloud be replaced by an Edge object
    private Map<Vertix, Integer> adjacentVertexes = new HashMap<>();

    public Vertix(String name) {
        this.name = name;
    }

    public void addDestination(Vertix destination, int distance) {
        adjacentVertexes.put(destination, distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Vertix, Integer> getAdjacentVertexes() {
        return adjacentVertexes;
    }

    public void setAdjacentVertexes(Map<Vertix, Integer> adjacentVertexes) {
        this.adjacentVertexes = adjacentVertexes;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<Vertix> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(LinkedList<Vertix> shortestPath) {
        this.shortestPath = shortestPath;
    }

}
