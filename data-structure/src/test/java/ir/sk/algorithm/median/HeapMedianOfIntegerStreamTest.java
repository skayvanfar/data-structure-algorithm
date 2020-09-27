package ir.sk.algorithm.median;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class HeapMedianOfIntegerStreamTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
    }

    @Test
    public void getMedian() {
    }

    @Test
    public void addAndGetMedian() {
        MedianOfIntegerStream mis = new HeapMedianOfIntegerStream();
        for (Map.Entry<Integer, Double> e : testcaseFixture().entrySet()) {
            mis.add(e.getKey());
            assertEquals(e.getValue(), (Double) mis.getMedian());
        }
    }

    private Map<Integer, Double> testcaseFixture() {
        return new LinkedHashMap<Integer, Double>() {{
            put(1, 1d);
            put(7, 4d);
            put(5, 5d);
            put(8, 6d);
            put(3, 5d);
            put(9, 6d);
            put(4, 5d);
        }};
    }
}