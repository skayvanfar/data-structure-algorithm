package ir.sk.algorithm.graph;

/**
 * Cycle detection: Is a given graph acylic?
 * is G acyclic? (assumes no self-loops or parallel edges)
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

    private void dfs(Graph G, int v, int u) {
        visited[v] = true;
        for (int w : G.getNeighborsFor(v))
            if (!visited[w])
                dfs(G, w, v);
            else if (w != u) hasCycle = true;
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
