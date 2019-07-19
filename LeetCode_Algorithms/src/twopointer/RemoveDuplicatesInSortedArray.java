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
		System.out.println(Arrays.toString(array));
	}

	
	//use two pointer, i is slower and j is faster
	//when num[i] = num[j] which means we are in duplicate sequence then increment i
	//if not, change num[i+1] to num[j], 
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        
        int i = 0;
        for(int j=1; j<length; j++){
        	if(nums[i] != nums[j]){
        		nums[i+1] = nums[j];
        		i++;
        	}
        }
    	return i+1;
    }
}
