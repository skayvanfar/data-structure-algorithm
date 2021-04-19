package ir.sk.datastructure.dictionary;

import ir.sk.helper.Point;
import ir.sk.helper.complexity.AmortizedTimeComplexity;
import ir.sk.helper.complexity.TimeComplexity;

/**
 * Hash table or hash map is a data structure that
 * stores the keys and their associated values, and hash table uses a hash function to map keys to
 * their associated values.
 * <p>
 * There are only three basic operations on Dictionary: searching, inserting, and deleting.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 8/24/2020.
 */
public interface Dictionary<K, V> {

    @AmortizedTimeComplexity("O(1)")
    void add(K key, V value);

    @TimeComplexity("O(1)")
    @Point("the best time complexity for search, others: linear:O(n), Binary:O(log n)")
    V get(K key);

    @AmortizedTimeComplexity("O(1)")
    V remove(K key);
}
