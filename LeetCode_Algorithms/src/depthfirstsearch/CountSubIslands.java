package depthfirstsearch;

public class CountSubIslands {

    int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int m;
    int n;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid2[i][j] == 1 && dfs(grid1, grid2, visited, i, j))
                    count++;
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, boolean[][] visited, int i, int j) {
        if (visited[i][j]) {
            return grid1[i][j] == 1;
        }

        visited[i][j] = true;
        boolean res = grid1[i][j] == 1;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid2[x][y] == 1) {
                boolean temp = dfs(grid1, grid2, visited, x, y);
                res = res && temp;
            }
        }
        return res;
    }
}
