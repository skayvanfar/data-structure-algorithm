package ir.sk.adt.datastructure.graph.adjacencylist;

import ir.sk.adt.datastructure.graph.Graph;
import ir.sk.helper.Point;
import ir.sk.helper.paradigm.BFS;

import java.util.*;

/**
 * simple oriented graph as part of an exercise in both Object Oriented Programming
 * and Data Structures.
 * <p>
 * The object oriented incidence list structure suggested by Goodrich and Tamassia has special classes of vertex objects and edge objects.
 * Each vertex object has an instance variable pointing to a collection object that lists the neighboring edge objects.
 * In turn, each edge object points to the two vertex objects at its endpoints.
 * This version of the adjacency list uses more memory than the version in which adjacent vertices are listed directly,
 * but the existence of explicit edge objects allows it extra flexibility in storing additional information about edges.
 * <p>
 * It represents Directed Wighted graph
 *
 * @author <a href="sad.keyvanfar@gmail.com">Saeid Keyvanfar</a> on 7/11/2020.
 */
public class OrientedAdjacencyListGraph<T> implements Graph<T> {

    /**
     * Could be replaced by array
     */
    // private OrientedVertex<T>[] graph;
    // private Set<OrientedVertex<T>> graph;
    @Point("Instead  of using Set, we use map so we can map between value and vertex easily")
    private Map<T, OrientedVertex<T>> graph;

    public OrientedAdjacencyListGraph() {
        graph = new HashMap<>();
    }

    public boolean contains(T vertex) {
        return graph.containsKey(vertex);
    }

    public boolean areAdjacent(T src, T dest) throws NoSuchVertexException {
        OrientedVertex<T> srcVertex = graph.get(src);
        OrientedVertex<T> destVertex = graph.get(dest);

        if (srcVertex == null || destVertex == null)
            throw new NoSuchVertexException();

        return srcVertex.hasNeighbor(destVertex);
    }

    public void addVertex(T info) {
        OrientedVertex<T> vertexNode = new OrientedVertex<>(info);
        graph.put(info, vertexNode);
    }

    public void removeVertex(T info) throws NoSuchVertexException {
        OrientedVertex<T> vertexNode = graph.get(info);

        if (vertexNode == null)
            throw new NoSuchVertexException();

        Iterator<OrientedVertex<T>> iterator = graph.values().iterator();
        while (iterator.hasNext()) {
            OrientedVertex<T> possibleLink = iterator.next();
            possibleLink.removeEdgeTo(vertexNode);
        }

        graph.remove(info);
    }

    public void addEdge(T from, T to, int weight) throws NoSuchVertexException {
        OrientedVertex<T> fromVertex = graph.get(from);
        OrientedVertex<T> toVertex = graph.get(to);

        if (fromVertex == null || toVertex == null)
            throw new NoSuchVertexException();

        Edge<T> edge = new Edge<>(fromVertex, toVertex, weight);
        fromVertex.addEdge(edge);
    }

    public void removeEdge(T from, T to) throws NoSuchVertexException {
        OrientedVertex<T> fromVertex = graph.get(from);
        OrientedVertex<T> toVertex = graph.get(to);

        if (fromVertex == null || toVertex == null)
            throw new NoSuchVertexException();

        if (fromVertex.hasNeighbor(toVertex)) {
            fromVertex.removeEdgeTo(toVertex);
        }
    }

    public List<T> getNeighborsFor(T vertex) throws NoSuchVertexException {
        if (graph.get(vertex) == null)
            throw new NoSuchVertexException();

        return graph.get(vertex).getNeighbors();
    }

    /**
     * @param start
     * @throws NoSuchVertexException
     */
    @Override
    @BFS
    public Collection<T> breathFirstSearch(T start) throws NoSuchVertexException {
        if (graph.get(start) == null)
            throw new NoSuchVertexException();

        Collection<T> visited = new HashSet<>();
        visited.add(start);

        Queue<T> queue = new ArrayDeque<>();
        queue.add(start);

        System.out.println(start);
        while (!queue.isEmpty()) {
            T current = queue.remove();
            T neighbor = null;
            Iterator<T> iterator = getNeighborsFor(current).iterator();

            while (iterator.hasNext()) {
                neighbor = iterator.next();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    System.out.println(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }

    /**
     * @param start
     * @throws NoSuchVertexException
     */
    @Override
    public Collection<T> depthFirstSearch(T start) throws NoSuchVertexException {
        if (graph.get(start) == null)
            throw new NoSuchVertexException();

        Collection<T> visited = new HashSet<>();
        visited.add(start);

        Stack<T> stack = new Stack<>();
        stack.push(start);

        System.out.println(start);
        while (!stack.empty()) {
            T current = stack.peek();
            T neighbor = null;
            Iterator<T> iterator = getNeighborsFor(current).iterator();

            while (iterator.hasNext()) {
                neighbor = iterator.next();
                if (!visited.contains(neighbor))
                    break;
            }

            if (neighbor != null && !visited.contains(neighbor)) {
                visited.add(neighbor);
                System.out.println(neighbor);
                stack.push(neighbor);
            } else {
                stack.pop();
            }
        }
        return visited;
    }

}

class OrientedVertex<T> implements Iterable<OrientedVertex<T>> {
    T info;
    ArrayList<Edge<T>> neighbors;

    OrientedVertex(T info) {
        this.info = info;
        neighbors = new ArrayList<>();
    }

    private Edge<T> getEdgeTo(OrientedVertex<T> target) {
        Iterator<Edge<T>> edges = neighbors.iterator();

        while (edges.hasNext()) {
            Edge<T> current = edges.next();
            if (current.dest().equals(target))
                return current;
        }

        return null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((info == null) ? 0 : info.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrientedVertex<T> other = (OrientedVertex<T>) obj;
        if (info == null) {
            if (other.info != null)
                return false;
        } else if (!info.equals(other.info))
            return false;
        return true;
    }

    @Override
    public Iterator<OrientedVertex<T>> iterator() {
        return new VertexIterator<T>(neighbors);
    }

    public void addEdge(Edge<T> edge) {
        if (neighbors.contains(edge))
            return;
        else {
            neighbors.add(edge);
        }
    }

    public boolean hasNeighbor(OrientedVertex<T> neighbor) {
        Iterator<OrientedVertex<T>> iterator = iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals(neighbor))
                return true;
        }

        return false;
    }

    public void removeEdgeTo(OrientedVertex<T> neighbor) {
        Edge<T> edge = getEdgeTo(neighbor);
        neighbors.remove(edge);
    }

    public List<T> getNeighbors() {
        List<T> neighbors = new ArrayList<>();
        Iterator<OrientedVertex<T>> iterator = iterator();

        while (iterator.hasNext()) {
            neighbors.add(iterator.next().value());
        }

        return neighbors;
    }

    public T value() {
        return info;
    }
}

class Edge<T> {

    private OrientedVertex<T> from;
    private OrientedVertex<T> to;
    private int weight;

    Edge(OrientedVertex<T> from, OrientedVertex<T> to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    OrientedVertex<T> dest() {
        return to;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((from == null) ? 0 : from.hashCode());
        result = prime * result + ((to == null) ? 0 : to.hashCode());
        result = prime * result + weight;
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge<T> other = (Edge<T>) obj;
        if (from == null) {
            if (other.from != null)
                return false;
        } else if (!from.equals(other.from))
            return false;
        if (to == null) {
            if (other.to != null)
                return false;
        } else if (!to.equals(other.to))
            return false;
        if (weight != other.weight)
            return false;
        return true;
    }
}

class VertexIterator<T> implements Iterator<OrientedVertex<T>> {
    Iterator<Edge<T>> iterator;

    VertexIterator(Collection<Edge<T>> neighbors) {
        iterator = neighbors.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public OrientedVertex<T> next() {
        return iterator.next().dest();
    }
}

class NoSuchVertexException extends Exception {
    public NoSuchVertexException() {
    }

    public NoSuchVertexException(String message) {
        super(message);
    }
}