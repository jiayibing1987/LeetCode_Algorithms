package thirtydayschallenge;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1; i<nums.length; i++) {
            if(dp[i-1] < 0)
                dp[i] = nums[i];
            else
                dp[i] = nums[i] + dp[i-1];
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main (String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(a));
    }
}
