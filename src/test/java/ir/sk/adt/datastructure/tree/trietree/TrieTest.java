package ir.sk.adt.datastructure.tree.trietree;

import ir.sk.adt.datastructure.tree.trietree.Trie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 5/18/2021.
 */
public class TrieTest {

    private Trie trie;

    @Before
    public void setUp() throws Exception {
        trie = new Trie();

        trie.insert("ali");
        System.out.println();
        trie.insert("alia");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {

        System.out.println();
        trie.insert("bidar");
        System.out.println();
      //  System.out.println(trie.search("bidar"));
    }

    @Test
    public void search() {
        System.out.println(trie.search("ali"));
    }
}