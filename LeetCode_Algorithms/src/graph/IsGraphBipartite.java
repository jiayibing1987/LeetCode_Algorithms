package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        for(int i=0; i<graph.length; i++) {
            if(setA.contains(i) || setB.contains(i)) continue;
            //start bfs for this graph
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            setA.add(i);
            while(!q.isEmpty()) {
                int size = q.size();
                for(int j=0; j<size; j++) {
                    int node = q.poll();
                    for(int child : graph[node]) {
                        if(setB.contains(node) && setB.contains(child)) {
                             return false;
                        } else if(setA.contains(node) && setA.contains(child)){
                             return false;
                        } else if(!setA.contains(child) && !setB.contains(child)) {
                            q.add(child);
                            if(setB.contains(node)) setA.add(child);
                            else setB.add(child);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsGraphBipartite g = new IsGraphBipartite();
        int[][] a = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(g.isBipartite(a));
    }

}
