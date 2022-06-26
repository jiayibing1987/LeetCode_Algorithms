package contest;

import java.util.Arrays;

public class CountNumberofWaystoPlaceHouses {

    int m = 1000000000 + 7;
    public int countHousePlacements(int n) {
        if(n == 1) return 4;
        int[][] dp = new int[n + 1][4];
        Arrays.fill(dp[1], 1);

        for(int i = 1; i < n; i ++) {
            for(int j = 0; j < 4; j ++) {
                dp[i][j] = dp[i][j] % m;
                if(j == 0) {
                    dp[i + 1][0] += dp[i][0];
                    dp[i + 1][1] += dp[i][0];
                    dp[i + 1][2] += dp[i][0];
                    dp[i + 1][3] += dp[i][0];

                    dp[i + 1][0] %= m;
                    dp[i + 1][1] %= m;
                    dp[i + 1][2] %= m;
                    dp[i + 1][3] %= m;
                } else if (j == 1) {
                    dp[i + 1][0] += dp[i][1];
                    dp[i + 1][2] += dp[i][1];

                    dp[i + 1][0] %= m;
                    dp[i + 1][2] %= m;
                } else if (j == 2) {
                    dp[i + 1][0] += dp[i][2];
                    dp[i + 1][1] += dp[i][2];

                    dp[i + 1][0] %= m;
                    dp[i + 1][1] %= m;
                } else if (j == 3) {
                    dp[i + 1][0] += dp[i][3];

                    dp[i + 1][0] %= m;
                }
            }
        }

        int res = 0;
        for(int j = 0; j <= 3; j ++) {
            res += dp[n][j];
            res %= m;
        }
        return res;
    }

    public static void main(String[] args) {
        CountNumberofWaystoPlaceHouses c = new CountNumberofWaystoPlaceHouses();
        System.out.println(c.countHousePlacements(1000));
    }
}
