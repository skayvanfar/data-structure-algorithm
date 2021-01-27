package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sad.kayvanfar on 1/10/2021.
 */
public class ArrayAlgorithmsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findWord() {
        boolean result = ArrayAlgorithms.findWord(new char[][]{{'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'}}, "FOAM".toCharArray());
        System.out.println(result);
    }

    @Test
    public void loopExistsInCircularArray() {
        System.out.println(ArrayAlgorithms.loopExistsInCircularArray(new int[]{1, 2, -1, 2, 2}));
        System.out.println(ArrayAlgorithms.loopExistsInCircularArray(new int[]{2, 2, -1, 2}));
        System.out.println(ArrayAlgorithms.loopExistsInCircularArray(new int[]{2, 1, -1, -2}));
    }

    @Test
    public void makeSquaresSortedArray() {
        System.out.println(Arrays.toString(ArrayAlgorithms.makeSquaresSortedArray(new int[]{-2, -1, 0, 2, 3})));
    }

    @Test
    public void searchTripletsSumZero() {
        System.out.println(ArrayAlgorithms.searchTripletsSumZero(new int[]{-3, 0, 1, 2, -1, 1, -2}));
    }

    @Test
    public void searchTripletsSumNearNumber() {
        System.out.println(ArrayAlgorithms.searchTripletsSumNearNumber(new int[]{-2, 0, 1, 2}, 2));
    }
}