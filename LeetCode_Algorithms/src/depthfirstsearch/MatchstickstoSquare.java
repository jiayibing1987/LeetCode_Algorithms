package depthfirstsearch;

import java.util.Arrays;

public class MatchstickstoSquare {

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        int n = matchsticks.length;
        Arrays.sort(matchsticks);
        for(int m : matchsticks) {
            sum += m;
        }
        if(sum % 4 != 0) return false;

        boolean ans = dfs(matchsticks, new int[4], n-1, sum / 4);
        return  ans;
    }

    private boolean dfs(int[] matchsticks, int[] bucket, int p, int target) {
        if(p < 0) {
            if(bucket[0] == target && bucket[1] == target && bucket[2] == target && bucket[3] == target) {
                return true;
            }
            return false;
        }

        boolean res = false;
        for(int i = 0; i < 4; i++) {
            if(bucket[i] + matchsticks[p] > target) continue;
            bucket[i] += matchsticks[p];
            res = res || dfs(matchsticks, bucket, p - 1, target);
            bucket[i] -= matchsticks[p];
        }
        return res;
    }

}
