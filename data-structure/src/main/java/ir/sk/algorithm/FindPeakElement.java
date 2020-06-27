package ir.sk.algorithm;

/**
 * Created by sad.keyvanfar on 6/27/2020.
 */
public class FindPeakElement {

    /**
     * to find peak element by linear traverse and iterative
     * Time complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static boolean findPeakByLoop(int array[], int low, int high) {
        // first or last element is peak element
        if (array.length == 1)
            return true;
        if (array[0] >= array[1])
            return true;
        if (array[array.length - 1] >= array[array.length - 2])
            return true;

        // check for every other element
        for (int i = 1; i < array.length - 1; i++) {
            // check if the neighbors are smaller
            if (array[i] >= array[i - 1] && array[i] >= array[i + 1])
                return true;
        }
        return false;
    }

    /**
     * to find peak element by decrease-and-conquer (Divide-and-conquer algorithm) and recursive
     * Time Complexity: O(Logn)
     * Space complexity: O(1)
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static boolean findPeakByRecursive(int array[], int low, int high) {
        if (low > high)
            return false;
        int mid = (low + high) / 2;
        if (array[mid] >= array[mid - 1] && array[mid] >= array[mid + 1])
            return true;
        else if (array[mid] < array[mid - 1])
            return findPeakByRecursive(array, low, mid - 1);
        else
            return findPeakByRecursive(array, mid + 1, high);
    }

    /**
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static boolean findPeakIn2DArrayByLoop(int array[][], int low, int high) {
        // first or last element is peak element
        if (array.length == 1)
            return true;
        if (array[0][0] >= array[0][1] && array[0][0] >= array[1][0])
            return true;
        if (array[array.length - 1][array.length - 1] >= array[array.length - 1][array.length - 2]
                && array[array.length - 1][array.length - 1] >= array[array.length - 2][array.length - 1])
            return true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][0] >= array[i][1] && array[i][0] >= array[i - 1][0] && array[i][0] >= array[i + 1][0]
                            && array[i][array.length-1] >= array[i][array.length-2] && array[i][array.length-1] >= array[i - 1][array.length-1] && array[i][array.length-1] >= array[i + 1][array.length-1])
                    return true;
            }
        }

        // check for every other element
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 0; j < array[i].length; j++) {
                // check if the neighbors are smaller
                if (array[i][j] >= array[i][j - 1] && array[i][j] >= array[i][j + 1]
                        && array[i][j] >= array[i - 1][j] && array[i][j] >= array[i + 1][j])
                    return true;
            }
        }
        return false;
    }
}
