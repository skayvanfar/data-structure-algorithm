package ir.sk.adt.dictionary;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 8/24/2020.
 */
class OpenAddressingHashNode<K, V> {

    K key;
    V value;

    public OpenAddressingHashNode() {
    }

    public OpenAddressingHashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
