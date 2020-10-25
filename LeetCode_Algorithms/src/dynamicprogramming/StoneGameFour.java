package dynamicprogramming;

public class StoneGameFour {

    public boolean winnerSquareGame(int n) {
        if(n<=1) return true;
        boolean[] dp = new boolean[n+1];
        dp[1] = true;
        for(int i=1; i*i <=n; i++) {
            dp[i*i] = true;
        }

        for(int i=2; i<=n; i++) {
            for(int j=1; j*j <= n; j++) {
                if(i- j*j >= 0 && !dp[i- j*j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        StoneGameFour s = new StoneGameFour();
        System.out.println(s.winnerSquareGame(4));
    }
}
