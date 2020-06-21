package dynamicprogramming;

/**
 * 174. Dungeon Game
 */
public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length == 0 || dungeon[0].length == 0) return 1;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        //dp[i][j] mean min health before enter dungeon[i][j], health + dungeon[i][j] = 1
        // health = 1 - dungeon[i][j], and health must small than 1
        dp[m-1][n-1] = Math.max(1 - dungeon[m-1][n-1], 1);

        //last row
        for(int j=n-2; j>=0; j--) {
            dp[m-1][j] = Math.max(dp[m-1][j+1] - dungeon[m-1][j], 1);
        }
        //last column
        for(int i = m-2; i>=0; i--) {
            dp[i][n-1] = Math.max(dp[i+1][n-1] - dungeon[i][n-1], 1);
        }

        for(int i = m-2; i>=0; i--) {
            for(int j = n-2; j>=0; j--) {
                //dp[i][j] + dungeon[i][j] = dp right/down value. dp[i][j] = dp[i][j+1] - dungeon[i][j] (right)
                int right = Math.max(dp[i][j+1] - dungeon[i][j], 1);
                int bottom =  Math.max(dp[i+1][j] - dungeon[i][j], 1);
                dp[i][j] = Math.min(right, bottom);
            }
        }
        return dp[0][0];
    }

}
