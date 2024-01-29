package ir.sk.adt.datastructure.graph;

public class IncidenceMatrix {
    private final int rows;
    private final int cols;
    private int[][] incidence_matrix;
 
    public IncidenceMatrix(int v, int e) {
        rows = v;
        cols = e;
        incidence_matrix = new int[rows + 1][cols + 1];
    }
 
    public void makeEdge(int to, int from, int edge, int edge_number) {
        try {
            incidence_matrix[to][edge_number] = edge;
            incidence_matrix[from][edge_number] = edge;
        }
        catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
    }

    public int getEdge(int edge_number, int v) {
        try {
            return incidence_matrix[edge_number][v];
        }
        catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }
}