package binarysearch;

import java.util.TreeMap;

public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return null;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<intervals.length; i++) {
            map.put(intervals[i][0], i);
        }

        int[] res = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            Integer key = map.ceilingKey(intervals[i][1]);
            if(key == null)
                res[i] = -1;
            else
                res[i] = map.get(key);
        }

        return res;
    }

}
