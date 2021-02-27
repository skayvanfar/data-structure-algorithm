package ir.sk.algorithm.median;

/**
 * ADT
 * Median of Stream of Integers
 * median of a stream of integers as the median of the set of integers read so far
 * <p>
 * Created by sad.keyvanfar on 8/23/2020.
 */
public interface MedianOfIntegerStream {

    /**
     * Add the integer to the set of integers
     *
     * @param num
     */
    void add(int num);

    /**
     * Find the median of the integers read so far
     *
     * @return
     */
    double getMedian();
}
