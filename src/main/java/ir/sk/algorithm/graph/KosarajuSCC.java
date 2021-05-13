package ir.sk.algorithm.graph;

/**
 * To find strong components, it does a depth-first search in the reverse
 * digraph to produce a vertex order (reverse postorder of that search) for use in a depth-first search of
 * the given digraph.
 */
public class KosarajuSCC {

    private boolean[] marked;
    private int[] id;
    private int count;

    // reached vertices
// component identifiers
// number of strong components
    public KosarajuSCC(Digraph G) {
        marked = new boolean[G.vertexSize()];
        id = new int[G.vertexSize()];
        DFSOrder order = new DFSOrder(G.reverse());
        for (int s : order.reversePostOrder())
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.getNeighborsFor(v))
            if (!marked[w])
                dfs(G, w);
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

}
