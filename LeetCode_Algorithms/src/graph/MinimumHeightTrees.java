package graph;

import java.util.*;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        if(n <= 2) {
            res.add(edges[0][0]);
            return res;
        }

        for(int i=0; i<n; i++) {
            graph.put(i, new HashSet<>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] depth1 = new int[n];
        bfs(0, graph, depth1, new int[n]);
        int topLeafNode = 0;
        for(int i=0; i<n; i++) {
            if(depth1[i] > depth1[topLeafNode])
                topLeafNode = i;
        }

        int[] depth2 = new int[n];
        int[] parent = new int[n];
        bfs(topLeafNode, graph, depth2, parent);
        int bottomLeafNode = 0;
        for(int i=0; i<n; i++) {
            if(depth2[i] > depth2[bottomLeafNode])
                bottomLeafNode = i;
        }

        int curNode = bottomLeafNode;
        List<Integer> longestPath = new ArrayList<>();
        longestPath.add(bottomLeafNode);
        while(parent[curNode] != -1) {
            longestPath.add(parent[curNode]);
            curNode = parent[curNode];
        }

        if(longestPath.size() % 2 == 1) {
            res.add(longestPath.get(longestPath.size() / 2 ));
        } else {
            res.add(longestPath.get((longestPath.size() / 2)  - 1));
            res.add(longestPath.get(longestPath.size() / 2 ));
        }

        return res;
    }

    private void bfs(int root, Map<Integer, Set<Integer>> graph, int[] depth, int[] parent) {
        parent[root] = -1;
        boolean[] visited = new boolean[depth.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        visited[root] = true;
        int count = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            depth[cur] = count;

            for(int child : graph.get(cur)) {
                if(visited[child]) continue;
                q.add(child);
                visited[child] = true;
                parent[child] = cur;
            }
            count++;
        }
    }

    public static void main (String[] args) {
        MinimumHeightTrees m= new MinimumHeightTrees();
        int[][] edges1 = {{1,0},{1,2},{1,3}};
        int[][] edges2 = {{0,1},{0,2},{0,3},{3,4}};
        System.out.print(m.findMinHeightTrees(5, edges2));
    }
}
