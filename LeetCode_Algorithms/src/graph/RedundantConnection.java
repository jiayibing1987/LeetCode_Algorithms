package graph;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0)
            return null;
        Graph graph = new Graph();
        for(int[] edge : edges) {
            if(graph.union(edge[0], edge[1]))
                return edge;
        }
        return null;
    }

    class Graph {
        int size = 1001;
        int[] parent;

        public Graph() {
            parent = new int[size];
            for(int i=0; i<size; i++)
                parent[i] = -1;
        }

        public int find (int i) {
            if(parent[i] == -1)
                return i;
            return find(parent[i]);
        }

        public boolean union(int a, int b) {
            int x = find(a);
            int y = find(b);
            if(x == y) return true;

            parent[x] = y;
            return false;
        }
    }
}
