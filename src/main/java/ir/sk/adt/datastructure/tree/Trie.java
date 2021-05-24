package ir.sk.adt.datastructure.tree;

import ir.sk.helper.complexity.TimeComplexity;

/**
 * Created by sad.kayvanfar on 5/18/2021.
 */
public class Trie {

    private Node root;

    public Trie() {
        this.root = new Node('/');
    }

    @TimeComplexity("O(n)")
    public void insert(String word) {
        insert(root, word, 0);
    }

    private void insert(Node currNode, String word, int index) {
        if (currNode == null)
            currNode = new Node();

        char ch = word.charAt(index); // Use dth key char to identify subtrie.

        if (index == word.length() - 1) {
            currNode.value = ch;
        //    return currNode;
        }

      //  currNode.next[ch] =
        insert(currNode.next[ch - 'a'], word, index + 1);
       // return currNode;
    }


}

class Node {
    public char value;
    public Node[] next = new Node[26];

    public Node(char value) {
        this.value = value;
    }

    public Node() {
    }
}
