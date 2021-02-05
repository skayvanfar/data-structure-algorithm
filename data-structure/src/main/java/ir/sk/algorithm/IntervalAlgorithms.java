package ir.sk.algorithm;

import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.Point;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.MultipleLoopsPattern;
import ir.sk.helper.technique.BruteForce;

import java.util.*;

/**
 * Created by sad.kayvanfar on 2/1/2021.
 */
public class IntervalAlgorithms {

    /**
     * @param intervals
     * @return
     */
    @TimeComplexity("O(n ^ 2)")
    @SpaceComplexity("O(n)")
    @MultipleLoopsPattern
    @BruteForce
    @Difficulty(type = DifficultyType.MEDIUM)
    public static List<Interval> mergeIntervalsNaive(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        List<Interval> toRemove = new ArrayList();

        for (int i = 0; i < intervals.size(); i++) {
            Interval currInterval1 = intervals.get(i);
            for (int j = i + 1; j < intervals.size(); j++) {
                Interval currInterval2 = intervals.get(i);
                if (currInterval2.start < currInterval1.end ||
                        currInterval2.end < currInterval1.start) {
                    currInterval1.start = Math.max(currInterval1.start, currInterval2.start);
                    currInterval1.end = Math.max(currInterval1.end, currInterval2.end);
                    toRemove.add(currInterval2);
                }
            }
            intervals.removeAll(toRemove);
        }

        return intervals;
    }

    /**
     * @param intervals
     * @return
     */
    @TimeComplexity("O(n * Log n)")
    @SpaceComplexity("O(n), O(N) as we need to return a list containing all the merged intervals. We will also need O(N) space for sorting.")
    @Point("For Java, depending on its version, Collection.sort() either uses Merge sort or Timsort, and both these algorithms need O(N)")
    @Difficulty(type = DifficultyType.MEDIUM)
    public static Interval[] mergeIntervalsByLoop(Interval[] intervals) {
        if (intervals.length < 2)
            return intervals;

        List<Interval> mergedIntervals = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        int start = intervals[0].start;
        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i].start;
            int currEnd = intervals[i].end;

            if (currStart < end) {
                end = Math.max(end, currEnd);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = currStart;
                end = currEnd;
            }
        }
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals.toArray(new Interval[1]);
    }

    /**
     * Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
     * <p>
     * Intervals: [[1,4], [2,5], [7,9]]
     * Output: [[1,5], [7,9]]
     * Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
     * one [1,5]
     * <p>
     * A simple aproach is to start from the first interval and compare it with all other intervals for overlapping, if it overlaps
     * with any other interval, then remove the other interval from the list and merge the other into the first interval.
     * Repeat the same steps for remaining intervals after first. This approach cannot be implemented in better than (n^2) time
     * <p>
     * An efficient approach is to first sort the intervals according to the stating time.
     * then we can combine all intervals in a linear traversal
     * <p>
     * Our goal is to merge the intervals whenever they overlap.
     *
     * @param intervals
     * @return
     */
    @TimeComplexity("O(n * Log n)")
    @SpaceComplexity("O(n), O(N) as we need to return a list containing all the merged intervals. We will also need O(N) space for sorting.")
    @Point("For Java, depending on its version, Collection.sort() either uses Merge sort or Timsort, and both these algorithms need O(N)")
    @Difficulty(type = DifficultyType.MEDIUM)
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
            if (interval.start <= end) { // overlapping intervals, adjust the 'end'
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

    /**
     * Given a set of intervals, find out if any two intervals overlap.
     * Intervals: [[1,4], [2,5], [7,9]]
     * Output: true
     * Explanation: Intervals [1,4] and [2,5] overlap
     * <p>
     * We can follow the same approach as discussed above to find if any two intervals overlap.
     *
     * @param intervals
     * @return
     */
    @TimeComplexity("O(n * Log n)")
    @SpaceComplexity("O(n), We will also need O(N) space for sorting.")
    @Difficulty(type = DifficultyType.MEDIUM)
    public static boolean hasOverlapIntervals(List<Interval> intervals) {
        if (intervals.size() < 2)
            return false;

        // O(n * log n)
        // sort intervals by start time
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

        @Point("Using iterator")
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;
        // O(n)
        while (intervalItr.hasNext()) {
            interval = intervalItr.next();
            if (interval.start <= end) { // overlapping intervals, adjust the 'end'
                return true;
            } else { // non-overlapping intervals reset
                start = interval.start;
                end = interval.end;
            }
        }

        return false;
    }

    /**
     * Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.
     * <p>
     * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
     * Output: [[1,3], [4,7], [8,12]]
     * Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
     * <p>
     * If the given list was not sorted, we could have simply appended the new interval to it and used the merge() function from Merge Intervals.
     * But since the given list is sorted, we should try to come up with a solution better than O(N * logN)
     * <p>
     * When inserting a new interval in a sorted list,
     * we need to first find the correct index where the new interval can be placed. In other words,
     * we need to skip all the intervals which end before the start of the new interval. So we can iterate through the given sorted listed of intervals and skip all the intervals
     * Once we have found the correct place, we can follow an approach similar to Merge Intervals to insert and/or merge the new interval.
     * <p>
     * Our overall algorithm will look like this:
     * <p>
     * Skip all intervals which end before the start of the new interval, i.e., skip all intervals with the following condition:
     * intervals[i].end < newInterval.start
     * Let’s call the last interval ‘b’ that does not satisfy the above condition. If ‘b’ overlaps with the new interval (a) (i.e. b.start <= a.end), we need to merge them into a new interval ‘c’:
     * c.start = min(a.start, b.start)
     * c.end = max(a.end, b.end)
     * We will repeat the above two steps to merge ‘c’ with the next overlapping interval.
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    @Difficulty(type = DifficultyType.MEDIUM)
    public static List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.isEmpty()) {
            return Arrays.asList(newInterval);
        }

        List<Interval> mergedIntervals = new ArrayList<>();

        int i = 0;

        // skip (and add to output) all intervals that come before the 'nextInterval'
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            mergedIntervals.add(intervals.get(i++));

        //merge all intervals that overlap with 'newInterval'
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        // insert the newInterval
        mergedIntervals.add(newInterval);

        // add all the remaining intervals to the output
        while (i < intervals.size())
            mergedIntervals.add(intervals.get(i++));

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
