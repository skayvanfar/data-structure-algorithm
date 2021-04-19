package ir.sk.adt.buffer;

/**
 * a data type for a buffer in a text editor
 *
 * Created by sad.kayvanfar on 3/9/2021.
 */
public interface TextBuffer {

    /**
     * insert c at the cursor position
     *
     * @param c
     */
    void insert(char c);

    /**
     * delete and return the character at the cursor
     *
     * @return
     */
    char delete();

    /**
     * move the cursor k positions to the left
     *
     * @param k
     */
    void left(int k);

    /**
     * move the cursor k positions to the right
     *
     * @param k
     */
    void right(int k);

    int size();
}
