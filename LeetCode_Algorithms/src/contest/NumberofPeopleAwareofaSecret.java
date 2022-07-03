package contest;

public class NumberofPeopleAwareofaSecret {

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int m = 1000000000 + 7;
        int[][] dp = new int[n + 1][forget + 1];
        dp[1][1] = 1;

        for(int i = 1; i <n; i ++) {
            for(int j = 1; j < forget; j ++) {
                dp[i][j] %= m;
                dp[i + 1][j + 1] += dp[i][j];
                dp[i + 1][j + 1] %= m;

                if(j  >= delay) {
                    dp[i + 1][1] += dp[i][j];
                    dp[i + 1][1] %= m;
                }
            }
        }

        int res = 0;
        for(int x : dp[n]) {
            res += x % m;
            res %= m;
        }

        return res ;
    }

}
