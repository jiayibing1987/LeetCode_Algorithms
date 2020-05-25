package dynamicprogramming;

/**
 * 1035. Uncrossed Lines
 */
public class UncrossedLines {

    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        dp[0][0] = A[0] == B[0] ? 1 : 0;
        for(int i=1; i<A.length; i++)
            dp[i][0] = A[i] == B[0] ? 1 : dp[i-1][0];
        for(int j=1; j<B.length; j++)
            dp[0][j] = A[0] == B[j] ? 1 : dp[0][j-1];

        for(int i=1; i<A.length; i++) {
            for(int j=1; j<B.length; j++) {
                if(A[i] == B[j])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[A.length-1][B.length-1];
    }

}
