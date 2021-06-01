package dynamicprogramming;

public class PaintHouse {

    //bottom up, DP
    public int minCost(int[][] costs) {
        int n = costs.length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][3];
        for(int j = 0; j < 3; j++) {
            dp[n-1][j] = costs[n-1][j];
        }

        for(int i = n-2; i >=0; i --) {
            dp[i][0] = Math.min(dp[i+1][1], dp[i+1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i+1][0], dp[i+1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i+1][0], dp[i+1][1]) + costs[i][2];
        }

        for(int j = 0; j < 3; j++) {
            min = Math.min(dp[0][j], min);
        }
        return min;
    }



    //top down, with memo
    public int minCost1(int[][] costs) {
        int n = costs.length;
        int min = Integer.MAX_VALUE;
        int[][] memo = new int[n][3];

        for(int j = 0; j < 3; j++) {
            int temp = dfs(0, j , memo, costs);
            min = Math.min(temp, min);
        }

        return min;
    }

    private int dfs(int i, int j, int[][] memo, int[][] costs) {
        if(i == costs.length - 1) {
            memo[i][j] = costs[i][j];
            return memo[i][j];
        }

        if(memo[i][j] != 0) {
            return memo[i][j];
        }

        int min = Integer.MAX_VALUE;
        for(int k = 0; k < 3; k++) {
            if(k != j) {
                int temp = dfs(i + 1, k, memo, costs);
                min = Math.min(temp, min);
            }
        }
        memo[i][j] = min + costs[i][j];
        return min;
    }
}
