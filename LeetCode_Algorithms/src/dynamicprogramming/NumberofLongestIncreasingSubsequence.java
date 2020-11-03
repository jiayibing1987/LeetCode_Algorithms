package dynamicprogramming;

import java.util.Arrays;

public class NumberofLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int max = dp[0];
        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    int value = dp[j] + 1;
                    if(value > dp[i]) {
                        dp[i] = value;
                        count[i] = count[j];
                    }else if(value == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(dp[i], max);
        }

        int res = 0;
        for(int i=0; i<n; i++) {
            if(dp[i] == max)
                res += count[i];
        }
        return res;
    }

    public static void main(String[] args) {
        NumberofLongestIncreasingSubsequence n = new NumberofLongestIncreasingSubsequence();
        int[] a = {1,2,4,3,5,4,7,2};
        System.out.print(n.findNumberOfLIS(a));
    }
}
