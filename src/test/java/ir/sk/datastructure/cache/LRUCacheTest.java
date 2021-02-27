package ir.sk.datastructure.cache;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 9/21/2020.
 */
public class LRUCacheTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void cache() {
        LRUCache cache = new LRUCache();
        for (int i = 0; i < 20; i++) {
            String query = "query" + i;
            cache.insertResults(query, generateResults(i));
            if (i == 9 || i == 16 || i == 19) {
                cache.getResults("query" + 2);
                cache.getResults("query" + 6);
                cache.getResults("query" + 9);
            }
        }

        for (int i = 0; i < 30; i++) {
            String query = "query" + i;
            String[] results = cache.getResults(query);
            System.out.print(query + ": ");
            if (results == null) {
                System.out.print("null");
            } else {
                for (String s : results) {
                    System.out.print(s + ", ");
                }
            }
            System.out.println("");
        }
    }

    public static String[] generateResults(int i) {
        String[] results = {"resultA" + i, "resultB" + i, "resultC" + i};
        return results;
    }
}