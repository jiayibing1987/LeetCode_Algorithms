package dynamicprogramming;

public class MaximumNumberofPointswithCost {

    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long max = 0;

        long[][] dp = new long[m][n];
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = points[m - 1][j];
            max = Math.max(dp[m - 1][j], max);
        }

        for (int i = m - 2; i >= 0; i--) {
            long[] pre_row = dp[i + 1];

            long[] left = new long[n];
            left[0] = pre_row[0] - (n - 1);
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(left[j - 1], pre_row[j] - (n - 1 - j));
            }

            long[] right = new long[n];
            right[n - 1] = pre_row[n - 1] - (n - 1);
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1], pre_row[j] - j);
            }

            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.max(j == 0 ? 0 : left[j - 1] + (n - 1 - j), right[j] + j) + points[i][j];
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

}
