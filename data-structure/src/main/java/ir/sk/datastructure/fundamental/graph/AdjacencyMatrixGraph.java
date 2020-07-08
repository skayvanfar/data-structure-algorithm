package ir.sk.datastructure.fundamental.graph;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sad.keyvanfar on 7/1/2020.
 */
public class AdjacencyMatrixGraph {

    private final int MAX_VERTS = 20;

    private VertexM vertexList[]; // array of vertices
    private int adjMat[][]; // adjacency matrix
    private int nVerts; // current number of vertices

    private Stack<Integer> theStack = new Stack<>();
    private Queue<Integer> theQueue = new ArrayDeque<>();

    public AdjacencyMatrixGraph() {
        vertexList = new VertexM[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j=0; j<MAX_VERTS; j++) // set adjacency
            for(int k=0; k<MAX_VERTS; k++) // matrix to 0
                adjMat[j][k] = 0;
    }

    /**
     * Time Complexity: O(1)
     *
     * @param label
     */
    public void addVertex(char label) {
        vertexList[nVerts++] = new VertexM(label);
    }

    /**
     * Time Complexity: O(n)
     *
     * @param start
     * @param end
     */
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    /**
     *
     */
    public void dfs() {
        vertexList[0].wasVisited = true; // mark it
        displayVertex(0); // display it
        theStack.push(0); // push it
        while( !theStack.isEmpty() ) // until stack empty,
        {
// get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex( theStack.peek() );
            if(v == -1) // if no such vertex,
                theStack.pop();
            else // if it exists,
            {
                vertexList[v].wasVisited = true; // mark it
                displayVertex(v); // display it
                theStack.push(v); // push it
            }
        } // end while
        // stack is empty, so we’re done
        for(int j=0; j<nVerts; j++) // reset flags
            vertexList[j].wasVisited = false;
    }

    public void bfs() { // begin at vertex 0
        vertexList[0].wasVisited = true; // mark it
        displayVertex(0); // display it
        theQueue.add(0); // insert at tail
        int v2;
        while( !theQueue.isEmpty() ) // until queue empty,
        {
            int v1 = theQueue.remove(); // remove vertex at head
            // until it has no unvisited neighbors
            while( (v2=getAdjUnvisitedVertex(v1)) != -1 )
            { // get one,
                vertexList[v2].wasVisited = true; // mark it
                displayVertex(v2); // display it
                theQueue.add(v2); // insert it
            } // end while(unvisited neighbors)
        } // end while(queue not empty)
        // queue is empty, so we’re done
        for(int j=0; j<nVerts; j++) // reset flags
            vertexList[j].wasVisited = false;
    }

    public int getAdjUnvisitedVertex(int v) {
        for(int j=0; j<nVerts; j++)
            if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
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
