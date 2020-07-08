package ir.sk.datastructure.fundamental.hashing;

/**
 * Created by sad.keyvanfar on 7/8/2020.
 */
class ChainingHashNode<K, V> {

    K key;
    V value;

    // Reference to next node
    ChainingHashNode<K, V> next;

    public ChainingHashNode() {
    }

    public ChainingHashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
