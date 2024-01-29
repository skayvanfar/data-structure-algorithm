package ir.sk.adt.datastructure.tree.trietree;

import ir.sk.helper.Implementation;
import ir.sk.helper.ImplementationType;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.HashingIndexPattern;

/**
 * Trie also called digital tree or prefix tree,[1] is a type of k-ary search tree, a tree data structure used for locating specific keys from within a set.
 * Unlike a binary search tree, nodes in the trie do not store their associated key.
 * Instead, a node's position in the trie defines the key with which it is associated.
 * usage: Replacement for hash table
 * 
 * Created by sad.kayvanfar on 5/18/2021.
 */
public class Trie {

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    @TimeComplexity("O(n)")
    public void insert(String word) {
        insert(root, word, 0);
    }

    private Node insert(Node currNode, String word, int index) {
        if (currNode == null)
            currNode = new Node();

        if (index == word.length() - 1) {
            currNode.end = true;
            return currNode;
        }

        char ch = word.charAt(index); // Use dth key char to identify subtrie.

        currNode.next[ch - 'a'] = insert(currNode.next[ch - 'a'], word, index + 1);
        return currNode;
    }

    /**
     * inserts a single string into a trie rooted at 'root'
     *
     * @param root
     * @param key
     */
    @TimeComplexity("O(n), n Length of the string")
    @Implementation(type = ImplementationType.Iterative)
    static void insert(Node root, String key) {
        Node temp = root;
        char[] charArray = key.toCharArray();

        for (char ch : charArray) {
            int index = ch - 'a';

            if (temp.next[index] == null)
                temp.next[index] = new Node();

            temp = temp.next[index];
        }

        temp.end = true;
    }

    /**
     * @param key
     * @return
     */
    public boolean search(String key) {
        if (key == null) throw new IllegalArgumentException("argument to search() is null");
        Node x = search(root, key, 0);
        if (x == null) return false;
        return x.end;
    }

    private Node search(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char ch = key.charAt(d);
        return search(x.next[ch - 'a'], key, d+1);
    }



}

class Node {

    public final static int R = 26; // Range

    @HashingIndexPattern
    public Node[] next = new Node[R];
    public boolean end;
}
