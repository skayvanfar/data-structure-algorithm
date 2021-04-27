package ir.sk.algorithm.array;

import ir.sk.helper.Stopwatch;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class PairsWithGivenSumTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isPairSum() {
        int arr[] = {20, 3, 5, 9, 2, 8, 10, 11};
        Assert.assertEquals(true, PairsWithGivenSum.isPairSum(arr, 17));
    }

    @Test
    public void isPairSumTwoPonters() {
        int arr[] = {2, 3, 5, 8, 9, 10, 11, 20};
        Assert.assertEquals(true, PairsWithGivenSum.countPairSumTwoPointers(arr, 17));
    }

    @Test
    public void isPairSumByHashing() {
        int arr[] = {2, 3, 5, 8, 9, 10, 11, 20};
        Assert.assertEquals(true, PairsWithGivenSum.countPairSumTwoPointers(arr, 17));
    }

    @Test
    public void getPairsCount() {
        int arr[] = new int[]{1, 5, 7, -1};
        Assert.assertEquals(2, PairsWithGivenSum.getPairsCountWithSum(arr, 6));
    }

    @Test
    public void getPairsCountByHashing() {
        int arr[] = new int[]{1, 5, 7, -1};
        Assert.assertEquals(2, PairsWithGivenSum.getPairsCountByHashing(arr, 6));
    }

    @Test
    public void countOfThreeSum() {
        Stopwatch timer = new Stopwatch();
        int count = PairsWithGivenSum.countOfThreeSum(new int[]{-1, 2, -5, 0, 5});
        double time = timer.elapsedTime();
        System.out.println(count + " triples " + time);
    }

    @Test
    public void searchTripletsSumZero() {
        System.out.println(PairsWithGivenSum.searchTripletsSumZero(new int[]{-3, 0, 1, 2, -1, 1, -2}));
    }

    @Test
    public void searchTripletsSumNearNumber() {
        System.out.println(PairsWithGivenSum.searchTripletsSumNearNumber(new int[]{-2, 0, 1, 2}, 2));
    }

    @Test
    public void searchTripletsSumSmallerThanNumber() {
        System.out.println(PairsWithGivenSum.searchTripletsSumSmallerThanNumber(new int[]{-1, 0, 2, 3}, 3));
    }

    @Test
    public void returnTripletsSumSmallerThanNumber() {
        System.out.println(PairsWithGivenSum.returnTripletsSumSmallerThanNumber(new int[]{-1, 0, 2, 3}, 3));
    }

    @Test
    public void searchQuadrupletsSumNumber() {
        System.out.println(PairsWithGivenSum.searchQuadrupletsSumNumber(new int[]{4, 1, 2, -1, 1, -3}, 1));
    }


}