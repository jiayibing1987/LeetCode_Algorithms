package array;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {
    TreeMap<Integer, int[]> startMap;
    TreeMap<Integer, int[]> endMap;

    public MyCalendar() {
        startMap = new TreeMap<>();
        endMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if(start >= end || start < 0)
            return false;

        Map.Entry<Integer, int[]> e1 = endMap.higherEntry(start);
        if(e1 != null && e1.getValue()[0] < end)
            return false;

        Map.Entry<Integer, int[]> e2 = startMap.lowerEntry(end);
        if(e2 != null && e2.getValue()[1] > start)
            return false;

        int[] interval = new int[] {start, end};
        startMap.put(start, interval);
        endMap.put(end, interval);
        return true;
    }
}
