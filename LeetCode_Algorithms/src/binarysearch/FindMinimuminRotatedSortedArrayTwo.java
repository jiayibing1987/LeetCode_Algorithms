package binarysearch;

/**
 * 154. Find Minimum in Rotated Sorted Array II
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * Find the minimum element.
 * The array may contain duplicates.
 * @author Ryan
 *
 */
public class FindMinimuminRotatedSortedArrayTwo {

    public int findMin(int[] nums) {
    	return helper(nums, 0, nums.length-1);
    }
    
    public int helper(int[]nums, int low, int high){
    	if(low == high) return nums[low];
		int mid = (low+high)/2;
		//if low == mid == high, do binary seach for both parts, then return min one
		if(nums[low] == nums[high] && nums[mid] == nums[low]){
			return Math.min(helper(nums, low, mid), helper(nums, mid+1, high));
		}
		else if(nums[low] >=nums[high]){
			if(nums[low] <= nums[mid])
				return helper(nums, mid+1, high);
			else
				return helper(nums, low, mid);
		}else{
			return nums[low];
		}
    }
    
    
	public static void main(String[] args) {
		FindMinimuminRotatedSortedArrayTwo f = new FindMinimuminRotatedSortedArrayTwo();
		int[] a = {10,10,10,1,10};
		int[] b = {10,1,10,10,10};
		System.out.println(f.findMin(a));
	}

}
