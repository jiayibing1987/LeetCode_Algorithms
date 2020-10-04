package twopointer;

import java.util.Arrays;

public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        int right = -1; int count = 0;
        for(int[] interval : intervals){
            if(interval[1] <= right) {
                count ++;
            } else {
                right = interval[1];
            }
        }
        return intervals.length - count;
    }

}
