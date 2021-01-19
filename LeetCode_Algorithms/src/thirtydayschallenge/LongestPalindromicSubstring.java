package thirtydayschallenge;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int max = 0;
        int x = 0;
        int y = 0;

        for(int i=0; i<n; i++) {
            for(int j=i; j>=0; j--) {
                if(i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                if(s.charAt(i) == s.charAt(j) && dp[i-1][j+1] >= 0 ) {
                    dp[i][j] = dp[i-1][j+1] + 2;
                } else {
                    dp[i][j] = -1;
                }

                if(dp[i][j] > max){
                    max = dp[i][j];
                    x = j;
                    y = i;
                }
            }
        }
        return s.substring(x, y+1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome("cbbd"));
       // System.out.println(l.longestPalindrome("pwwkew"));
    }
}
