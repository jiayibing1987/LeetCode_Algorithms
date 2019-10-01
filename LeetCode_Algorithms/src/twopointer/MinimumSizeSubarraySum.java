package twopointer;

import java.util.Arrays;

/**
 * 209. Minimum Size Subarray Sum
 * @author Ryan
 *
 */
public class MinimumSizeSubarraySum {

	//two pointer left and right, left means start of a sub-array
	// We could keep 2 pointer,one for the start and another for the end of the current subarray,
	//and make optimal moves so as to keep the \text{sum}sum greater than ss 
	//as well as maintain the lowest size possible.
	public int minSubArrayLen(int s, int[] nums) {
		if(nums.length == 0) return 0;
		int left = 0;
		int right = 0;
		int sum = nums[0];
		int res = Integer.MAX_VALUE;
		while (!(sum < s && right == nums.length-1)) {
			if (sum < s) {
				right++;
				sum += nums[right];
			} else if (sum >= s) {
				res = Math.min(res, right - left + 1);
				sum -= nums[left];
				left++;
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}

	//binary search nlogn eay
	//make extra memo, to store sum untill index i
	//e.g. sum[i] mean sum up from index 0 to i
	//scan sum array, find lower bound for s using binary search (take logn time)
	
	public static void main(String[] args) {
		MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
		int s = 7;
		int[] nums = new int[] {2,3,1,2,4,3};
		System.out.println(m.minSubArrayLen(s, nums));
	}

}
