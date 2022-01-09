package contest;

import java.util.PriorityQueue;

public class EarliestPossibleDayofFullBloom {

    public int earliestFullBloom(int[] p, int[] g) {
        int n = p.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i = 0; i < n; i ++) {
            pq.add(new int[] {p[i], g[i]});
        }

        int end = 0;
        int start = 0;
        while(!pq.isEmpty()) {
            int[] range = pq.poll();
            int curEnd = start + range[0] + range[1];
            end = Math.max(end, curEnd);
            start += range[0];
        }
        return end;
    }

    public static void main(String[] args) {
        EarliestPossibleDayofFullBloom e = new EarliestPossibleDayofFullBloom();
        int[] a1 = new int[]{1,4,3};
        int[] b1 = new int[]{2,3,1};
        System.out.println(e.earliestFullBloom(a1, b1));

        int[] a2 = new int[]{1,2,3,2};
        int[] b2 = new int[]{2,1,2,1};
        System.out.println(e.earliestFullBloom(a2, b2));
    }
}
