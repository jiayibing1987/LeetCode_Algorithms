package dynamicprogramming;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m + n != s3.length()) return false;
        Boolean[][] memo = new Boolean[m+1][n+1];
        boolean ans = helper(s1, 0, s2, 0, s3, 0, memo);
        return ans;
    }

    private boolean helper(String s1, int i, String s2, int j, String s3, int k, Boolean[][] memo) {
        if(k == s3.length()) {
            return true;
        }
        if(memo[i][j] != null) {
            return memo[i][j];
        }

        boolean b1 = false, b2 = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k))
             b1 = helper(s1, i + 1, s2, j, s3, k + 1, memo);
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k))
             b2 = helper(s1, i, s2, j + 1, s3, k + 1, memo);
        boolean res = b1 || b2;
        memo[i][j] = res;
        return res;
    }
}
