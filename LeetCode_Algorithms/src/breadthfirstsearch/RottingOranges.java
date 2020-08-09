package breadthfirstsearch;

import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class RottingOranges {

    int m;
    int n;
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        if(m == 0) return -1;

        n = grid[0].length;
        if(n == 0) return -1;

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        int count = bfs(grid, q);

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return count == -1? 0 : count;
    }

    private int bfs(int[][] grid, Queue<int[]> q) {
        int depth = -1;

        while(!q.isEmpty()) {
            int size = q.size();
            depth++;
            for(int k=0; k<size; k++) {
                int[] node = q.poll();
                int x = node[0];
                int y = node[1];
                if(x-1 >= 0 && grid[x-1][y] == 1) {
                    q.add(new int[]{x-1, y});
                    grid[x-1][y] = 2;

                }
                if(x+1 < m && grid[x+1][y] == 1) {
                    q.add(new int[]{x+1, y});
                    grid[x+1][y] = 2;
                }
                if(y-1 >= 0 && grid[x][y-1] == 1) {
                    q.add(new int[]{x, y-1});
                    grid[x][y-1] = 2;
                }
                if(y+1 < n && grid[x][y+1] == 1) {
                    q.add(new int[]{x, y+1});
                    grid[x][y+1] = 2;
                }
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        int[][] b = new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1}};
        int res = new RottingOranges().orangesRotting(b);
        System.out.println(res);
    }
}
