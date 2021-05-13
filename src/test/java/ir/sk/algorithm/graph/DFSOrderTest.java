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
        Digraph G = new Digraph(5);

        DFSOrder dfs = new DFSOrder(G);

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