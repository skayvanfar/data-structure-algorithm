package ir.sk.adt.set.disjointset;

import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.HashingIndexPattern;

/**
 * Created by sad.kayvanfar on 5/1/2021.
 */
@HashingIndexPattern
public class QuickFindDisjointSet implements DisjointSet {

    private int[] id; // access to component id (site indexed)
    private int count; // number of components

    public QuickFindDisjointSet(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++)
            id[i] = i;
    }

    /**
     * @param p
     * @param q
     */
    @TimeComplexity("O(n)")
    @Override
    public void union(int p, int q) {
        // Put p and q into the same component.
        int pID = find(p);
        int qID = find(q);
        // Nothing to do if p and q are already in the same component.
        if (pID == qID) return;
        // Rename p’s component to q’s name.
        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }

    @TimeComplexity("O(1)")
    @Override
    public int find(int p) {
        return id[p];
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
