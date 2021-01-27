package ir.sk.datastructure.fundamental.linklist;

/**
 * Created by sad.kayvanfar on 1/27/2021.
 */
public class DoubledLink<T> {

    public T data;
    public DoubledLink<T> next;
    public DoubledLink<T> previous;

    public DoubledLink(T d) {
        data = d;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }
}
