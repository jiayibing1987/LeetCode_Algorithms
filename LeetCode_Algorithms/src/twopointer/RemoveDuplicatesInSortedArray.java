package twopointer;

import java.util.Arrays;

/**
 * #26
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
 * @author Ryan
 *
 */
public class RemoveDuplicatesInSortedArray {

	public static void main(String[] args) {
		int array[] = {1,1,2};
		System.out.println(removeDuplicates(array));
		//System.out.println(Arrays.toString(array));
	}

	

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;

		int j=0;
		int i = 0;
		for(; i<n && j<n;) {
			if(nums[i] == nums[j]){
				j++;
			}else {
				nums[++i] = nums[j++];
			}
		}
		return i+1;
    }
}
