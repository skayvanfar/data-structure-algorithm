package ir.sk.helper;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 11/1/2020.
 */
public enum SlidingWindowPatternType {
    // Fixed window length k: the length of the window is fixed and it asks you to find something in the window such as
    // the maximum sum of all windows, the maximum or median number of each window.
    STATICALLY_RESIZABLE,
    // the window size is not fixed, usually it asks you to find the subarray that meets the criteria
    DYNAMICALLY_RESIZABLE;
}
