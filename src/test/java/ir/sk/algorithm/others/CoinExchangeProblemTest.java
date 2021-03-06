package ir.sk.algorithm.others;

import ir.sk.algorithm.others.CoinExchangeProblem;
import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 2/21/2021.
 */
@Difficulty(type = DifficultyType.HARD)
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
        // it doesnt work for denominations {9, 6, 5, 1} and V = 11. The above approach would print 9, 1 and 1. But we can use 2 denominations 5 and 6.
        System.out.println(CoinExchangeProblem.findMinCoinsGreedy(new int[]{9, 6, 5, 1}, 11));
    }

    @Test
    public void findMinCoinsByRecursive() {
        System.out.println(CoinExchangeProblem.findMinCoinsByRecursive(new int[]{9, 6, 5, 1}, 11));
    }

    @Test
    public void findMinCoinsByByDP() {
        System.out.println(CoinExchangeProblem.findMinCoinsByByDP(new int[]{9, 6, 5, 1}, 11));
    }

    @Test
    public void findMinCoinsByByBFS() {
        System.out.println(CoinExchangeProblem.findMinCoinsByByBFS(new int[]{9, 6, 5, 1}, 11));
    }
}