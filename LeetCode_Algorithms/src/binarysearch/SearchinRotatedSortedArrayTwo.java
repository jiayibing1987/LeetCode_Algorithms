package binarysearch;

/*
 * 81. Search in Rotated Sorted Array II
 */
public class SearchinRotatedSortedArrayTwo {

    public boolean search(int[] nums, int target) {
    	if(nums.length < 1)
    		return false;
    	return binarySearch(nums, 0, nums.length-1, target) == -1? false : true;
    }
    
    //logn on average but O(n) for worst case
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
		}else if(nums[mid] < nums[low]){
			if(target > nums[mid] && target<nums[high]){//mid<t<high go right
				return binarySearch(nums, mid+1, high, target);
			}else{
				return binarySearch(nums, low, mid-1, target);
			}
		}else//try the next one after low
			return binarySearch(nums, low+1, high, target);
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
			else if(nums[mid] < nums[high])
				high = mid;
			else
				low = low+1;
		}
		return low;
	}
	
	public static void main(String[] args) {
		SearchinRotatedSortedArrayTwo s = new SearchinRotatedSortedArrayTwo();
		int[] a = {1,1,3,1};
		int[] b = {3,1,1,1};
		System.out.println(s.search(b, 3));
	}

}
