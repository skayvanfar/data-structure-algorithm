package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/5/2020.
 */
public class FirstRepeatedCharTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void firstRepeatedChar() {
        char[] array = new char[] {'a', 'b', 'l', 'b', 'x'};
        char expectedValue = 'b';
        long startTime = System.nanoTime();
        char result = FirstRepeatedChar.firstRepeatedCharByTwoLoops(array);
        long endTime = System.nanoTime();
        System.out.println("time duration for firstRepeatedChar by n= "+ array.length + " = "+(endTime-startTime)+ " nano");
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void firstRepeatedChar2() {
        char[] array = new char[] {'a', 'b', 'l', 'b', 'x'};
        char expectedValue = 'b';
        long startTime = System.nanoTime();
        char result = FirstRepeatedChar.firstRepeatedCharByHash(array);
        long endTime = System.nanoTime();
        System.out.println("time duration for firstRepeatedChar by n= "+ array.length + " = "+(endTime-startTime)+ " nano");
        Assert.assertEquals(expectedValue, result);
    }
}