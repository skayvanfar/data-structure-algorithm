package ir.sk.adt.datastructure.graph;


import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.paradigm.BFS;
import ir.sk.helper.paradigm.Backtracking;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Adjacency Matrix is a 2D array of size V x V where V is the number of vertices in a graph.
 * Let the 2D array be adj[][], a slot adj[i][j] = 1 indicates that there is an edge from vertex i to vertex j.
 * Adjacency matrix for undirected graph is always symmetric. Adjacency Matrix is also used to represent weighted graphs.
 * If adj[i][j] = w, then there is an edge from vertex i to vertex j with weight w.
 * <p>
 * If the graph is undirected (i.e. all of its edges are bidirectional), the adjacency matrix is symmetric.
 * <p>
 * For a dense graph (one in which most pairs of vertices are connected by edges) is appropriate
 * <p>
 * This representation makes use of VxV matrix, so space required in worst case is O(|V|^2).
 * <p>
 * Created by sad.keyvanfar on 7/1/2020.
 */
@SpaceComplexity("O(|V|^2)")
public class AdjacencyMatrixGraph {

    private final int MAX_VERTS = 20;

    private VertexM vertexList[]; // array of vertices
    private int adjacencyMatrix[][]; // adjacency matrix
    private int numVerts; // current number of vertices

    public AdjacencyMatrixGraph() {
        vertexList = new VertexM[MAX_VERTS];
        adjacencyMatrix = new int[MAX_VERTS][MAX_VERTS];
        numVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) // set adjacency
            for (int k = 0; k < MAX_VERTS; k++) // matrix to 0
                adjacencyMatrix[j][k] = 0;
    }

    /**
     * {@inheritDoc}
     */
    @TimeComplexity("O(1)")
    public void addVertex(char label) {
        vertexList[numVerts++] = new VertexM(label);
    }

    /**
     * {@inheritDoc}
     */
    @TimeComplexity("O(1)")
    public void addEdge(int start, int end, int weight) {
        adjacencyMatrix[start][end] = weight;
        adjacencyMatrix[end][start] = weight;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    /**
     *
     */
    @TimeComplexity("O(|V|^2)")
    @BFS
    public void bfs() {
        Queue<Integer> theQueue = new ArrayDeque<>();
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.add(0); // insert at tail
        int v2;
        while (!theQueue.isEmpty()) // until queue empty,
        {
            int v1 = theQueue.remove(); // remove vertex at head
            // until it has no unvisited neighbors
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) { // get one,
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.add(v2); // insert it
            }
        }
        // queue is empty, so we’re done
        for (int j = 0; j < numVerts; j++) // reset flags
            vertexList[j].wasVisited = false;
    }

    /**
     *
     */
    @TimeComplexity("O(|V|^2)")
    @Backtracking
    public void dfs() {
        Stack<Integer> theStack = new Stack<>();
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);
        while (!theStack.isEmpty()) {
            // get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) // if no such vertex,
                theStack.pop();
            else { // if it exists,
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        // stack is empty, so we’re done
        for (int j = 0; j < numVerts; j++) // reset flags
            vertexList[j].wasVisited = false;
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < numVerts; j++)
            if (adjacencyMatrix[v][j] >= 1 && vertexList[j].wasVisited == false) // for unweighted graph is adjMat[v][j] == 1
                return j;
        return -1;
    }

}

class VertexM {
    public char label;
    public boolean wasVisited;

    public VertexM(char lab) {
        label = lab;
        wasVisited = false;
    }
}
