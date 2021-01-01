package ir.sk.algorithm.treeandgraph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void calculateExpression() {
        Node<Character> root =
                new Node<>('*',
                        new Node<>('+',
                                new Node<>('3'),
                                new Node<>('2')),
                        new Node<>('+',
                                new Node<>('4'),
                                new Node<>('5')));
        System.out.println(TreeGraphAlgorithms.calculateExpression(root));
    }
}