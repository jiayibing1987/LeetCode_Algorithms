package thirtydayschallenge;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) return 0;
        char[] a = s.toCharArray();
        int n = a.length;
        boolean[][] dp = new boolean[n][n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if(isPalindromic(i, j, dp, a)) {
                    count ++;
                    dp[i][j] = true;
                }
            }
        }
        return count;
    }

    private boolean isPalindromic (int i, int j, boolean[][] dp, char[] a) {
        if(a[j] != a[i])
            return false;
        else {
            return i - j <= 1 || dp[i-1][j+1];
        }
    }

    public static void main(String[] args) {
        PalindromicSubstrings p = new PalindromicSubstrings();
        System.out.println(p.countSubstrings("aaa"));
    }
}
