package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1)
            return points.length;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int[] intersectionInterval = points[0];
        int count = 1;

        for (int i=1; i<points.length; i++) {
            int[] currentInterval = points[i];
            if (currentInterval[0] <= intersectionInterval[1]) {
                intersectionInterval[0] = currentInterval[0];
                intersectionInterval[1] = Math.min(currentInterval[1], intersectionInterval[1]);
            } else {
                count++;
                intersectionInterval = currentInterval;
            }
        }

        return count;
    }

    public static void main (String[] args) {
        int[][] a = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(new MinimumNumberofArrowstoBurstBalloons().findMinArrowShots(a));
    }
}
