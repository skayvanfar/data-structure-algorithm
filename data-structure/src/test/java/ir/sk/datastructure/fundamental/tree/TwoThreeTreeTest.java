package ir.sk.datastructure.fundamental.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sad.keyvanfar on 7/28/2020.
 */
public class TwoThreeTreeTest {
    TwoThreeTree twoThreeTree;

    @Before
    public void setUp() throws Exception {
        twoThreeTree = new TwoThreeTree();
        for (int i = 0; i < 10; i++) {
            twoThreeTree.insert(i);
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        twoThreeTree.bfsList();
    }

    @Test
    public void search() {
        System.out.println(activityNotifications2(new int[]{2 ,3 ,4, 2 ,3, 6, 8, 4, 5}, 5));
    }

    static int activityNotifications(int[] expenditure, int d) {

        int count=0;
        for (int i = d; i < expenditure.length; i++) {
            double median = median(Arrays.copyOfRange(expenditure,i-d,i));
            if (expenditure[i] >= median * 2)
                count++;
            expenditure[i]++;
        }
        return count;
    }

    public static double median(int a[]) {
        Arrays.sort(a);

        // check for even case
        if (a.length % 2 != 0)
            return (double)a[a.length / 2];

        return (double)(a[(a.length - 1) / 2] + a[a.length / 2]) / 2.0;
    }

    static int activityNotifications2(int[] expenditure, int d) {;

        int notificationCount = 0;

        int[] data = new int[201];
        for (int i = 0; i < d; i++) {
            data[expenditure[i]]++;
        }

        for (int i = d; i < expenditure.length; i++) {

            double median = getMedian(d, data);

            if (expenditure[i] >= 2 * median) {
                notificationCount++;

            }

            data[expenditure[i]]++;
            data[expenditure[i - d]]--;

        }

        return notificationCount;

    }

    private static double getMedian(int d, int[] data) {
        double median = 0;
        if (d % 2 == 0) {
            Integer m1 = null;
            Integer m2 = null;
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (m1 == null && count >= d/2) {
                    m1 = j;
                }
                if (m2 == null && count >= d/2 + 1) {
                    m2 = j;
                    break;
                }
            }
            median = (m1 + m2) / 2.0;
        } else {
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (count > d/2) {
                    median = j;
                    break;
                }
            }
        }
        return median;
    }

    @Test
    public void remove() {
    }
}