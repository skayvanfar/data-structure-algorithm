package ir.sk.algorithm.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DFSOrderTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void preOrder() {
    }

    @Test
    public void postOrder() {
    }

    @Test
    public void reversePostOrder() {
        Digraph digraph = new Digraph(4);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 2);
        digraph.addEdge(1, 3);
        digraph.addEdge(2, 3);

        DFSOrder dfs = new DFSOrder(digraph);

        System.out.print("Preorder:  ");
        for (int v : dfs.preOrder()) {
            System.out.print(v + " ");
        }
        System.out.println();

        System.out.print("Postorder: ");
        for (int v : dfs.postOrder()) {
            System.out.print(v + " ");
        }
        System.out.println();

        System.out.print("Reverse postorder: ");
        for (int v : dfs.reversePostOrder()) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}