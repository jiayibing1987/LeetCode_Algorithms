package dynamicprogramming;

/**
 * 1143. Longest Common Subsequence
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int[][] dp = new int[c1.length][c2.length];
        dp[0][0] = c1[0] == c2[0] ? 1 : 0;
        for(int i=1; i<c1.length; i++) {
            dp[i][0] = c1[i] == c2[0] ? 1 : dp[i-1][0];
        }
        for(int j=1; j<c2.length; j++) {
            dp[0][j] = c1[0] == c2[j] ? 1 : dp[0][j-1];
        }
        for(int i=1; i<c1.length; i++) {
            for(int j=1; j<c2.length; j++) {
                dp[i][j] = c1[i] == c2[j] ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[c1.length-1][c2.length-1];
    }

}c
