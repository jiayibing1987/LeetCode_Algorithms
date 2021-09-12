package graph;

import java.util.*;

public class ReachableNodesInSubdividedGraph {

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i = 0; i < n; i ++)
            graph.put(i, new ArrayList<>());

        for(int[] edge : edges) {
            graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
            graph.get(edge[1]).add(new int[] {edge[0], edge[2]});
        }

        Map<String, Integer> usedEdges = new HashMap<>();
        int[] dist = new int[n];
        Arrays.fill(dist, maxMoves + 1);
        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.add(new Node(0, 0));

        int ans = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(node.dist > dist[node.index]) continue;
            ans ++;

            for(int[] child : graph.get(node.index)) {
                int childIndex = child[0];
                String key = node.index + "#" + childIndex;
                if(usedEdges.containsKey(key)) continue;

                int left = maxMoves - node.dist;
                int weight = child[1];
                int canUsedForAEdge = Math.min(weight, left);

                usedEdges.put(key, canUsedForAEdge);

                int newDist = node.dist + weight + 1;
                if(newDist < dist[childIndex]) {
                    dist[childIndex] = newDist;
                    pq.add(new Node(childIndex, newDist));
                }
            }
        }

        for(int[] edge : edges) {
            int subUsed1 = usedEdges.getOrDefault(edge[0] + "#" + edge[1], 0);
            int subUsed2 = usedEdges.getOrDefault(edge[1] + "#" + edge[0], 0);
            ans += Math.min(edge[2], subUsed1 + subUsed2);
        }
        return ans;
    }

    class Node {
        int dist;
        int index;

        public Node (int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "dist " + dist + " index " + index;
        }
    }

    public static void main(String[] args) {
        ReachableNodesInSubdividedGraph r = new ReachableNodesInSubdividedGraph();
        int[][] edges1 = new int[][] {{0,1,10},{0,2,1},{1,2,2}};
        System.out.println(r.reachableNodes(edges1, 6, 3));
    }
}
