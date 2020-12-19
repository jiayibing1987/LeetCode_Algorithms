package dynamicprogramming;

public class CherryPickupTwo {

    public int cherryPickup(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        dp[0][0][n - 1] = n - 1 == 0 ? grid[0][0] : grid[0][0] + grid[0][n - 1];

        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= Math.min(i, n - 1); j++) {
                for (int k = n - 1; k >= Math.max(0, n-i-1); k--) {
                    dp[i][j][k] = calcDP(dp, grid, i, j, k);
                    max = Math.max(dp[i][j][k], max);
                }
            }
        }
        return max;
    }

    private int calcDP(int[][][] dp, int[][] grid, int i, int j, int k) {
        int max = 0;
        int n = grid[0].length;
        for (int x = j - 1; x <= j + 1; x++) {
            for (int y = k - 1; y <= k + 1; y++) {
                if (x < 0 || y < 0 || x >= n || y >= n) continue;
                max = Math.max(dp[i - 1][x][y], max);
            }
        }
        return j == k ? max + grid[i][j] : max + grid[i][j] + grid[i][k];
    }

    public static void main(String[] args) {
        CherryPickupTwo c = new CherryPickupTwo();
        int[][] grid1 = new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
        int[][] grid2 = new int[][]{{4, 1, 5, 7, 1}, {6, 0, 4, 6, 4}, {0, 9, 6, 3, 5}};
        System.out.println(c.cherryPickup(grid1));
        System.out.println(c.cherryPickup(grid2));
    }
}
