package sort;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] -  b[1] : a[0] - b[0]);
        int n = intervals.length;

        int[] pre = intervals[0];
        int removed = 0;

        for(int i = 1; i < n; i ++) {
            int[] cur = intervals[i];
            if(cur[0] == pre[0] && cur[1] >= pre[1]) {
                removed ++;
                pre = cur;
            } else if (pre[1] >= cur[1]) {
                removed ++;
            } else {
                //pre = cur[1] >= pre[1] ? cur : pre;
                pre = cur;
            }
        }
        return intervals.length - removed;
    }

}
