package graph;

import java.util.*;

public class CriticalConnectionsinaNetwork {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> edges = new HashSet<>(connections);

        initGraph(n, connections);
        dfs(0, 0, edges);

        return new ArrayList<>(edges);
    }

    private int dfs (int depth, int node, Set<List<Integer>> edges) {
        if(rank.get(node) != null) {
            return rank.get(node);
        }
        rank.put(node, depth);

        int min = Integer.MAX_VALUE;
        for(int adj : graph.get(node)) {
            if(rank.get(adj) != null && depth - rank.get(adj) == 1)
                continue;
            int minDepth = dfs(depth + 1, adj, edges);
            min = Math.min(minDepth, min);
            //remove edge between [node, adj], if node itself or it's parent node is reachable by adjacent node
            if(minDepth <= depth) {
                edges.remove(List.of(adj, node));
                edges.remove(List.of(node, adj));
            }
        }
        return min;
    }

    private void initGraph (int n, List<List<Integer>> connections) {
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            rank.put(i, null);
        }
        for(List<Integer> connection : connections) {
            int a = connection.get(0);
            int b = connection.get(1);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }
}
