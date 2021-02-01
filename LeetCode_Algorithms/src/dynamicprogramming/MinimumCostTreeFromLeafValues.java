package dynamicprogramming;

public class MinimumCostTreeFromLeafValues {

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        int[][] max = new int[n][n];
        for(int i = 0; i < n; i ++) {
            int localMax = 0;
            for(int j = i; j < n; j ++) {
                if(arr[j] > localMax) {
                    localMax = arr[j];
                }
                max[i][j] = localMax;
            }
        }

        for(int l = 2; l<=n; l++) {
            for(int i = 0; i<n-l; i++) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                if(l == 1) {
                    dp[i][j] = arr[i] * arr[j];
                }
                for(int k = i; k<j; k++) {
                    int root = max[i][k] * max[k+1][j];
                    dp[i][j] = Math.min(dp[i][j], root + dp[i][k] + dp[k+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }

}
