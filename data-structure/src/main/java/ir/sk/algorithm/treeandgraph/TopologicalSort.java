package ir.sk.algorithm.treeandgraph;

import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.*;

/**
 * In many applications, we use directed acyclic graphs to indicate precedences among events.
 * For example, in a scheduling problem, there is a set of tasks and a set of constraints specifying the order of these tasks.
 * We can construct a DAG to represent tasks.
 * The directed edges of the DAG represent the order of the tasks.
 *
 * A topological sort of a DAG G is a linear ordering of all its vertices such that if G contains an edge (u, v), then u appears before v in the ordering.
 * For a DAG, we can construct a topological sort with running time linear to the number of vertices plus the number of edges, which is O(V+E).
 *
 * Created by sad.kayvanfar on 9/15/2020.
 */
public class TopologicalSort {

    private Map<Integer, List<Integer>> adjVertices;

    public TopologicalSort() {
        this.adjVertices = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjVertices.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int src, int dest) {
        adjVertices.get(src).add(dest);
    }

    public void dfsWithoutRecursion(int start) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] isVisited = new boolean[adjVertices.size()];
        stack.push(start);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            isVisited[current] = true;
            visit(current);
            for (int dest : adjVertices.get(current)) {
                if (!isVisited[dest])
                    stack.push(dest);
            }
        }
    }

    public void dfs(int start) {
        // to avoid cycles
        boolean[] isVisited = new boolean[adjVertices.size()];
        dfsRecursive(start, isVisited);
    }

    private void dfsRecursive(int current, boolean[] isVisited) {
        isVisited[current] = true;
        visit(current);
        for (int dest : adjVertices.get(current)) {
            if (!isVisited[dest])
                dfsRecursive(dest, isVisited);
        }
    }

    private void visit(int value) {
        System.out.print(" " + value);
    }

    /**
     * One of the famous applications for DFS is Topological Sort. it sorts vertices in dependency order
     * if the graph can be topological-sorted, it is a DAG(directed acyclic graph) and DAG can be topological sorted.
     * it implements Depth First Search to process all nodes in a backtracking way
     * Topological Sort for a directed graph is a linear ordering of its vertices so that for every edge the source node comes before the destination.
     * Topological Sorting is mainly used for scheduling jobs from the given dependencies among jobs.
     *
     * @param start
     * @return
     */
    @TimeComplexity("O(|V|+|E|)")
    @SpaceComplexity("O(|V|)")
    public List<Integer> topologicalSortByDFS(int start) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        boolean[] isVisited = new boolean[adjVertices.size()];
        topologicalSortByDFS(start, isVisited, result);
        return result;
    }

    private void topologicalSortByDFS(int current, boolean[] isVisited, LinkedList<Integer> result) {
        isVisited[current] = true;
        for (int dest : adjVertices.get(current)) {
            if (!isVisited[dest])
                topologicalSortByDFS(dest, isVisited, result);
        }
        result.addFirst(current);
    }
}
