package ir.sk.adt.set.disjointset;

import ir.sk.algorithm.graph.component.ConnectedComponents;

/**
 * Disjoint-set (Union-Find) (merge–find) is a ADT that stores a collection of disjoint (non-overlapping) sets
 * an API that encapsulates the basic operations that: initialize, add a connection between two sites,
 * identify the component containing a site, determine whether two sites are in the same component, and count the number of components.
 * its another algorithm for ConnectedComponents. ({@link ConnectedComponents})
 *
 * Created by sad.kayvanfar on 5/1/2021.
 */
public interface DisjointSet {

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
