package ir.sk.algorithm.array;

import org.junit.Assert;
import org.junit.Test;

import ir.sk.algorithm.mathematic.SelectionProblem;

public class SelectionProblemTest {
     @Test
    public void median() {
        int a[] = {1, 3, 4, 2, 7, 5, 8, 6};
        String expectedValue = "4.5";
        Assert.assertEquals(expectedValue, SelectionProblem.median(a) + "");
    }

    @Test
    public void medianUsingCountingSort() {
        int a[] = {1, 3, 4, 2, 7, 5, 8, 6};
        String expectedValue = "4.5";
        Assert.assertEquals(expectedValue, SelectionProblem.medianUsingCountingSort(a) + "");
    }
}
