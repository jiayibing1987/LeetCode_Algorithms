package graph;

import util.Pair;

import java.util.*;

public class PathwithMaximumProbability {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        initGraph(graph, edges, succProb, n);

        double[] max_prob = new double[n];
        max_prob[start] = 1;
        PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>((a, b) -> (int) (b.getValue() - a.getValue()));
        pq.add(new Pair<>(start, 1.0d));

        while(!pq.isEmpty()) {
            Pair<Integer, Double> cur = pq.poll();
            int u = cur.getKey();
            double source_prob = cur.getValue();
            if(source_prob < max_prob[u]) continue;

            for(Pair<Integer, Double> value : graph.get(u)) {
                int v = value.getKey();
                double edge_prob = value.getValue();
                double acc_prob = source_prob * edge_prob;
                if(acc_prob > max_prob[v]) {
                    max_prob[v] = acc_prob;
                    pq.add(new Pair<> (v, acc_prob));
                }
            }
        }
        return max_prob[end];
    }

    private void initGraph(Map<Integer, List<Pair<Integer, Double>>> graph, int[][] edges, double[] succProb, int n) {
        int len = edges.length;
        for(int i = 0; i < n; i ++) {
            graph.put(i, new ArrayList<>());
        }
        for(int i = 0; i < len; i ++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Pair (v, prob));
            graph.get(v).add(new Pair (u, prob));
        }
    }

//    3
//            [[0,1],[1,2],[0,2]]
//            [0.5,0.5,0.2]
//            0
//            2
    public static void main(String[] args) {
        PathwithMaximumProbability path = new PathwithMaximumProbability();
        int[][] edges = new int[][] {{0,1},{1,2},{0,2}};
        double[] p1 = new double[] {0.5,0.5,0.2};
        System.out.println(path.maxProbability(3, edges, p1, 0, 2));
    }
}
