package thirtydayschallenge;

import java.util.Arrays;

public class CountingBits {

    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        if(num == 0) return dp;
        dp[1] = 1;
        int cur_pow = 1;
        int next = 2;
        int last = 0;
        for (int i = 2; i <= num; i++) {
            if (i == next) {
                dp[i] = 1;
                last = next;
                next = (int) Math.pow(2, ++cur_pow);
            } else {
                dp[i] = dp[last] + dp[i - last];
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits().countBits(4)));
    }

}
