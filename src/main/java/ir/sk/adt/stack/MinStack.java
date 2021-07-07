package ir.sk.adt.stack;

import ir.sk.helper.complexity.TimeComplexity;

/**
 * a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin()
 * which should return minimum element from the Stack. All these operations of SpecialStack must be O(1)
 *
 * Created by sad.kayvanfar on 7/7/2021.
 */
public interface MinStack<T> extends Stack<T> {

    @TimeComplexity("O(1)")
    T min();
}
