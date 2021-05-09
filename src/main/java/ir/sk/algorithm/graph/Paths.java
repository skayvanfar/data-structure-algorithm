package ir.sk.algorithm.graph;

/**
 * The single-source paths problem is fundamental to graph processing.
 *
 * Created by sad.kayvanfar on 5/9/2021.
 */
public interface Paths {

    /**
     * is there a path from s to v?
     *
     * @param v
     * @return
     */
    boolean hasPathTo(int v);

    /**
     * is there a path from s to v?
     *
     * @param v
     * @return
     */
    Iterable<Integer> pathTo(int v);
}
