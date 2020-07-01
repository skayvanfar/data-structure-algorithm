package ir.sk.datastructure.fundamental.linklist;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class DoubledLink<T> {

    public T data;                 // data item
    public DoubledLink<T> next;                  // next link in list
    public DoubledLink<T> previous;              // previous link in list
    // -------------------------------------------------------------
    public DoubledLink(T d)                // constructor
    { data = d; }
    // -------------------------------------------------------------
    public void displayLink()          // display this link
    { System.out.print(data + " "); }
}
