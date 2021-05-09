package ir.sk.algorithm.graph;

/**
 * Can the vertices of a given graph be assigned
 * one of two colors in such a way that no edge connects vertices of the same color ?
 * which is equivalent to this question: Is the graph bipartite ?
 * <p>
 * Created by sad.kayvanfar on 5/9/2021.
 */
public class TwoColorGraph {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColorGraph(Graph G) {
        marked = new boolean[G.vertexSize()];
        color = new boolean[G.vertexSize()];
        for (int s = 0; s < G.vertexSize(); s++)
            if (!marked[s])
                dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.getNeighborsFor(v))
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(G, w);
            } else if (color[w] == color[v]) isTwoColorable = false;
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }
}
