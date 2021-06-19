package dynamicprogramming;

public class KInversePairsArray {

    public int kInversePairs(int n, int k) {
        if (n <= 1) return 0;
        if (k == 0) return 1;

        long m = 1000000000 + 7;
        long[][] dp = new long[n + 1][k + 1];
        dp[2][0] = 1;
        dp[2][1] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    long val = dp[i - 1][j] + m;
                    if (j - (i - 1) > 0) {
                        val -= dp[i - 1][j - i];
                    }
                    val %= m;
                    dp[i][j] = dp[i][j - 1] + val;
                }
                dp[i][j] %= m;
            }
        }
        return (int) (dp[n][k] % m);
    }

    //dp o(n2*k)
    public int kInversePairs1(int n, int k) {
        if (k == 0) return 1;
        if (n <= 1) return 0;

        long m = 1000000000 + 7;
        long[][] dp = new long[n + 1][k + 1];
        dp[2][0] = 1;
        dp[2][1] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    for (int x = j; x >= 0 && (j - x) <= (i - 1); x--) {
                        dp[i][j] += dp[i - 1][x];
                    }
                }
                dp[i][j] %= m;
            }
        }
        return (int) (dp[n][k] % m);
    }

    public static void main(String[] args) {
        KInversePairsArray inver = new KInversePairsArray();
        System.out.println(inver.kInversePairs(3, 1));
        System.out.println(inver.kInversePairs(1000, 1000));

    }
}
