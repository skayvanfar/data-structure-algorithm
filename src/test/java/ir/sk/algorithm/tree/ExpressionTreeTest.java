package ir.sk.algorithm.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="sad.keyvanfar@gmail.com">Saeed Kayvanfar</a> on 1/2/2021.
 */
public class ExpressionTreeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void evaluateExpressionTree() {
        Node<Character> root =
                new Node<>('*',
                        new Node<>('+',
                                new Node<>('3'),
                                new Node<>('2')),
                        new Node<>('+',
                                new Node<>('4'),
                                new Node<>('5')));
        System.out.println(ExpressionTree.evaluateExpressionTree(root));
    }

    @Test
    public void constructExpressionTree() {
        String postfix = "ab+cde+××";
        Node root = ExpressionTree.constructExpressionTree(postfix);

        System.out.print("\nInfix Expression  : ");
        ExpressionTree.inFix(root);

        System.out.print("\nPostfix Expression: ");
        ExpressionTree.postFix(root);
    }

    @Test
    public void inFix() {
    }

    @Test
    public void postFix() {
    }
}