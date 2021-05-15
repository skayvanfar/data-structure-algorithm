package ir.sk.algorithm.graph.path;

import ir.sk.algorithm.graph.Graph;
import ir.sk.algorithm.graph.path.DepthFirstPaths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 5/8/2021.
 */
public class DepthFirstPathsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void hasPathTo() {
    }

    @Test
    public void pathTo() {
        Graph graph = new Graph(5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        DepthFirstPaths dfs = new DepthFirstPaths(graph, 1);

        for (int v = 0; v < graph.vertexSize(); v++) {
            if (dfs.hasPathTo(v)) {
                System.out.printf("%d to %d:  ", 1, v);
                for (int x : dfs.pathTo(v)) {
                    if (x == 1) System.out.println(x);
                    else System.out.print(x);
                }
                System.out.println();
            }

            else {
                System.out.printf("%d to %d:  not connected\n", 1, v);
            }

        }
    }
}