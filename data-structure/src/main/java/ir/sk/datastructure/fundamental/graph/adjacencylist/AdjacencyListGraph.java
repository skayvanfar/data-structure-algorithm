package ir.sk.datastructure.fundamental.graph.adjacencylist;

import ir.sk.datastructure.fundamental.graph.Graph;

import java.util.*;
import java.util.stream.Collectors;

/**
 * An adjacency list is nothing but an array of lists. The size of the array is equivalent to the number of vertices in the graph.
 * The list at a specific index of the array represents the adjacent vertices of the vertex represented by that array index.
 *
 * An implementation suggested by Guido van Rossum uses a hash table to associate each vertex in a graph with an array of adjacent vertices.
 * In this representation, a vertex may be represented by any hashable object.
 * There is no explicit representation of edges as objects.
 *
 * Space Complexity: O(V+E)
 * Created by sad.keyvanfar on 7/1/2020.
 */
public class AdjacencyListGraph<T> implements Graph<T> {

    /**
     * Could be replaced by array
     */
    private Map<Vertex<T>, List<Vertex<T>>> adjVertices;

    public AdjacencyListGraph() {
        this.adjVertices = new HashMap<>();
    }

    public boolean contains(T vertex) {
        return adjVertices.containsKey(vertex);
    }

    /**
     * Time Complexity: O(1)
     *
     * @param info
     */
    public void addVertex(T info) {
        adjVertices.putIfAbsent(new Vertex(info), new ArrayList<>());
    }

    @Override
    public boolean areAdjacent(T src, T dest) throws Exception { // TODO: 7/12/2020

        return adjVertices.get(src).contains(dest);
    }

    /**
     * Time Complexity: O(|E|)
     *
     * @param info
     */
    public void removeVertex(T info) {
        Vertex<T> v = new Vertex<>(info);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex<>(info));
    }

    /**
     * Time Complexity: O(1)
     *
     * @param from
     * @param to
     */
    public void addEdge(T from, T to, int weight) { // TODO: 7/12/2020
        Vertex<T> v1 = new Vertex<>(from);
        Vertex<T> v2 = new Vertex<>(to);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    /**
     * Time Complexity: O(|V|)
     *
     * @param from
     * @param to
     */
    public void removeEdge(T from, T to) {
        Vertex v1 = new Vertex(from);
        Vertex v2 = new Vertex(to);
        List<Vertex<T>> eV1 = adjVertices.get(v1);
        List<Vertex<T>> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    @Override
    public List<T> getNeighborsFor(T info) {

        return adjVertices.get(new Vertex(info)).stream().map(tVertex -> tVertex.info).collect(Collectors.toList());
    }

    public List<Vertex<T>> getAdjVertices(T info) {
        return adjVertices.get(new Vertex(info));
    }

    public String printGraph() {
        StringBuffer sb = new StringBuffer();
        for (Vertex<T> v : adjVertices.keySet()) {
            sb.append(v);
            sb.append(adjVertices.get(v));
        }
        return sb.toString();
    }

    /**
     *
     * Time Complexity: O(|V|+|E|) Linear Time
     * Space Complexity: O(w) w is the maximum width of the tree
     *
     * @param start
     * @return
     */
    @Override
    public Collection<T> breathFirstSearch(T start) {
        Collection<T> visited = new LinkedHashSet<>();
        Queue<T> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            T info = queue.poll();
            for (Vertex<T> v : getAdjVertices(info)) {
                if (!visited.contains(v.info)) {
                    visited.add(v.info);
                    queue.add(v.info);
                }
            }
        }
        return visited;
    }

    /**
     * Time Complexity: O(|V|+|E|) Linear Time
     * Space Complexity: O(h) h is the maximum height of the tree
     *
     * @param start
     * @return
     */
    @Override
    public Collection<T> depthFirstSearch(T start) {
        Collection<T> visited = new LinkedHashSet<>();
        Stack<T> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            T info = stack.pop();
            if (!visited.contains(info)) {
                visited.add(info);
                for (Vertex<T> v : getAdjVertices(info)) {
                    stack.push(v.info);
                }
            }
        }
        return visited;
    }

    /**
     * @param start
     */
    public void depthFirstSearchRecursive(T start) {
        Collection<T> visited = new LinkedHashSet<>();
        dfsRecursive(start, visited);
    }

    private void dfsRecursive(T current, Collection<T> visited) {
        visited.add(current);
        System.out.println(current);
        for (T dest : getNeighborsFor(current)) {
            if (!visited.contains(dest))
                dfsRecursive(dest, visited);
        }
    }

    /**
     * One of the famous applications for DFS is Topological Sort.
     * Topological Sort for a directed graph is a linear ordering of its vertices so that for every edge the source node comes before the destination.
     *
     * Time Complexity: O(|V|+|E|)
     * Auxiliary space: O(|V|)
     *
     * @param start
     * @return
     */
    public List<T> topologicalSort(T start) {
        LinkedList<T> result = new LinkedList<>();
        Collection<T> visited = new LinkedHashSet<>();
        topologicalSortRecursive(start, visited, result);
        return result;
    }

    private void topologicalSortRecursive(T current, Collection<T> visited, LinkedList<T> result) {
        visited.add(current);
        for (T dest : getNeighborsFor(current)) {
            if (!visited.contains(dest))
                topologicalSortRecursive(dest, visited, result);
        }
        result.addFirst(current);
    }

}

class Vertex<T> {

    T info;

    Vertex(T info) {
        this.info = info;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        //  result = prime * result + getOuterType().hashCode();
        result = prime * result + ((info == null) ? 0 : info.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
       /* if (!getOuterType().equals(other.getOuterType()))
            return false;*/
        if (info == null) {
            if (other.info != null)
                return false;
        } else if (!info.equals(other.info))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return info.toString();
    }


   /* private AdjacencyListGraph getOuterType() {
        return AdjacencyListGraph.this;
    }*/
}
