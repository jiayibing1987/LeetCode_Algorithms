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
        int[] rank;

        public Graph() {
            parent = new int[size];
            rank = new int[size];
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

            //merge subtree under the root of deeper tree
            if(rank[x] > rank[y])
                parent[y] = x;
            else if(rank[x] < rank[y])
                parent[x] = y;
            else {
                //only if height of x == height of y, increase height of merged tree
                parent[y] = x;
                rank[x] ++;
            }
            return false;
        }
    }
}
