package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParallelCourses {

    public int minimumSemesters(int n, int[][] relations) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] relation : relations) {
            graph[relation[0]].add(relation[1]);
        }

        int[] visited = new int[n + 1];
        for (int node = 1; node <= n; node++) {
            //System.out.println("check cycle for start node " + node);
            if (checkCycle(node, graph, visited) == -1)
                return -1;
        }

        int maxLen = 0;
        int[] maxDepth = new int[n + 1];
        for (int node = 1; node <= n; node++) {
            //System.out.println("get depth for start node " + node);
            maxLen = Math.max(maxLen, getDepth(node, graph, maxDepth));
        }
        return maxLen;
    }

    private int getDepth(int node, List<Integer>[] graph, int[] depths) {
        if (depths[node] != 0)
            return depths[node];
        if (graph[node].isEmpty())
            return 1;

        int max = 0;
        for (int child : graph[node]) {
            max = Math.max(max, getDepth(child, graph, depths) + 1);
        }
        depths[node] = max;
        return max;
    }

    private int checkCycle(int node, List<Integer>[] graph, int[] visited) {
        if (visited[node] != 0)
            return visited[node];
        else
            visited[node] = -1;

        for (int child : graph[node]) {
            //System.out.println("check cycle for child " + child);
            if (checkCycle(child, graph, visited) == -1)
                return -1;
        }
        visited[node] = 1;
        return 1;
    }
}
