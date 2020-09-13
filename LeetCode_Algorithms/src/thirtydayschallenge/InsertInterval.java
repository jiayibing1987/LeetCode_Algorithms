package thirtydayschallenge;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> results = new ArrayList<>();
        int[] mergedInterval = newInterval;
        if(newInterval == null || newInterval.length == 0)
            return intervals;
        else if(intervals == null || intervals.length == 0 )
            return new int[][]{newInterval};

        for(int i=0; i<intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if(isOverlap(currentInterval, newInterval) == -1) {
                results.add(currentInterval);
                mergedInterval = newInterval;
            }else if(isOverlap(currentInterval, newInterval) == 0) {
                mergedInterval = mergeIntervals(currentInterval, mergedInterval);
            }else{
                if(mergedInterval != null){
                    results.add(mergedInterval);
                    mergedInterval = null;
                }
                results.add(currentInterval);
            }
        }
        if(mergedInterval != null) results.add(mergedInterval);
        return results.toArray(new int[results.size()][2]);
    }

    private int[] mergeIntervals(int[] a, int[] b) {
        int[] merged = new int[2];
        merged[0] = Math.min(a[0], b[0]);
        merged[1] = Math.max(a[1], b[1]);
        return merged;
    }

    private int isOverlap(int[] a, int[] b) {
        if(a[0]< b[0] && a[1] < b[0])
            return -1;
        else if(b[0] < a[0] && b[1] < a[0])
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int [] b = {4,8};
       // System.out.println(new InsertInterval().insert(a, b));
    }

}
