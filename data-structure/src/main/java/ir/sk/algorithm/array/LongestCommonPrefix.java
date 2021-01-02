package ir.sk.algorithm.array;

import ir.sk.helper.FrequencyCountingPattern;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.ArrayList;

/**
 * LCP:
 * given a set of strings, find the longest common prefix. i.e. find the prefix part that is common to all the strings.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/2/2021.
 */
public class LongestCommonPrefix {

    static class TrieNode {
        @FrequencyCountingPattern
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;

        public TrieNode() {
            for (int i = 0; i < 26; i++)
                child[i] = null;

            isEnd = false;
        }
    }

    ;

    /**
     * inserts a single string into a trie rooted at 'root'
     *
     * @param root
     * @param key
     */
    @TimeComplexity("O(n)")
    static void insert(TrieNode root, String key) {
        TrieNode temp = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';

            if (temp.child[index] == null)
                temp.child[index] = new TrieNode();

            temp = temp.child[index];
        }

        temp.isEnd = true;
    }

    /**
     * inserts an array of strings into the trie rooted at 'root'
     *
     * @param root
     * @param arr
     */
    @TimeComplexity("O(n*m)")
    @SpaceComplexity("O(n*m)")
    static void constructTrie(TrieNode root, ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++)
            insert(root, arr.get(i));
    }

    static int index;

    /** counts number of non NULL children a Trie Node has
     *
     * @param root
     * @return
     */
    static int countChildren(TrieNode root) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null) {
                count++;
                index = i;
            }
        }

        return count;
    }

    /**
     * performs traversal on trie of strings rooted at 'root'
     * and returns the longest common prefix string
     *
     * @param root
     * @return
     */
    static StringBuffer walkTrie(TrieNode root) {
        TrieNode temp = root;
        StringBuffer prefix = new StringBuffer();

        while (countChildren(temp) == 1 && temp.isEnd == false) {
            temp = temp.child[index];
            prefix.append((char) ('a' + index));
        }

        return prefix;
    }

    /**
     * combines all the function above and return
     * LCP among given array of strings
     *
     * @param arr
     * @return
     */
    static StringBuffer longestCommonPrefix(ArrayList<String> arr) {
        TrieNode root = new TrieNode();
        constructTrie(root, arr);

        StringBuffer prefix = walkTrie(root);

        return prefix;
    }

}
