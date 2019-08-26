package binarysearch;

/**
 * #162. Find Peak Element
 * A peak element is an element that is greater than its neighbors.
 * @author Ryan
 *
 */
public class FindPeakElements {

	//linear search
    public int findPeakElement1(int[] nums) {
    	if(nums.length == 1) return 0;
		for(int i=0; i<nums.length; i++){
			if(i==0 && nums[i] > nums[i+1])
				return i;
			else if(i<nums.length-1 && i>0 && nums[i]>nums[i-1] && nums[i] > nums[i+1])
				return i;
			else if(i == nums.length-1 && nums[i]>nums[i-1])
				return i;
		}
    	return 0;
    }
    
    //binary search
    public int findPeakElement(int[] nums) {
    	if(nums.length == 1) return 0;
    	int low = 0;
    	int high = nums.length-1;
    	while(low < high){
    		int mid = (low+high)/2;
    		if(nums[mid]>nums[mid+1])
    			high = mid;
    		else
    			low = mid+1;
    	}
    	return low;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
