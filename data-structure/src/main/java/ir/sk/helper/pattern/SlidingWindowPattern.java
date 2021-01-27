package ir.sk.helper.pattern;

/**
 * Involves creating a window from an array or number from one position to another.
 * Depending on certain conditions the window will either increase or decrease the window.
 * It is useful for keeping track of a subset of data.
 * <p>
 * a window is formed over some part of data, and this window can slide over the data to capture different portions of it.
 *
 * idea of sliding window algorithm:
 *
 * O(n^2) into O(n+n)=O(n)
 * //////////////////////////////////////////////
 * int start = 0, end = 0;
 * ​
 * while (end < s.size()) {
 *     window.add(s[end]);
 *     right++;
 * ​
 *     while (start) {
 *         window.remove(s[start]);
 *         left++;
 *     }
 * }
 * //////////////////////////////////////////////
 * The data type of the window can vary depending on the situation, such as using the hash table as the counter,
 * or you can use an array to do the same, since we only deal with English letters.
 *
 * <p>
 * Created by sad.kayvanfar on 9/6/2020.
 */
public @interface SlidingWindowPattern {
    SlidingWindowPatternType type();
}

