package ir.sk.datastructure.fundamental.graph;

import java.util.Collection;

/**
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/11/2020.
 */
public interface Graph<T> {
    boolean contains(T item);
    void addVertex(T vertex);
    boolean areAdjacent(T a, T b) throws Exception;
    void removeVertex(T vertex) throws Exception;
    void addEdge(T from, T to, int weight) throws Exception;
    void removeEdge(T from, T to) throws Exception;
    Collection<T> getNeighborsFor(T vertex) throws Exception;
    void depthSearch(T start) throws Exception;
    void breathSearch(T start) throws Exception;
}
