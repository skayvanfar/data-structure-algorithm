package ir.sk.adt;

/**
 * Time Complexity: O(h) where h is height of Binary Search Tree, if tree is balanced it becomes O(log n)
 * Design a data structure to do reservations of future jobs on a single machine under following constraints.
 * 1) Every job requires exactly k time units of the machine.
 * 2) The machine can do only one job at a time.
 * 3) Time is part of the system. Future Jobs keep coming at different times. Reservation of a future job is done only if there is no existing reservation within k time frame (after and before)
 * 4) Whenever a job finishes (or its reservation time plus k becomes equal to current time), it is removed from system.
 * <p>
 * Using BST
 *
 * @author <a href="sad.keyvanfar@gmail.com">Saeed Kayvanfar</a> on 7/3/2020.
 */
public class SingleResourceReservationBST {

    private Node root;

    public SingleResourceReservationBST() {
    }

    /**
     * BST insert to process a new reservation request at
     * a given time (future time) whiten time frame of new job(k).  This function does
     * reservation only if there is no existing job within
     * <p>
     * Time Complexity: O(h)
     *
     * @param time reservation time
     * @param k    time frame of new job
     */
    public void add(int time, int k) {
        root = addRecursive(root, time, k);
    }

    /**
     * Time Complexity: O(h)
     *
     * @param current
     * @param time    reservation time
     * @param k       time frame of new job
     * @return
     */
    private Node addRecursive(Node current, int time, int k) {

        if (current == null) {
            return new Node(time);
        }

        // Check if this job conflicts with existing reservations
        // if it conflicts it return the node which has conflict with
        if ((time - k < current.time) && (time + k > current.time))
            return current;

        // Otherwise, recur down the tree
        if (time < current.time) {
            current.left = addRecursive(current.left, time, k);
        } else if (time > current.time) {
            current.right = addRecursive(current.right, time, k);
        }

        return current;
    }

}

/**
 * store int values and keep a reference to each child
 */
class Node {

    // reservation time
    int time;
    Node left;
    Node right;

    Node(int time) {
        this.time = time;
        right = null;
        left = null;
    }
}
