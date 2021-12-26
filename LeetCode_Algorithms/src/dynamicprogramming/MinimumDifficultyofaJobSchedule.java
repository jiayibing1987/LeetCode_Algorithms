package dynamicprogramming;

public class MinimumDifficultyofaJobSchedule {

    int n;
    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        if(n < d) return - 1;
        Integer[][] memo = new Integer[n][d];
        return helper(jobDifficulty, 0, d - 1, memo);
    }

    private int helper(int[] jobs, int start, int remain, Integer[][] memo) {
        if(start >= n)
            return 0;

        if(memo[start][remain] != null)
            return memo[start][remain];

        int max = 0;
        if(remain == 0){
            for(int i = start; i <= n - 1; i ++) {
                max = Math.max(max, jobs[i]);
            }
             memo[start][remain] = max;
             return memo[start][remain];
        }

        int res = Integer.MAX_VALUE;
        for(int i = start; i < n - remain; i ++) {
            max = Math.max(max, jobs[i]);
            int temp = max + helper(jobs, i + 1, remain - 1, memo);
            res = Math.min(res, temp);
        }
        memo[start][remain] = res;
        return res;
    }

    public static void main(String[] args) {
        MinimumDifficultyofaJobSchedule m = new MinimumDifficultyofaJobSchedule();
        int[] a1 = new int[] {6,5,4,3,2,1};
        System.out.println(m.minDifficulty(a1, 2));
    }
}
