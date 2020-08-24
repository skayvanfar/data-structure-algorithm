package ir.sk.algorithm;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 8/24/2020.
 */
public class NumeralSystem {

    /**
     *  convert the given decimal number into equivalent number by different base
     * @param number
     * @param base
     */
    public static void convertFromBase(int number, int base) {
        // array to store binary number
        int[] num = new int[1000];

        // counter for binary array
        int i = 0;
        while (number > 0)
        {
            // storing remainder in binary array
            num[i] = number % base;
            number = number / base;
            i++;
        }

        // printing num array in reverse order
        for (int j = i - 1; j >= 0; j--)
            System.out.print(num[j]);
    }
}
