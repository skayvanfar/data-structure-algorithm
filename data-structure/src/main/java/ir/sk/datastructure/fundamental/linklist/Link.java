package ir.sk.datastructure.fundamental.linklist;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class Link<T> {

    public T data;

    public Link next;

    public Link(T data) {
        this.data = data;
    }

    public Link(T data, Link next) {
        this.data = data;
        this.next = next;
    }

    public void displayLink() {
        System.out.print(" {" + data + "} ");
    }

}
