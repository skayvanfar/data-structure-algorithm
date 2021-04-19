package ir.sk.adt.stack;

import ir.sk.helper.complexity.TimeComplexity;

/**
 * stack is ADT of the collection of elements with specific remove order = LIFO (last-in-first-out), allows duplicates, the most recent item
 * added to the stack is the first item to be removed.
 * <p>
 *
 * A  typical  reason  to use a stack iterator in an application is to save items  in  a  collection
 * while  at  the  same  time reversing their  relative  order
 *
 * Created by sad.kayvanfar on 9/1/2020.
 */
public interface Stack<T> {

    /**
     * Add an item to the top of the stack.
     *
     * @param item
     */
    @TimeComplexity("O(1)")
    void push(T item);

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
    @TimeComplexity("O(1)")
    boolean isEmpty();
}
