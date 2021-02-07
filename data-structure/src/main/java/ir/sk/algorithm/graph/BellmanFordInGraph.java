package ir.sk.algorithm.graph;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/27/2020.
 */
public class BellmanFordInGraph {

    private int V, E;
    public Edgee edge[];

    // Creates a graph with V vertices and E edges
    public BellmanFordInGraph(int v, int e) {
        V = v;
        E = e;
        edge = new Edgee[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edgee();
    }

    /**
     * The main function that finds shortest distances from src
     * to all other vertices using Bellman-Ford algorithm. The
     * function also detects negative weight cycle
     * <p>
     * Time Complexity: O(|V|*|E|)
     *
     * @param src
     */
    public void bellmanFord(int src) {
        int dist[] = new int[V];

        // Step 1: Initialize distances from src to all other
        // vertices as INFINITE
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;

        // Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edge[j].src;
                int v = edge[j].dest;
                int weight = edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        // Step 3: check for negative-weight cycles. The above
        // step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter
        // path, then there is a cycle.
        for (int j = 0; j < E; ++j) {
            int u = edge[j].src;
            int v = edge[j].dest;
            int weight = edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        printArr(dist, V);
    }

    /**
     * A utility function used to print the solution
     *
     * @param dist
     * @param V
     */
    private void printArr(int dist[], int V) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }
}

/**
 * A class to represent a weighted edge in graph
 */
class Edgee {
    int src, dest, weight;

    Edgee() {
        src = dest = weight = 0;
    }
}