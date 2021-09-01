package ir.sk.adt.set.disjointset;

import ir.sk.helper.complexity.TimeComplexity;

/**
 * Created by sad.kayvanfar on 5/1/2021.
 */
public class QuickUnionDisjointSet implements DisjointSet {

    private int[] id; // access to component id (site indexed)
    private int count; // number of components


    public QuickUnionDisjointSet(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++)
            id[i] = i;
    }

    /**
     * Give p and q the same root.
     *
     * @param p
     * @param q
     */
    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    /**
     * Find component name.
     *
     * @param p
     * @return
     */
    @Override
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    @TimeComplexity("O(1)")
    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
