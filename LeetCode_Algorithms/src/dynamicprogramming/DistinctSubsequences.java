package dynamicprogramming;

public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        if(s.length() == 0) return 0;
        int m = t.length();
        int n = s.length();
        int[][] dp = new int[m][n];
        dp[0][0] = t.charAt(0) == s.charAt(0) ? 1 : 0;
        for(int j=1; j<n; j++)
            dp[0][j] = t.charAt(0) == s.charAt(j) ? dp[0][j-1] + 1 : dp[0][j-1];

        for(int i = 1; i<m; i++) {
            for(int j=i; j<n; j++) {
                if(t.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];//using last char plus not using it
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences().numDistinct("rabbbit", "rabbit"));
    }

}
