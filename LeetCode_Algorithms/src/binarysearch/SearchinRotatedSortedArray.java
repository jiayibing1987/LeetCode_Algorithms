package binarysearch;

/**
 * #33. Search in Rotated Sorted Array
 * @author Ryan
 *
 */
public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
    	if(nums.length < 1)
    		return -1;
    	int pivot = findPivot(nums, target);
    	if(target>= nums[pivot] && target<=nums[nums.length -1]){
    		return binarySearch1(nums, pivot, nums.length -1, target);
    	}else if(target>=nums[0]){
    		return binarySearch1(nums, 0, pivot>0? pivot-1:0, target);
    	}else 
    		return -1;
    }
    
	private int binarySearch(int[] nums, int low, int high, int target) {
		if(low > high)
			return -1;
		if(target<nums[low] && target >nums[high])
			return -1;
		int mid = (low + high)/2;
		if(nums[mid] == target)
			return mid;
		if(nums[low] == target)
			return low;
		if(nums[high] == target)
			return high;
		
		if(nums[mid] > nums[low]){//left side is sorted array, pivot is in right side
			if(target < nums[mid] && target>nums[low]){// low<t<mid go left
				return binarySearch(nums, low, mid-1, target);
			}else{
				return binarySearch(nums, mid+1, high, target);
			}
		}else{
			if(target > nums[mid] && target<nums[high]){//mid<t<high go right
				return binarySearch(nums, mid+1, high, target);
			}else{
				return binarySearch(nums, low, mid-1, target);
			}
		}
	}
	
	private int binarySearch1(int[] nums,int low, int high, int target){
		while(low <= high){
			int mid = (low+high)/2;
			if(nums[mid] == target) return mid;
			if(target < nums[mid])
				high = mid-1;
			else
				low = mid+1;
		}
		return -1;
	}
	
	private int findPivot(int[] nums,int target){
		int low = 0;
		int high = nums.length-1;
		while(low < high){
			int mid = (low+high)/2;
			if(nums[mid] > nums[high]) //right side sub array is unsorted, go right
				low = mid+1;
			else
				high = mid;
		}
		return low;
	}
	
	

	public static void main(String[] args) {
		SearchinRotatedSortedArray s = new SearchinRotatedSortedArray();
		int[] a = {4,5,6,7,8,1,2,3};
		int[] b = {1};
		System.out.println(s.search(a, 4));
	}

}
