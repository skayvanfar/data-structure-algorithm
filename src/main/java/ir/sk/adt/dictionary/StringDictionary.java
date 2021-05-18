package ir.sk.adt.dictionary;

public interface StringDictionary<V> extends Dictionary<String, V> {

    int size();

    Iterable<String> keys();

    boolean contains(String key);

    String longestPrefixOf(String s);

    Iterable<String> keysWithPrefix(String s);

    Iterable<String> keysThatMatch(String s);

}
