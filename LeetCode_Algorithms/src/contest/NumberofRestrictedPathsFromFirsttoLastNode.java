package contest;

import java.util.*;

public class NumberofRestrictedPathsFromFirsttoLastNode {

    public int countRestrictedPaths(int n, int[][] edges) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        //inti graph
        initGraph(graph, edges);

        //calc the shortest path for each node on path
        int[] dist = findShortestPath(n, n, graph);

        //find number of all possible paths
        return countPath(graph, 1, n, new int[n+1], dist);
    }

    private int[] findShortestPath(int source, int n, Map<Integer, List<Node>> graph) {
        int[] dist = new int[n + 1];
        Set<Integer> processed = new HashSet<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.add(new int[] {0, source});

        while (!pq.isEmpty()) {
            //pick the node with the minimum value
            int curMin = pq.poll()[1];

            List<Node> children = graph.get(curMin);
            processed.add(curMin);
            if (children == null) continue;

            for (Node child : children) {
                int next = child.des;
                if (processed.contains(next) || dist[curMin] == Integer.MAX_VALUE) continue;
                int alt = dist[curMin] + child.weight;
                if (alt < dist[child.des]) {
                    dist[child.des] = alt;
                    pq.add(new int[]{dist[child.des], child.des});
                }
            }
        }
        return dist;
    }

    private int findMinDistance(int[] dist, Set<Integer> processed) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 1; v < dist.length; v++)
            if (!processed.contains(v) && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }

    private int countPath(Map<Integer, List<Node>> graph, int cur, int des, int[] memo, int[] dist) {
        if (cur == des) {
            return 1;
        }
        if (memo[cur] > 0) {
            return memo[cur];
        }
        if (!graph.containsKey(cur)) {
            return 0;
        }

        int res = 0;
        int m = (int) (Math.pow(10, 9) + 7);
        for (Node child : graph.get(cur)) {
            int next = child.des;
            if (dist[cur] > dist[next]) {
                res += countPath(graph, next, des, memo, dist) ;
                res = res % m;
            }
        }
        memo[cur] = res;
        return res;
    }

    private void initGraph(Map<Integer, List<Node>> graph, int[][] edges) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            //set u to v
            List<Node> childrenOfU = graph.getOrDefault(u, new ArrayList<>());
            childrenOfU.add(new Node(v, w));
            graph.put(u, childrenOfU);
            //set v to u
            List<Node> childrenOfV = graph.getOrDefault(v, new ArrayList<>());
            childrenOfV.add(new Node(u, w));
            graph.put(v, childrenOfV);
        }
    }

    class Node {
        int des;
        int weight;

        Node(int v, int w) {
            this.des = v;
            this.weight = w;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1, 2, 3}, {1, 3, 3}, {2, 3, 1}, {1, 4, 2}, {5, 2, 2}, {3, 5, 1}, {5, 4, 10}};
        System.out.println(new NumberofRestrictedPathsFromFirsttoLastNode().countRestrictedPaths(n, edges));
    }
}
