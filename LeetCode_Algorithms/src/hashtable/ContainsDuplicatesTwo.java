package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * #219
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
 * such that nums[i] = nums[j] 
 * and the absolute difference between i and j is at most k.
 * @author Ryan
 *
 */
public class ContainsDuplicatesTwo {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			} else {
				if (Math.abs(i - map.get(nums[i])) <= k)
					return true;
				else
					map.put(nums[i], i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicatesTwo c = new ContainsDuplicatesTwo();
		int[] a = {1,2,3,1};
		System.out.println(c.containsNearbyDuplicate(a, 3));
		
		int[] b = {1,0,1,1};
		System.out.println(c.containsNearbyDuplicate(b, 1));
		
		int[] d = {1,2,3,1,2,3};
		System.out.println(c.containsNearbyDuplicate(d, 2));
	}

}
