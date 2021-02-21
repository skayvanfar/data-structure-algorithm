package ir.sk.algorithm.array;

import ir.sk.algorithm.array.PowerSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/14/2021.
 */
public class PowerSetTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void powerSetRecursive() {
        Set<Integer> mySet = new HashSet<>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        Set<Set<Integer>> result = PowerSet.powerSetRecursive(mySet);
        System.out.println(result);
    }

    @Test
    public void findSubSets() {
        int[] integers = {1, 2, 3, 4, 5, 6, 7, 8};
        List<List<Integer>> result = PowerSet.findSubSets(integers);
        System.out.println(result);
    }

    @Test
    public void findSubsetsWithDuplicates() {
        int[] integers = {1, 5, 3, 3};
        List<List<Integer>> result = PowerSet.findSubsetsWithDuplicates(integers);
        System.out.println(result);
    }

    @Test
    public void powerSetBinary() {
        char set[] = {'a', 'b', 'c'};
        PowerSet.powerSetBinary(set);
    }

    @Test
    public void findPowerSetRecursive2() {
        int[] integers = {1, 5, 3};
        PowerSet.findPowerSetRecursive2(integers);
    }
}