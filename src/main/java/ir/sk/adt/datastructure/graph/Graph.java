package ir.sk.adt.datastructure.graph;

import java.util.Collection;

/**
 * Graph API
 * Edge classification:
 * 1. tree edge: visit new vertex via edge
 * 2. forward edge: node->descendant in tree (just in  weighted graph)
 * 3. backward edge: node->ancestor in tree
 * 4. cross edge: between two none-ancestor-related subtrees (just in  weighted graph)
 * Graph has cycle <=> dfs of graph has a backward edge
 *
 * @author <a href="sad.keyvanfar@gmail.com">Saeed Kayvanfar</a> on 7/11/2020.
 */
public interface Graph<T> {
    boolean contains(T item);

    void addVertex(T vertex);

    /**
     * are neighbors
     *
     * @param a
     * @param b
     * @return
     * @throws Exception
     */
    boolean areAdjacent(T a, T b) throws Exception;

    void removeVertex(T vertex) throws Exception;

    void addEdge(T from, T to, int weight) throws Exception;

    void removeEdge(T from, T to) throws Exception;

    /**
     * allows the client code to iterate through the vertices adjacent to a given vertex.
     * all of the algorithms that we consider on the basic abstraction embodied in getNeighborsFor().
     *
     * @param vertex
     * @return
     * @throws Exception
     */
    Collection<T> getNeighborsFor(T vertex) throws Exception;

    /**
     * BFS Vertex-based algorithm
     * It uses a queue to keep track of the next location to visit.
     * BFS finds the shortest path to the destination.
     * BFS traverses according to tree level. Wide and short
     * It requires more memory as compare to DFS. Inefficient
     * Examines bipartite graph, connected component and shortest path present in a graph.
     * Optimal for finding the shortest distance, not in cost.
     * to find out whether there is a route between two nodes.
     * <p>
     * can run on directed or undirected graph. It doesn't care about weight
     * <p>
     * it finds shortest paths in an unweighted graph.
     *
     * @param start
     * @return
     * @throws Exception
     */
    Collection<T> breathFirstSearch(T start) throws Exception;

    /**
     * DFS Edge-based algorithm
     * It uses a stack to keep track of the next location to visit.
     * DFS goes to the bottom of a subtree, then backtracks.
     * DFS traverses according to tree depth. Narrow and long
     * It requires less memory as compare to BFS. Efficient
     * Examines two-edge connected graph, strongly connected graph, acyclic graph and topological order.
     * to find out whether there is a route between two nodes.
     * <p>
     * can run on directed or undirected graph. It doesn't care about weight
     *
     * @param start
     * @return
     * @throws Exception
     */
    Collection<T> depthFirstSearch(T start) throws Exception;
}
