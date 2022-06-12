package contest;

import java.util.Arrays;

public class MinimumPathCostinaGrid {

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int j = 0; j < n; j ++) {
            dp[0][j] = grid[0][j];
        }

        for(int i = 1; i < m; i ++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for(int i = 1; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                int value = grid[i][j];
                for(int k = 0; k < n; k ++) {
                    int preValue = grid[i - 1][k];
                    int cost = moveCost[preValue][j];
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + cost);
                }
                dp[i][j] += grid[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j ++) {
            min = Math.min(dp[m - 1][j], min);
        }
        return min;
    }
}
