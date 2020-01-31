package ir.sk.algorithm;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class TowersOfHanoi {

    public static void doTowers(int topN,
                                char src, char inter, char dest) {
        if (topN == 1)
            System.out.println("Disk 1 from " + src + " to " + dest);
        else {
            doTowers(topN - 1, src, dest, inter);   // src to inter

            System.out.println("Disk " + topN +   // move bottom
                    " from " + src + " to " + dest);
            doTowers(topN - 1, inter, src, dest);   // inter to dest
        }
    }
}
