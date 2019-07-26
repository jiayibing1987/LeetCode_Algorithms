package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * @author Ryan
 *
 */
public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++)
			set.add(nums[i]);

		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int currentMax = 1;
			int n = nums[i];
			if(set.contains(n-1)) continue;// skip all numbers which included in a sequence ,reduce time to o(n)
			while (set.contains(n + 1)) {
				currentMax++;
				n++;
			}
			max = Math.max(max, currentMax);
		}

		return max;
	}
	
	//solution1: o(n2) way
	public int longestConsecutive1(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++)
			set.add(nums[i]);

		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int currentMax = 1;
			int n = nums[i];
			while (set.contains(n + 1)) {
				currentMax++;
				n++;
			}
			max = Math.max(max, currentMax);
		}

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
