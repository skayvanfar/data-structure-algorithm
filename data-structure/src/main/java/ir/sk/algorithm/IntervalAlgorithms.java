package ir.sk.algorithm;

import ir.sk.helper.Point;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

import java.util.*;

/**
 * Created by sad.kayvanfar on 2/1/2021.
 */
public class IntervalAlgorithms {

    /**
     * Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
     *
     * Intervals: [[1,4], [2,5], [7,9]]
     * Output: [[1,5], [7,9]]
     * Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
     * one [1,5]
     *
     * Our goal is to merge the intervals whenever they overlap.
     *
     *
     * @param intervals
     * @return
     */
    @TimeComplexity("O(n * Log n)")
    @SpaceComplexity("O(n), O(N) as we need to return a list containing all the merged intervals. We will also need O(N) space for sorting.")
    @Point("For Java, depending on its version, Collection.sort() either uses Merge sort or Timsort, and both these algorithms need O(N)")
    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        // O(n * log n)
        // sort intervals by start time
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

        List<Interval> mergedIntervals = new LinkedList<>();
        @Point("Using iterator")
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;
        // O(n)
        while (intervalItr.hasNext()) {
            interval = intervalItr.next();
            if( interval.start <= end) { // overlapping intervals, adjust the 'end'
                end = Math.max(interval.end, end);
            } else { // non-overlapping intervals, add the previous interval and reset
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // add the last interval
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }
}

class Interval {
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
