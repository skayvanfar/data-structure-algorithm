package ir.sk.algorithm.treeandgraph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sad.kayvanfar on 9/15/2020.
 */
public class TreeGraphAlgorithmsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createMinimalBSTByOrderedArray() {
    }

    @Test
    public void checkValidBSTByInorder() {
    }

    @Test
    public void checkValidBSTByBoundaries() {
    }

    @Test
    public void treeSerialization() {
        Node<String> root = new Node("Ali",
                new Node("Vali",
                        new Node("Saeed"),
                        new Node("Reza")),
                new Node("Mehran",
                        new Node("Mohsen"),
                        new Node("Amir")));

        String result = TreeGraphAlgorithms.treeSerialization(root);
        System.out.println(result);
    }
}