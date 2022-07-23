package thirtydayschallenge;

import java.util.*;

public class CheapestFlightsWithinKStops {

    Map<Integer, List<int[]>> graph;
    int[] costs;
    int[] steps;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        graph = new HashMap<>();
        initGraph(n, flights);
        costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        steps = new int[n];
        Arrays.fill(steps, Integer.MAX_VALUE);

        process(flights, src, dst, k + 1);
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }

    private void process(int[][] flights, int src, int dst, int maxStep) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0, 0});

        while (!pq.isEmpty()) {
            int[] parent = pq.poll();
            if(parent[0] == dst)
                return;

            if(parent[2] == maxStep)
                continue;

            for (int[] child : graph.get(parent[0])) {
                int childCity = child[0];
                int cost = parent[1] + child[1];
                int step = parent[2] + 1;


                if(cost < costs[childCity]) {
                    costs[childCity] = cost;
                    steps[childCity] = step;
                    pq.add(new int[] {childCity, cost, step});
                } else if (step < maxStep) {
                    pq.add(new int[] {childCity, cost, step});
                }
            }
        }
    }

    private void initGraph(int n, int[][] flights) {
        for (int i = 0; i < n; i++)
            graph.put(i, new ArrayList<>());

        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops c = new CheapestFlightsWithinKStops();
        int[][] f = new int[][]{{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
        System.out.println(c.findCheapestPrice(5, f, 0, 2, 2));
    }

}
