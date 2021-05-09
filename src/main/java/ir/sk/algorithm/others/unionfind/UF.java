package ir.sk.algorithm.others.unionfind;

/**
 * an API that encapsulates the basic operations that: initialize, add a connection between two sites,
 * identify the component containing a site, determine whether two sites are in the same component, and count the number of components.
 * its another algorithm for ConnectedComponents. ({@link ir.sk.algorithm.graph.ConnectedComponents})
 *
 * Created by sad.kayvanfar on 5/1/2021.
 */
public interface UF {

    /**
     * add connection between p and q
     */
    void union(int p, int q);

    /**
     * component identifier for p (0 to N-1)
     */
    int find(int p);


    /**
     * return true if p and q are in the same component
     */
    boolean connected(int p, int q);


    /**
     * number of components
     */
    int count();
}
