package ir.sk.datastructure.fundamental.linklist;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
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
