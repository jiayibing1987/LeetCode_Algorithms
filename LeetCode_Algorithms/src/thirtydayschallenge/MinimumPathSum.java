package thirtydayschallenge;

import dynamicprogramming.MinimumFallingPathSum;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int j = 1; j<n; j++)
            dp[j] =dp[j-1] + grid[0][j];
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                if(j == 0)
                    dp[0] = dp[0] + grid[i][0];
                else
                    dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];

            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        int[][] a = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(m.minPathSum(a));
    }
}
