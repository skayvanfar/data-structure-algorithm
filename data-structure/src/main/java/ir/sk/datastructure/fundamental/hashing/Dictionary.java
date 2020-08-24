package ir.sk.datastructure.fundamental.hashing;

/**
 * Hash table or hash map is a data structure that
 * stores the keys and their associated values, and hash table uses a hash function to map keys to
 * their associated values.
 *
 * There are only three basic operations on Dictionary: searching, inserting, and deleting.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 8/24/2020.
 */
public interface Dictionary<K, V> {
    void add(K key, V value);
    V get(K key);
    V remove(K key);
}
