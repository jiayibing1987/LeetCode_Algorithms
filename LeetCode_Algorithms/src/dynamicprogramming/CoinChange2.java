package dynamicprogramming;

/**
 * 518. Coin Change 2
 *
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 */
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        if(coins.length == 0) return 0;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0; i<coins.length; i++) {
            for(int j=0; j<dp.length; j++) {
                if(j-coins[i] >= 0)
                    dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }

}
