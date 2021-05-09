package ir.sk.algorithm.graph;

/**
 * Cycle detection: Is a given graph acylic?
 * is G acyclic? (assumes no self-loops or parallel edges)
 * <p>
 * Created by sad.kayvanfar on 5/9/2021.
 */
public class Cycle {

    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.vertexSize()];
        for (int s = 0; s < G.vertexSize(); s++)
            if (!marked[s])
                dfs(G, s, s);
    }

    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for (int w : G.getNeighborsFor(v))
            if (!marked[w])
                dfs(G, w, v);
            else if (w != u) hasCycle = true;
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
