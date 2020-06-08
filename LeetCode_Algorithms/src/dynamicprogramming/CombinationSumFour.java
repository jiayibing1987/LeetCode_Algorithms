package dynamicprogramming;

/**
 * 377. Combination Sum IV
 *
 * Given an integer array with all positive numbers and no duplicates,
 * find the number of possible combinations that add up to a positive integer target.
 */
public class CombinationSumFour {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int i=1; i<dp.length; i++) {
            for(int j=0; j<nums.length; j++){
                if(i-nums[j] >=0)
                    dp[i] = dp[i] + dp[i-nums[j]];
            }
        }
        return dp[target];
    }

}
