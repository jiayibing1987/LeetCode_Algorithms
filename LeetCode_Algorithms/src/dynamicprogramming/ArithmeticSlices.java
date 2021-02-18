package dynamicprogramming;

public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] a) {
        if(a.length < 3) return 0;
        int n = a.length;
        int sum = 0;
        int []dp = new int[n];

        for(int i=n-3; i>=0; i--) {
            if (a[i + 1] - a[i] == a[i + 2] - a[i + 1]) {
                dp[i] = dp[i+1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }

    public int numberOfArithmeticSlices1(int[] a) {
        if(a.length < 3) return 0;
        int n = a.length;
        int[][] dp = new int[n][n];
        boolean[][] isArithmetic = new boolean[n][n];
        //dealing with base case
        for (int i = 0; i + 2 <= n - 1; i++) {
            if (a[i + 1] - a[i] == a[i + 2] - a[i + 1]) {
                dp[i][i + 2] = 1;
                isArithmetic[i][i+2] = true;
            }
        }

        for (int i = n - 3; i >= 0; i--) {
            for (int j = 3; j <= n - 1; j++) {
                if(j - i >= 3) {
                    isArithmetic[i][j] = isArithmetic[i][j-1] && isArithmetic[i+1][j];
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                    if(isArithmetic[i][j]) dp[i][j] ++;
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main (String[] args) {
        ArithmeticSlices as = new ArithmeticSlices();
        int[] a = {1,2,3,8,9,10};
        System.out.println(as.numberOfArithmeticSlices(a));
    }
}
