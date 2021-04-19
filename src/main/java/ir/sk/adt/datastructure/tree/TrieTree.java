package ir.sk.adt.datastructure.tree;

import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.FrequencyCountingPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 9/3/2020.
 */
public class TrieTree {

    private TrieNode root;

    TrieTree() {
        root = new TrieNode();
    }

    /**
     * @param word
     */
    @TimeComplexity("O(n)")
    public void insert(String word) {
        TrieNode current = root;

        for (char l : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    /**
     * @param word
     * @return
     */
    @TimeComplexity("O(n)")
    public boolean containsNode(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * @param current
     * @param word
     * @param index
     * @return
     */
    @TimeComplexity("O(n)")
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
}

class TrieNode {
    @FrequencyCountingPattern
    private final Map<Character, TrieNode> children = new HashMap<>();
    private boolean endOfWord;

    Map<Character, TrieNode> getChildren() {
        return children;
    }

    boolean isEndOfWord() {
        return endOfWord;
    }

    void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}
