package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberofConnectedComponentsinanUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        Set<Integer> remain = new HashSet<>();
        for(int i = 0; i < n; i++)
            remain.add(i);
        int count = 0;
        List<Integer>[] graph = initGraph(n, edges);

        while(!remain.isEmpty()) {
            Set<Integer> visited = new HashSet<>();
            dfs(graph, remain.iterator().next(), visited);
            remain.removeAll(visited);
            count ++;
        }
        return count;
    }

    private List<Integer>[] initGraph(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }

    private void dfs (List<Integer>[] graph, int cur, Set<Integer> visited) {
        if(visited.contains(cur)) {
            return;
        }

        visited.add(cur);
        for(int child : graph[cur]) {
            dfs(graph, child, visited);
        }
    }

}
