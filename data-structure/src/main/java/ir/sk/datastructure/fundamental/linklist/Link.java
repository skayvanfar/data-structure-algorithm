package ir.sk.datastructure.fundamental.linklist;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class Link<T> {

    public T data; // data item

    public Link next; // next link in list

    public Link(T id) {
        data = id; // initialize data
    }

    public void displayLink() {
        System.out.print(" {" + data + "} ");
    }

}
