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
        System.out.println(CoinExchangeProblem.findMinCoinsGreedy(new int[]{1000, 500, 100, 50, 20, 10, 5, 2, 1}, 93));
    }

    @Test
    public void findMinCoinsUnOptimal() {
        // it doesn’t work for denominations {9, 6, 5, 1} and V = 11. The above approach would print 9, 1 and 1. But we can use 2 denominations 5 and 6.
        System.out.println(CoinExchangeProblem.findMinCoinsGreedy(new int[]{9, 6, 5, 1}, 11));
    }

    @Test
    public void findMinCoinsByRecursive() {
        System.out.println(CoinExchangeProblem.findMinCoinsByRecursive(new int[]{9, 6, 5, 1}, 11));
    }
}