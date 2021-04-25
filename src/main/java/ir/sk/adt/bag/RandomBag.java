package ir.sk.adt.bag;

/**
 * RandomBag API is the same as for Bag, except for the adjective random, which indicates that the iteration should provide
 * the items in random order (all N! permutations equally likely, for each iterator).
 *
 * Created by sad.kayvanfar on 4/25/2021.
 */
public interface RandomBag<T> extends Bag<T> {
}
