package ir.sk.adt.set;

public class BSTSet<T extends Comparable> implements Set<T> {

    private Node root;             // root of BST

    private class Node {
        private T value;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(T value, int size) {
            this.value = value;
            this.size = size;
        }
    }

    @Override
    public void add(T item) {
        if (item == null) throw new IllegalArgumentException("calls add() with a null item");
        root = add(root, item);
    }

    private Node add(Node x, T item) {
        if (x == null) return new Node(item, 1);
        int cmp = item.compareTo(x.value);
        if      (cmp < 0) x.left  = add(x.left,  item);
        else if (cmp > 0) x.right = add(x.right, item);
        else              x.value   = item;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public void remove(T item) {
        // TODO: 5/5/21
    }

    @Override
    public boolean isEmpty() {
        return false;
        // TODO: 5/5/21
    }

    @Override
    public boolean contains(T item) {
        return contains(root, item);
    }

    private boolean contains(Node x, T key) {
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null) return false;
        int cmp = key.compareTo(x.value);
        if      (cmp < 0) return contains(x.left, key);
        else if (cmp > 0) return contains(x.right, key);
        else              return true;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }
}
