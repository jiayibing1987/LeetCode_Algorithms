package array;

import java.util.Arrays;

/**
 * #287 FindtheDuplicateNumber
 * @author Ryan
 *
 */
public class FindtheDuplicateNumber {

    public int findDuplicate(int[] nums) {
    	Arrays.sort(nums);
    	int dup = 0;
    	for(int i=0; i<nums.length-1; i++){
    		if(nums[i] == nums[i+1]){
    			dup = nums[i];
    			break;
    		}
    	}
    	return dup;
    }
    
    
	public static void main(String[] args) {
		
	}

}
