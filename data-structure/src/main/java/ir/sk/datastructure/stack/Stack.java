package ir.sk.datastructure.stack;

/**
 * Created by sad.kayvanfar on 9/1/2020.
 */
public interface Stack<T> {

    void push(T j);

    T pop();

    T peek();

    boolean isEmpty();
}
