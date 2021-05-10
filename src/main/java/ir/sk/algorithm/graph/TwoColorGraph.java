package ir.sk.algorithm.graph;

/**
 * Can the vertices of a given graph be assigned
 * one of two colors in such a way that no edge connects vertices of the same color ?
 * which is equivalent to this question: Is the graph bipartite ?
 *
 * bipartite graph: A bipartite graph is a graph whose vertices we can divide into two sets
 * such that all edges connect a vertex in one set with a vertex in the other set.
 * for example usage:
 * file consists of lines listing a movie name followed
 * by a list of the performers in the movie. In the
 * context of graph processing, we can view it as defining
 * a graph with movies and performers as vertices and
 * each line defining the adjacency list of edges connecting
 * each movie to its performers. Note that the graph
 * is a bipartite graph—there are no edges connecting
 * performers to performers or movies to movies.
 *
 * <p>
 * Created by sad.kayvanfar on 5/9/2021.
 */
public class TwoColorGraph {
    private boolean[] visited;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColorGraph(Graph G) {
        visited = new boolean[G.vertexSize()];
        color = new boolean[G.vertexSize()];
        for (int s = 0; s < G.vertexSize(); s++)
            if (!visited[s])
                dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        visited[v] = true;
        for (int w : G.getNeighborsFor(v))
            if (!visited[w]) {
                color[w] = !color[v];
                dfs(G, w);
            } else if (color[w] == color[v]) isTwoColorable = false;
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }
}
