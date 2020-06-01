package dynamicprogramming;

/**
 * 72. Edit Distance
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();

        int[][] dp = new int[word1.length()][word2.length()];
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for(int i=1; i<word1.length(); i++) {
            dp[i][0] = c1[i] == c2[0] ? i : dp[i-1][0] + 1;
        }
        for(int j=1; j<word2.length(); j++) {
            dp[0][j] = c1[0] == c2[j] ? j : dp[0][j-1] + 1;
        }

        for(int i=1; i<c1.length; i++) {
            for (int j = 1; j < c2.length; j++) {
                if(c1[i] == c2[j])
                    dp[i][j] = dp[i-1][j-1] ;
                else
                    dp[i][j] = Math.min (dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
            }
        }
        return dp[c1.length-1][c2.length-1];
    }
}
