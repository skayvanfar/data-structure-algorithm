package ir.sk.helper.pattern;

/**
 * (Hashtable)
 * includes two parts:
 * 1. Hashing: usually we can omit this part
 * 2. index: mandatory part
 *
 * You can use an object/map to collect a value and its frequency,
 * this is useful for algorithms that have multiple pieces of data that are being compared.
 * This pattern lets us avoid O(n²) time complexity when it comes to strings/arrays.
 * <p>
 * if hashtable use, Using hashtable is trade off between time and space change Multiply O(n)*O(n) into O(n)+O(n) by using hashtable
 * <p>
 * This can often avoid the need for nested loops or O(n^2) operations with arrays/strings.
 * <p>
 * there are different ADT you can use, like int array, boolean array(in case most frequency is 1), Map(saving other frequency), BitSet, int,
 * Of Course you can use other data structures like TreeSet instead of hashtable, but Time complexity decrease into O(Log n).
 * <p>
 * Created by sad.kayvanfar on 9/6/2020.
 */
public @interface HashingIndexPattern {
    String value() default "";
}
