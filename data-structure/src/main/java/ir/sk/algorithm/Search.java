package ir.sk.algorithm;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class Search {

    /**
     * @param array
     * @param searchKey
     * @param <T>
     * @return
     */
    public static <T extends Comparable> int binarySearchByLoop(T array[], T searchKey) {

        int lowerBound = 0;
        int upperBound = array.length - 1;
        int curIn;
        while(true)
        {
            curIn = (lowerBound + upperBound ) / 2;
            if(array[curIn]==searchKey)
                return curIn; // found it
            else if(lowerBound > upperBound)
                return array.length; // can’t find it
            else // divide range
            {
                if(array[curIn].compareTo(searchKey) < 0)
                    lowerBound = curIn + 1; // it’s in upper half
                else
                    upperBound = curIn - 1; // it’s in lower half
            } // end else divide range
        } // end while
    } // end find()

    public static <T extends Comparable> int binarySearchByRecursive(T array[], T searchKey, int lowerBound, int upperBound) {
        int curIn;
        curIn = (lowerBound + upperBound ) / 2;
        if(array[curIn]==searchKey)
            return curIn; // found it
        else if(lowerBound > upperBound)
            return array.length; // can’t find it
        else // divide range
        {
            if(array[curIn].compareTo(searchKey) < 0) // it’s in upper half
                return binarySearchByRecursive(array, searchKey, curIn+1, upperBound);
            else // it’s in lower half
                return binarySearchByRecursive(array, searchKey, lowerBound, curIn-1);
        } // end else divide range
    } // end recFind()
}
