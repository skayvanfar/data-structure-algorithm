package ir.sk.adt.set.disjointset;

import ir.sk.algorithm.graph.Graph;

import java.util.Map;
import java.util.Set;

/**
 * Created by sad.kayvanfar on 9/1/2021.
 */
public class GraphDisjointSet implements DisjointSet {

    private Map<Integer, Set<Integer>> graph;

    // Set
    private boolean[] visited;
    // as Map
    private int[] id;
    private int count;

    public GraphDisjointSet(Map<Integer, Set<Integer>> graph) {
        this.graph = graph;
        visited = new boolean[graph.keySet().size()];
        id = new int[graph.keySet().size()];
        for (int s : graph.keySet())
            if (!visited[s]) {
                dfs(s);
                count++;
            }
    }

    // depth-first search for a Graph
    private void dfs(int vertex) {
        visited[vertex] = true;
        id[vertex] = count;
        for (int w : graph.get(vertex))
            if (!visited[w])
                dfs(w);
    }


    @Override
    public void union(int p, int q) {

    }

    @Override
    public int find(int p) {
        return 0;
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    @Override
    public int count() {
        return count;
    }
}
