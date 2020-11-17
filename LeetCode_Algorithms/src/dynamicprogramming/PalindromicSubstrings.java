package dynamicprogramming;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j>=0; j--) {
                dp[i][j] = isPalindromic(dp, i, j, s);
                if(dp[i][j])
                    count += 1;
            }
        }
        return count;
    }

    private boolean isPalindromic(boolean[][] dp, int i, int j, String s) {
        if(j == i) return true;
        else if(i - j == 1) {
            return s.charAt(i) == s.charAt(j);
        } else {
            return s.charAt(i) == s.charAt(j) && dp[i-1][j+1];
        }
    }

    public static void main (String[] args) {
        PalindromicSubstrings p = new PalindromicSubstrings();
        System.out.print(p.countSubstrings("abc"));
    }
}
