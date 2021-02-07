package ir.sk.algorithm.treeandgraph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/2/2021.
 */
public class ExpressionTreeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
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
        System.out.println(ExpressionTree.calculateExpression(root));
    }
}