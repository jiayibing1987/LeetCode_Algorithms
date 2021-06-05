package heap;

import java.util.PriorityQueue;

public class MaximumPerformanceofaTeam {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int m = 1000000000 + 7;
        //sort by efficiency decreasing order
        PriorityQueue<int[]> candidates = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        //sort by speed increasing order
        PriorityQueue<int[]> selected = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            candidates.add(new int[]{speed[i], efficiency[i]});
        }

        long sum = 0;
        long max = 0;
        while (!candidates.isEmpty()) {
            int[] candidate = candidates.poll();
            long curEffi = candidate[1];

            if (selected.size() == k) {
                int smallestSpeed = selected.poll()[0];
                sum -= smallestSpeed;
            }

            selected.add(candidate);
            sum += candidate[0];
            max = Math.max(max , sum * curEffi);

        }
        return (int) (max % m);
    }

    public static void main(String[] args) {
        MaximumPerformanceofaTeam m = new MaximumPerformanceofaTeam();
        int[] s1 = new int[]{2, 10, 3, 1, 5, 8};
        int[] e1 = new int[]{5, 4, 3, 9, 7, 2};

        System.out.println(m.maxPerformance(6, s1, e1, 3));
    }
}
