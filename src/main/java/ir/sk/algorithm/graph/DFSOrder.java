package ir.sk.algorithm.graph;

import ir.sk.adt.queue.LinkQueue;
import ir.sk.adt.queue.Queue;
import ir.sk.adt.stack.ResizingArrayStack;
import ir.sk.adt.stack.Stack;

/**
 *  The {@code DepthFirstOrder} class represents a data type for
 *  determining depth-first search ordering of the vertices in a digraph
 *  or edge-weighted digraph, including preorder, postorder, and reverse postorder.
 *  <p>
 *  This implementation uses depth-first search.
 *  Each constructor takes &Theta;(<em>V</em> + <em>E</em>) time,
 *  where <em>V</em> is the number of vertices and <em>E</em> is the
 *  number of edges.
 *  Each instance method takes &Theta;(1) time.
 *  It uses &Theta;(<em>V</em>) extra space (not including the digraph).
 *
 */
public class DFSOrder {

    private boolean[] visited;
    private Queue<Integer> pre;
    // vertices in preorder
    private Queue<Integer> post;
    // vertices in postorder
    private Stack<Integer> reversePost;

    // vertices in reverse postorder
    public DFSOrder(Digraph G) {
        pre = new LinkQueue<>();
        post = new LinkQueue<>();
        reversePost = new ResizingArrayStack<>();
        visited = new boolean[G.vertexSize()];
        for (int v = 0; v < G.vertexSize(); v++)
            if (!visited[v]) dfs(G, v);
    }

    // run DFS in digraph G from vertex v and compute preorder/postorder
    private void dfs(Digraph G, int v) {
        pre.enqueue(v);
        visited[v] = true;
        for (int w : G.getNeighborsFor(v))
            if (!visited[w])
                dfs(G, w);

        post.enqueue(v);
        reversePost.push(v);
    }

    /**
     * Returns the vertices in preorder. tail recursive
     * @return the vertices in preorder, as an iterable of vertices
     */
    public Iterable<Integer> preOrder() {
        return pre;
    }

    /**
     * Returns the vertices in postorder. head recursive
     * @return the vertices in postorder, as an iterable of vertices
     */
    public Iterable<Integer> postOrder() {
        return post;
    }

    /**
     * Returns the vertices in reverse postorder. head recursive
     * @return the vertices in reverse postorder, as an iterable of vertices
     */
    public Iterable<Integer> reversePostOrder() {
        return reversePost;
    }

}
