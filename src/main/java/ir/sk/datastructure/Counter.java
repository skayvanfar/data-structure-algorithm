package ir.sk.datastructure;

/**
 * a simple data type named Counter whose values are a name and a non
 * negative integer and whose operations are create and initialize to zero, increment by one, and
 * examine the current value. This abstraction is useful in many contexts. For example, it
 * would be reasonable to use such a data type in electronic voting software, to ensure that
 * the only thing that a voter can do is increment a chosen candidate’s tally by one. Or,
 * we might use a Counter to keep track of fundamental operations when analyzing the
 * performance of algorithms.
 */
public class Counter {

    private final String name;
    private int count;


    public Counter(String id) {
        name = id;
    }

    public void increment() {
        count++;
    }

    public int tally() {
        return count;
    }


    public String toString() {
        return count + " " + name;
    }
}
