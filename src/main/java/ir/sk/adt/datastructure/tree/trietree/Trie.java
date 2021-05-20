package ir.sk.adt.datastructure.tree.trietree;

import ir.sk.helper.Implementation;
import ir.sk.helper.ImplementationType;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.HashingIndexPattern;

public class Trie {

    private TriNode root;      // root of trie

    /**
     * inserts a single string into a trie rooted at 'root'
     *
     * @param root
     * @param key
     */
    @TimeComplexity("O(n), n Length of the string")
    @Implementation(type = ImplementationType.Iterative)
    static void insert(TriNode root, String key) {
        TriNode temp = root;
        char[] charArray = key.toCharArray();

        for (char ch : charArray) {
            int index = ch - 'a';

            if (temp.child[index] == null)
                temp.child[index] = new TriNode();

            temp = temp.child[index];
        }

        temp.isEnd = true;
    }
}

class TriNode {

    public final static int R = 26; // Range

    @HashingIndexPattern
    TriNode[] child = new TriNode[R];
    boolean isEnd;

    public TriNode() {
        for (int i = 0; i < child.length; i++)
            child[i] = null;

        isEnd = false;
    }
}