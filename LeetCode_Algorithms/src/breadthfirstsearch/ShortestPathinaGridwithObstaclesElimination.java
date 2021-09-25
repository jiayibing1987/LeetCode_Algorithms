package breadthfirstsearch;

import java.util.*;

public class ShortestPathinaGridwithObstaclesElimination {

    public int shortestPath(int[][] grid, int k) {
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0 , -1}, {0, 1}};
        int m = grid.length;
        int n = grid[0].length;

        if (k >= m + n - 2) {
            return m + n - 2;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        Node start = new Node(0, 0, 0, k);
        q.add(start);
        visited.add(start);

        while(!q.isEmpty()) {
            Node node = q.poll();
            //reach btm right so find an answer
            if(node.x == m - 1 && node.y == n - 1) {
                return node.step;
            }

            int x = node.x;
            int y = node.y;
            int step = node.step;

            for(int[] d : directions) {
                int newRow = x + d[0];
                int newCol = y + d[1];
                if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n)
                    continue;

                int newRemain = grid[newRow][newCol] == 0 ? node.k : node.k - 1;
                Node child = new Node(newRow, newCol, step + 1, newRemain);

                if(!visited.contains(child) && newRemain >= 0) {
                    q.add(child);
                    visited.add(child);
                }
            }
        }
        return -1;
    }

    class Node {
        int x;
        int y;
        int step;
        int k;

        public Node (int x, int y, int step, int k) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.k = k;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y && k == node.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, k);
        }

        @Override
        public String toString() {
            return x + " " + y + " " + step + " " + k;
        }
    }
}
