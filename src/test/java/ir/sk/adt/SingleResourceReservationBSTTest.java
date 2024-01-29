package ir.sk.adt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="sad.keyvanfar@gmail.com">Saeid Keyvanfar</a> on 7/3/2020.
 */
public class SingleResourceReservationBSTTest {

    private SingleResourceReservationBST reservationBST;

    @Before
    public void setUp() throws Exception {
        reservationBST = new SingleResourceReservationBST();

        reservationBST.add(6, 3);
        reservationBST.add(2, 3);
        reservationBST.add(10, 3);
        reservationBST.add(20, 3);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        reservationBST.add(11, 3);
        reservationBST.add(13, 3);
    }
}