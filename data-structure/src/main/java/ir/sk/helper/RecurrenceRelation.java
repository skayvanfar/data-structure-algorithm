package ir.sk.helper;

/**
 * Recurrence	Algorithm	Big-Oh Solution
 * T(n) = T(n/2) + O(1)	Binary Search	O(log n)
 * T(n) = T(n-1) + O(1)	Sequential Search	O(n)
 * T(n) = 2 T(n/2) + O(1)	tree traversal	O(n)
 * T(n) = T(n-1) + O(n)	Selection Sort (other n2 sorts)	O(n2)
 * T(n) = 2 T(n/2) + O(n)	Mergesort (average case Quicksort)	O(n log n)
 *
 * Created by sad.kayvanfar on 1/3/2021.
 */
public @interface RecurrenceRelation {
    String value();
}
