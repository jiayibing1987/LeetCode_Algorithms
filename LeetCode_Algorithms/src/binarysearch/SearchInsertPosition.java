package binarysearch;

/**
 * #35. Search Insert Position
 * @author Ryan
 *
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
    	int low = 0;
    	int high = nums.length-1;
    	while(low <= high){
    		int mid = (low+high)/2;
    		if(target == nums[mid])
    			return mid;
    		if(target<nums[mid])
    			high = mid-1;
    		else
    			low = mid+1;
    	}
    	return low;
    }
    
	public static void main(String[] args) {
		int[] a = {1,3,5,6};
		SearchInsertPosition sea = new SearchInsertPosition();
		System.out.println(sea.searchInsert(a, 2));
	}

}
