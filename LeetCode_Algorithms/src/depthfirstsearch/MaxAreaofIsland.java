package depthfirstsearch;

public class MaxAreaofIsland {

    private int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    int area = dfs(i, j, m, n, grid);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    private int dfs(int i, int j, int m, int n, int[][] grid) {
        if(i >= m || i < 0 || j >= n || j < 0) { //out of bound
            return 0;
        }
        if(grid[i][j] != 1) { //visited or it is water
            return 0;
        }

        int area = 1;
        grid[i][j] = 2;
        for(int[] dir : directions) {
            area += dfs(i + dir[0], j + dir[1], m, n, grid);
        }
        return area;
    }

}
