package ir.sk.adt.set.disjointset;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 5/1/2021.
 */
public class QuickFindDisjointSetTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void union() {
        DisjointSet disjointSet = new QuickFindDisjointSet(10); // Initialize N components.
        int p = 2;
        int q = 3;
        if (!disjointSet.connected(p, q)) { // Ignore if connected.
            disjointSet.union(p, q); // Combine components
            System.out.println(p + " " + q); // and print connection.
        }

        System.out.println(disjointSet.count() + " components");
    }
}