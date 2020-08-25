package thirtydayschallenge;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length-1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<days.length; i++)
            map.put(days[i], i);

        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++) {
            if(!map.containsKey(i)) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = Math.min(dp[i-1] + costs[0], (i-7 >=0 ? dp[i-7] : 0) + costs[1]);
                dp[i] = Math.min(dp[i], (i-30>=0 ? dp[i-30] : 0) + costs[2]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2, 7, 15};
        System.out.print(new MinimumCostForTickets().mincostTickets(days, costs));
    }

}
