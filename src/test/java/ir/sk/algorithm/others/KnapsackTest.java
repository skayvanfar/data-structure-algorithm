package ir.sk.algorithm.others;

import ir.sk.algorithm.others.Knapsack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 2/9/2021.
 */
public class KnapsackTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void slove10knapsack() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfits = Knapsack.solve10knapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfits);
        maxProfits = Knapsack.solve10knapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfits);
    }

    @Test
    public void slove10knapsackByDP() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfits = Knapsack.slove10knapsackByDP(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfits);
        maxProfits = Knapsack.slove10knapsackByDP(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfits);
    }

}