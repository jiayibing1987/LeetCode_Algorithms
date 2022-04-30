package thirtydayschallenge;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < n; i ++) {
            if(visited.contains(i))
                continue;

            Set<Integer> setA = new HashSet<>();
            Set<Integer> setB = new HashSet<>();

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            setA.add(i);

            boolean isSetA;
            while(!q.isEmpty()) {
                int cur = q.poll();
                if(setA.contains(cur)) {
                    isSetA = false;
                } else {
                    isSetA = true;
                }

                visited.add(cur);
                for(int adj : graph[cur]) {
                    if(visited.contains(adj))
                        continue;
                    if(isSetA) {
                        if(setB.contains(adj))
                            return false;
                        setA.add(adj);
                    } else {
                        if(setA.contains(adj))
                            return false;
                        setB.add(adj);
                    }
                    q.add(adj);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsGraphBipartite g = new IsGraphBipartite();
        int[][] g1 = new int[][] {{1,3},{0,2},{1,3},{0,2}};
        System.out.print(g.isBipartite(g1));

        int[][] g2 = new int[][] {{4},{},{4},{4},{0,2,3}};
    }
}
