package ir.sk.adt.datastructure.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 5/18/2021.
 */
public class TrieTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        Trie trie = new Trie();

        trie.insert("ali");
        System.out.println();
        trie.insert("alia");
        System.out.println();
        trie.insert("bidar");
        System.out.println();
      //  System.out.println(trie.search("bidar"));
    }
}