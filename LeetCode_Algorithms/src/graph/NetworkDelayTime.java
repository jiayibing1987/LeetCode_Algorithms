package graph;

import java.util.*;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int N, int K) {
        int res = 0;
        Map<Integer, List<Pair>> graph = new HashMap<>();
        initGraph(times, graph);
        Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.time - b.time);
        queue.add(new Pair(K, 0));
        visited.put(K, 0);

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            if (graph.containsKey(cur.node)) {
                for (Pair child : graph.get(cur.node)) {
                    if (!visited.containsKey(child.node)) {
                        queue.add(new Pair(child.node, child.time + cur.time));
                        visited.put(child.node, child.time + cur.time);
                    } else {
                        //visited.put(child.node, Math.min(visited.get(child.node), child.time + cur.time));
                    }
                }
            }
            //visited.put(cur.node, Math.min(visited.getOrDefault(cur.node, Integer.MAX_VALUE), cur.time));
        }
        if(visited.size() != N ) return -1;
        for(int time : visited.values())
            res = Math.max(res, time);
        return res;
    }

    private void initGraph(int[][] times, Map<Integer, List<Pair>> graph) {
        for (int i = 0; i < times.length; i++) {
            int[] edge = times[i];
            if (!graph.containsKey(edge[0])) {
                List<Pair> edges = new ArrayList<>();
                graph.put(edge[0], edges);
            }
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));

        }
    }

    class Pair {
        int node;
        int time;

        public Pair(int node, int cost) {
            this.node = node;
            this.time = cost;
        }
    }

    public static void main (String[] args) {
        NetworkDelayTime n= new NetworkDelayTime();
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.print(n.networkDelayTime(times, 4, 2));
    }
}
