package ir.sk.adt.set.unionfind;

import ir.sk.adt.set.unionfind.QuickFindUF;
import ir.sk.adt.set.unionfind.UF;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 5/1/2021.
 */
public class QuickFindUFTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void union() {
        UF uf = new QuickFindUF(10); // Initialize N components.
        int p = 2;
        int q = 3;
        if (!uf.connected(p, q)) { // Ignore if connected.
            uf.union(p, q); // Combine components
            System.out.println(p + " " + q); // and print connection.
        }

        System.out.println(uf.count() + " components");
    }
}