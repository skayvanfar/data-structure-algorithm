package ir.sk.algorithm.Intervals;

import ir.sk.algorithm.intervals.Interval;
import ir.sk.algorithm.intervals.MergeIntervalsByGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/5/2021.
 */
public class MergeIntervalsByGraphTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void merge() {
        Interval[] input = new Interval[]{
                new Interval(1, 4),
                new Interval(2, 5),
                new Interval(7, 9)
        };
        System.out.print("Merged intervals: ");
        MergeIntervalsByGraph intervalsByGraph = new MergeIntervalsByGraph();
        for (Interval interval : intervalsByGraph.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}