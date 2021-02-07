package ir.sk.algorithm.graph;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

import java.util.*;

/**
 * In many applications, we use directed acyclic graphs to indicate precedences among events.
 * For example, in a scheduling problem, there is a set of tasks and a set of constraints specifying the order of these tasks.
 * We can construct a DAG to represent tasks.
 * The directed edges of the DAG represent the order of the tasks.
 * <p>
 * A topological sort of a DAG G is a linear ordering of all its vertices such that if G contains an edge (u, v), then u appears before v in the ordering.
 * For a DAG, we can construct a topological sort with running time linear to the number of vertices plus the number of edges, which is O(V+E).
 * <p>
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
        LinkedList<Integer> result = new LinkedList<>();
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


    /**
     * Kahn’s algorithm for Topological Sorting
     */
    @TimeComplexity("O(|V|+|E|)")
    @SpaceComplexity("O(|V|)")
    public void topologicalSortByKahn() {
        int V = adjVertices.size();
        // Create a array to store
        // indegrees of all
        // vertices. Initialize all
        // indegrees as 0.
        int indegree[] = new int[V];

        // Traverse adjacency lists
        // to fill indegrees of
        // vertices. This step takes
        // O(V+E) time
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> temp = (ArrayList<Integer>) adjVertices.get(i);
            for (int node : temp) {
                indegree[node]++;
            }
        }

        // Create a queue and enqueue
        // all vertices with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        // Initialize count of visited vertices
        int cnt = 0;

        // Create a vector to store result
        // (A topological ordering of the vertices)
        Vector<Integer> topOrder = new Vector<>();
        while (!q.isEmpty()) {
            // Extract front of queue
            // (or perform dequeue)
            // and add it to topological order
            int u = q.poll();
            topOrder.add(u);

            // Iterate through all its
            // neighbouring nodes
            // of dequeued node u and
            // decrease their in-degree
            // by 1
            for (int node : adjVertices.get(u)) {
                // If in-degree becomes zero,
                // add it to queue
                if (--indegree[node] == 0)
                    q.add(node);
            }
            cnt++;
        }

        // Check if there was a cycle
        if (cnt != V) {
            System.out.println(
                    "There exists a cycle in the graph");
            return;
        }

        // Print topological order
        for (int i : topOrder) {
            System.out.print(i + " ");
        }
    }
}
