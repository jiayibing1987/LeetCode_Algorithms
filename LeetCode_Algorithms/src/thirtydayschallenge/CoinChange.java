package thirtydayschallenge;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount < 0) return -1;
        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] >= 0)
                    dp[i] = dp[i] == -1 ? dp[i - coins[j]] + 1 : Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,5};
        System.out.println(new CoinChange().coinChange(a, 11));
    }
}