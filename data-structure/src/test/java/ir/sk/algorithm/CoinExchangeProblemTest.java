package ir.sk.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 2/21/2021.
 */
public class CoinExchangeProblemTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findMinCoinsGreedyOptimal() {
        System.out.println(CoinExchangeProblem.findMinCoinsGreedy(new int[]{1, 2, 5, 10, 20, 50, 100, 500, 1000}, 93));
    }

    @Test
    public void findMinCoinsUnOptimal() {
        // it doesn’t work for denominations {9, 6, 5, 1} and V = 11. The above approach would print 9, 1 and 1. But we can use 2 denominations 5 and 6.
        System.out.println(CoinExchangeProblem.findMinCoinsGreedy(new int[]{1, 5, 6, 9}, 11));
    }
}