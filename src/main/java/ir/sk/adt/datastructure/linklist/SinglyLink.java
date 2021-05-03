package ir.sk.adt.datastructure.linklist;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class SinglyLink<T> {

    public T data;

    public SinglyLink<T> next;

    public SinglyLink() {
    }

    public SinglyLink(T data) {
        this.data = data;
    }

    public SinglyLink(T data, SinglyLink next) {
        this.data = data;
        this.next = next;
    }

    public void displayLink() {
        System.out.print(" {" + data + "} ");
    }

}
