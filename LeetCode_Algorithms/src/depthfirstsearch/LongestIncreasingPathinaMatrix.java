package depthfirstsearch;

public class LongestIncreasingPathinaMatrix {

    int m, n;
    private final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        m = matrix.length;
        n = matrix[0].length;
        int[][] memo = new int[m][n];

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int length = dfs(matrix, i, j, memo);
                max = Math.max(max, memo[i][j]);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int max = 1;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int length = dfs(matrix, x, y, memo) + 1;
            max = Math.max(length, max);
        }
        memo[i][j] = max;
        return max;
    }

}
