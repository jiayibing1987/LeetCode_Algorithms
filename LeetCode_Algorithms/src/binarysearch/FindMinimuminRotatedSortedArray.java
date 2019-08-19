package binarysearch;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * @author Ryan
 *
 */
public class FindMinimuminRotatedSortedArray {

	//binary search
    public int findMin(int[] nums) {
    	if(nums.length == 0) return 0;
    	int low = 0;
    	int high = nums.length-1;
    	while(low < high){
    		int mid = (low+high)/2;
    		//in an unsorted array, pivot in the mid of somewhere
    		if(nums[low] >nums[high]){
    			//left part is sorted "bigger" array, go right
    			if(nums[mid] >= nums[low]){
    				low = mid+1;
    			}
    			//left part is an unsorted array, pivot in the left, go left
    			else{
    				high = mid;
    			}
    		}else{
    			//in the smaller array, just return nums[low]
    			return nums[low];
    		}
    	}
    	return nums[low];
    }
    
	public static void main(String[] args) {
		FindMinimuminRotatedSortedArray f = new FindMinimuminRotatedSortedArray();
		int[] a = {4,5,6,7,0,1,2};
		int[] b = {2,1};
		System.out.println(f.findMin(b));
	}

}
