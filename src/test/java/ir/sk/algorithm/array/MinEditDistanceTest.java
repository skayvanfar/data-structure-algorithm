package ir.sk.algorithm.array;

import ir.sk.algorithm.array.string.MinEditDistance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinEditDistanceTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void minEditDistanceNaive() {
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println(MinEditDistance.minEditDistanceNaive(str1, str2, str1.length(), str2.length()));
    }
}