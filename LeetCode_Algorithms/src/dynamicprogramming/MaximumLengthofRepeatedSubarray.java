package dynamicprogramming;

public class MaximumLengthofRepeatedSubarray {

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int max = 0;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0) {
                    dp[0][j] = nums1[0] == nums2[j] ? 1 : 0;
                } else if (j == 0) {
                    dp[i][0] = nums1[i] == nums2[0] ? 1 : 0;
                } else {
                    dp[i][j] = nums1[i] == nums2[j] ? dp[i-1][j-1] + 1 : 0;
                }
                max = Math.max(dp[i][j], max);
            }
        }

        return max;
    }

}
