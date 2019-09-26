package binarysearch;

import java.util.Arrays;


/**
 * #34
 * Given an array of integers nums sorted in ascending order, 
 * find the starting and ending position of a given target value.

	Your algorithm's runtime complexity must be in the order of O(log n).
 * @author Ryan
 *
 */
public class FirstandLastPosition {

	public int[] searchRange(int[] nums, int target) {
		int leftPos = binarySearch(nums, target, 0);
		if(leftPos == -1) return new int[] {-1, -1};
		int rightPos = binarySearch(nums, target, 1);
		return new int[]{leftPos, rightPos};
	}
	
	private int binarySearch(int[]nums, int target, int mod){
		if(nums.length == 0) return -1;
		int low = 0;
		int high = nums.length-1;
		while(low < high){
			int mid = (low+high)/2;
			if(nums[mid] == target){
				if (mod == 0){ // get left bound
					if(mid == 0 || nums[mid-1] < target)	
						return mid;
					else
						high = mid;
				}
				if(mod == 1 ){ // get right bound
					if(mid == nums.length-1 || nums[mid+1]>target)
						return mid;
					else
						low = mid+1;
				}
			}
			else if(nums[mid] < target)
				low = mid+1;
			else if(nums[mid] > target)
				high = mid;
		}
		return nums[low] == target ? low : -1;
	}
	
	//worst cast is o(n)
	public int[] searchRange1(int[] nums, int target) {
		int pos = helper(nums, target, 0, nums.length - 1);
		if (pos == -1)
			return new int[] { -1, -1 };
		int i = pos;
		int j = pos;
		while (i-1 >=0 && nums[i-1] == target ) {
			i--;
		}
		while (j+1<= nums.length-1 && nums[j+1] == target) {
			j++;
		}
		return new int[] { i, j };
	}

	private int helper(int[] nums, int target, int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] < target) {
				return helper(nums, target, mid+1, high);
			}
			if (nums[mid] > target) {
				return helper(nums, target, low, mid-1);
			}
		} 
		return -1;
	}

	public static void main(String[] args) {
		FirstandLastPosition f = new FirstandLastPosition();
		int[] a = {5, 7, 7, 8, 8, 10 };
		System.out.println(Arrays.toString(f.searchRange(a, 8)));
		
		int[] b = {1};
		System.out.println(Arrays.toString(f.searchRange(b, 1)));
	}

}
