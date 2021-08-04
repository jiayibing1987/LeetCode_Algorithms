package graph;

import java.util.*;

public class OptimizeWaterDistribution {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        List<int[]> edges = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            edges.add(new int[] {0, i, wells[i-1]});
        }
        for(int[] edge : pipes) {
            edges.add(edge);
        }
        Collections.sort(edges, (a, b) -> a[2] - b[2]);

        int cost = 0;
        for(int[] edge : edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            if(x != y) {
                union(parent, x, y);
                cost += edge[2];
            }
        }
        return cost;
    }

    private int find(int[] parent, int a) {
        int cur = a;
        while(parent[cur] != -1) {
            cur = parent[cur];
        }
        return cur;
    }

    private int union(int[] parent, int a, int b) {
        parent[b] = a;
        return a;
    }

}
