package ir.sk.datastructure.stack;

import ir.sk.helper.TimeComplexity;

/**
 * Created by sad.kayvanfar on 9/1/2020.
 */
public interface Stack<T> {

    /**
     * Add an item to the top of the stack.
     *
     * @param j
     */
    @TimeComplexity("O(1)")
    void push(T j);

    /**
     * Return true if and only if the stack is empty.
     *
     * @return
     */
    @TimeComplexity("O(1)")
    T pop();

    /**
     * Return the top of the stack.
     *
     * @return
     */
    @TimeComplexity("O(1)")
    T peek();

    /**
     * Return true if and only if the stack is empty.
     *
     * @return
     */
    boolean isEmpty();
}
