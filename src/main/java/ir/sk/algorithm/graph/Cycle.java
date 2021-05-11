package ir.sk.algorithm.graph;

/**
 * Cycle detection: Is a given graph acylic?
 * is G acyclic? (assumes no self-loops or parallel edges)
 *
 * The {@code Cycle} class represents a data type for
 * determining whether an undirected graph has a simple cycle.
 * The <em>hasCycle</em> operation determines whether the graph has
 * a cycle and, if so, the <em>cycle</em> operation returns one.
 * <p>
 * This implementation uses depth-first search.
 * The constructor takes &Theta;(<em>V</em> + <em>E</em>) time in the
 * worst case, where <em>V</em> is the number of vertices and
 * <em>E</em> is the number of edges.
 * (The depth-first search part takes only <em>O</em>(<em>V</em>) time;
 * <p>
 * Created by sad.kayvanfar on 5/9/2021.
 */
public class Cycle {

    private boolean[] visited;
    private boolean hasCycle;

    public Cycle(Graph G) {
        visited = new boolean[G.vertexSize()];
        for (int s = 0; s < G.vertexSize(); s++)
            if (!visited[s])
                dfs(G, s, s);
    }

    /**
     * @param graph
     * @param currVertex current vertex
     * @param prevVertex previous vertex
     */
    private void dfs(Graph graph, int currVertex, int prevVertex) {
        visited[currVertex] = true;
        for (int w : graph.getNeighborsFor(currVertex))
            if (!visited[w])
                dfs(graph, w, currVertex);
            else if (w != prevVertex) hasCycle = true;
    }

    /**
     * Returns true if the graph {@code G} has a cycle.
     *
     * @return {@code true} if the graph has a cycle; {@code false} otherwise
     */
    public boolean hasCycle() {
        return hasCycle;
    }
}
