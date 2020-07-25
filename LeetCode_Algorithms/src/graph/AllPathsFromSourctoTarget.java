package graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourctoTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length-1;
        List<List<Integer>> results = new ArrayList<>();
        if(target == 0) return results;
        boolean[] visited = new boolean[graph.length];
        dfs(0, target, new ArrayList<>(), results, visited, graph);
        return results;
    }

    private void dfs(int cur, int target, ArrayList<Integer> temp, List<List<Integer>> results, boolean[] visited, int[][] graph) {
        if(cur == target) {
            List<Integer> list = new ArrayList<>(temp);
            list.add(cur);
            results.add(new ArrayList<>(list));
            return;
        }
        if(visited[cur]) return;
        if(graph[cur].length == 0) return;

        visited[cur] = true;
        temp.add(cur);
        for(int child : graph[cur]) {
            dfs(child, target, temp, results, visited, graph);
        }
        visited[cur] = false;
        temp.remove(temp.size()-1);
    }

}
