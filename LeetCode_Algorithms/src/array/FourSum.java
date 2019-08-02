package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 18. 4Sum
 * Given an array nums of n integers and an integer target, are there elements a, b, c,
 * and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * @author Ryan
 *
 */
public class FourSum {

	//solution based on @ThreeSum
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		if (nums == null || nums.length == 0)
			return new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				if(i>0 && nums[i-1] == nums[i] && nums[j-1] == nums[j] ) continue;
				int twoSum = target - nums[i] - nums[j];
				int l = j+1;
				int k = nums.length - 1;
				while (l < k) {
					if (nums[l] + nums[k] == twoSum) {
						set.add(Arrays.asList(nums[i], nums[j], nums[l], nums[k]));
						l++;
						k--; 
					} else if (nums[l] + nums[k] < twoSum)
						l++;
					else
						k--;
				}
			}
		}
		return new ArrayList<List<Integer>>(set);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
