package ir.sk.algorithm.array.lcp;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.HashingIndexPattern;

import java.util.ArrayList;

/**
 * LCP:
 * given a set of strings, find the longest common prefix. i.e. find the prefix part that is common to all the strings.
 * <p>
 * 1. Construct a trie and insert all the input strings into the trie. insert() function is used to insert an individual
 * string from the given array of strings while constructTrie() is used to insert all the input strings iteratively.
 * 2. store the longest common prefix in the prefix variable.
 * 3. Now,begin a traversal from root node of the trie and do the following:
 * 1. check if the node has single child or not. It has no child or more than one child,
 * terminates the traversal. Counting the number of not null children of a trie node is done using function countChildren().
 * 2. If the node has a single child, move on to that child and append character corresponding to that node into the prefix.
 * 3. repeat steps 1 and 2 until a node with no child (or more than one child) is found or we reach a trie node that stores the last character of the shortest string in the array of strings.
 * During each step of the traversal, keep adding character corresponding to each trie node traversed.
 * 4. The traversal described in step 3 is implemented using function walkTrie(), this function traverses the trie and looks for the longest common prefix path and returns the corresponding longest common prefix.
 * 5. In the end, we use a driver function longestCommonPrefix() that combines all the functions mentioned above and returns the longest common prefix among the given array of strings.
 *
 * @author <a href="sad.keyvanfar@gmail.com">Saeid Keyvanfar</a> on 1/2/2021.
 */
public class LongestCommonPrefixByTrie {

    static class TrieNode {
        @HashingIndexPattern
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
        char[] charArray = key.toCharArray();

        for (char ch : charArray) {
            int index = ch - 'a';

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
    @TimeComplexity("O(n*m), n = Number of strings, m = Length of longest string")
    @SpaceComplexity("O(26*m*n) ~ O(n*m)")
    static void constructTrie(TrieNode root, ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++)
            insert(root, arr.get(i));
    }

    /**
     * to save the index of the only child
     */
    static int index;

    /**
     * counts number of non NULL children a Trie Node has
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
