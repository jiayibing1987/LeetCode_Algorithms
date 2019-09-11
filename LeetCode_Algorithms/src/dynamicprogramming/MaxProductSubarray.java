package dynamicprogramming;

/**
 * 152. Maximum Product Subarray
 *
 */
public class MaxProductSubarray {

	public int maxProduct(int[] nums) {
		int res = nums[0];
		// max product value until index i
		int[] max = new int[nums.length];
		// min product value until index i
		int[] min = new int[nums.length];
		max[0] = nums[0];
		min[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
			min[i] = Math.min(Math.min(min[i - 1] * nums[i], max[i - 1] * nums[i]), nums[i]);
		}
		for (int i = 1; i < nums.length; i++) {
			res = Math.max(res, max[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
