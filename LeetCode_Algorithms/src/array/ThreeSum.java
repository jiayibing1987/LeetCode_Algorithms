package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * #15 Given an array nums of n integers, are there elements a, b, c in nums
 * such that a + b + c = 0? Find all unique triplets in the array which gives
 * the sum of zero.
 * 
 * @author Ryan
 *
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int number = nums[i];
			int twoSum = 0 - number;
			if (i == 0 || nums[i] != nums[i - 1]) {
				twoSum(nums, i, twoSum, result);
			}
		}
		return result;
	}

	private void twoSum(int[] nums, int k, int twoSum, List<List<Integer>> result) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(nums[k]);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Set<Integer> set = new HashSet<Integer>();
		for (int i = k+1; i < nums.length; i++) {
			if(set.contains(nums[i])) continue;
			if (map.containsKey(twoSum - nums[i])) {
				list.add(nums[map.get(twoSum - nums[i])]);
				list.add(nums[i]);
				//if(!result.contains(list))
				set.add(nums[map.get(twoSum - nums[i])]);
				set.add(nums[i]);
				result.add(list);
				//reset list
				list = new ArrayList<Integer>();
				list.add(nums[k]);
			} else {
				map.put(nums[i], i);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		ThreeSum t = new ThreeSum();
		//System.out.println(t.threeSum(nums));
	
		int[] nums1 = {0,0,0,0};
		System.out.println(t.threeSum(nums1));
	}

}
