package depthfirstsearch;

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {

    int m;
    int n;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Node[][] memo = new Node[m][n];
        boolean[][] visited = new boolean[m][n];

        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    Node node = new Node();
                    int size = getSize(grid, memo, visited, i, j, node);
                    node.v = size;
                    max = Math.max(size, max);
                }
            }
        }


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 ) {
                    Set<Node> set = new HashSet<>();
                    int combinedSize = 1;
                    for(int[] direction : directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && !set.contains(memo[x][y])) {
                            combinedSize += memo[x][y].v;
                            set.add(memo[x][y]);
                        }
                    }
                    max = Math.max(max, combinedSize);
                }
            }
        }
        return max;
    }

    private int getSize(int[][] grid, Node[][] memo, boolean[][] visited, int i, int j, Node node) {
        if(visited[i][j]) {
            return 0;
        }

        int size = 1;
        memo[i][j] = node;
        visited[i][j] = true;

        for(int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                size += getSize(grid, memo, visited, x, y, node);
            }
        }
        return size;
    }

    class Node {
        int v;
        public Node () {}
        public Node (int value) {v = value;}
    }
}
