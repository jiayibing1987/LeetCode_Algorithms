package sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, new TimeComparator());
        int n = timePoints.size();

        int min = 24 * 60;
        for(int i = 0; i < n - 1; i ++) {
            int diff = getTimeDiff(timePoints.get(i), timePoints.get(i + 1));
            min = Math.min(min, diff);
        }
        int lastDiff = getTimeDiff(timePoints.get(n - 1), "23:59") + getTimeDiff("00:00", timePoints.get(0));
        return Math.min(min, lastDiff);
    }

    private int getTimeDiff(String s1, String s2) {
        String[] a1 = s1.split(":");
        String[] a2 = s2.split(":");

        int h1 = Integer.valueOf(a1[0]);
        int h2 = Integer.valueOf(a2[0]);

        int m1 = Integer.valueOf(a1[1]);
        int m2 = Integer.valueOf(a2[1]);

        int diff = 0;
        if(m2 < m1) {
            diff -= m1 - m2;
            m2 = m1;
        }
        diff += (h2 - h1) * 60 + (m2 - m1);
        return diff;
    }

    static class TimeComparator implements Comparator<String> {

        public int compare(String s1, String s2) {
            String[] a1 = s1.split(":");
            String[] a2 = s2.split(":");

            int h1 = Integer.valueOf(a1[0]);
            int h2 = Integer.valueOf(a2[0]);

            int m1 = Integer.valueOf(a1[1]);
            int m2 = Integer.valueOf(a2[1]);

            if(h1 == h2)
                return m1 - m2;
            return h1 - h2;
        }

    }
}
