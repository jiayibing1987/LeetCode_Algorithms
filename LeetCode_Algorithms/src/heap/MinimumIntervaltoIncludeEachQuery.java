package heap;

import java.util.*;

public class MinimumIntervaltoIncludeEachQuery {

    public int[] minInterval(int[][] intervals, int[] queries) {
        //int n = queries.length;
        int[] res = new int[queries.length];

        //map key is query, value is corresponding length
        Map<Integer, Integer> map = new HashMap<>();

        //PriorityQueue with possible overlapping intervals
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        //sort intervals and queries
        int[] sortedQueries = queries.clone();
        Arrays.sort(intervals, Comparator.comparingInt(ele -> ele[0]));
        Arrays.sort(sortedQueries);

        int i = 0;
        for(int query : sortedQueries) {
            for(; i<intervals.length && intervals[i][0] <= query; i++) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                pq.add(new int[]{r  - l + 1, r});
            }

            while(!pq.isEmpty() && pq.peek()[1] < query) {
                pq.poll();
            }
            if(pq.isEmpty()) {
                map.put(query, -1);
            } else {
                map.put(query, pq.peek()[0]);
            }
        }

        for(int j = 0; j < queries.length; j++) {
            res[j] = map.get(queries[j]);
        }
        return res;
    }
}
