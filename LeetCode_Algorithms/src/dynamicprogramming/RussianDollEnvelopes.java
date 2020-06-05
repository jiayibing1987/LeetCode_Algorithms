package dynamicprogramming;

import java.util.Arrays;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        Arrays.sort(envelopes, (a,b) -> a[0]-b[0] == 0 ? a[1]-b[1] : a[0]-b[0]);

        for(int i=1; i<envelopes.length; i++) {
            for(int j=0; j<i; j++ ){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }

        int max = 0;
        for(int a : dp){
            max = Math.max(max, a);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(a));
    }

}
