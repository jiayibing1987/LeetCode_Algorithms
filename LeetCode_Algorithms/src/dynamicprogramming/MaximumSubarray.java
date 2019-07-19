package dynamicprogramming;


/**
 * #53 Given an integer array nums, 
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * @author Ryan
 *
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
    	int max = nums[0];
    	//dp[i] is the maximum sum which subarray is ending at nums[i]
    	int[] dp = new int[nums.length];
    	dp[0] = nums[0];
    	for(int i=1; i<nums.length; i++){
    		dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
    		max = Math.max(dp[i], max);
    	}
    	return max;
    }
	
	public static void main(String[] args) {
		MaximumSubarray m = new MaximumSubarray();
		int[] a = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(m.maxSubArray(a));
	}

}
