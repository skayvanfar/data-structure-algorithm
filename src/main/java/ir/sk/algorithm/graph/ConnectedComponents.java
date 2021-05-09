package ir.sk.algorithm.graph;

/**
 * direct application of depth-first search is to
 * find the connected components of a graph.
 *
 * Created by sad.kayvanfar on 5/9/2021.
 */
public class ConnectedComponents {

    // Set
    private boolean[] marked;
    // as Map
    private int[] id;
    private int count;

    public ConnectedComponents(Graph G) {
        marked = new boolean[G.vertexSize()];
        id = new int[G.vertexSize()];
        for (int s = 0; s < G.vertexSize(); s++)
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
    }

    // depth-first search for a Graph
    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.getNeighborsFor(v))
            if (!marked[w])
                dfs(G, w);
    }

    /**
     * Returns true if vertices {@code v} and {@code w} are in the same connected component.
     *
     * @param v
     * @param w
     * @return
     */
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    /**
     * component identifier for v
     * ( between 0 and count()-1 )
     *
     * @param v
     * @return
     */
    public int id(int v) {
        return id[v];
    }

    /**
     * Returns the number of connected components in the graph {@code G}.
     *
     * @return the number of connected components in the graph {@code G}
     */
    public int count() {
        return count;
    }
}
