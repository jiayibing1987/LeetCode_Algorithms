package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals,(a,b) -> a[1] - b[1]);

        int count = 0;
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            //non-overlapping
            if(intervals[i][0] >= end)
                end = intervals[i][1];
            else
                count ++;
        }
        return count;
    }


    public int eraseOverlapIntervals1(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals,(a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int count = 0;
        int low = 0;
        int high = 1;

        while(high < intervals.length) {
            //if overlapping, remove low or high which ends pointer is bigger, count ++
            if(intervals[low][1] > intervals[high][0]) {
                count ++;
                //if remove low, low = high, high++
                if(intervals[low][1] >= intervals[high][1]) {
                    low = high;
                    high ++;
                }else { //if remove high, low remain the same high ++
                    high ++;
                }
            } else { //else no overlapping, low = high, high ++
                low = high;
                high ++;
            }
        }
        return count;
    }

}
