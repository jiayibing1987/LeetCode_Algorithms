package array;

import java.util.Arrays;

/**
 * #287 FindtheDuplicateNumber
 * @author Ryan
 *
 */
public class FindtheDuplicateNumber {

    public int findDuplicate1(int[] nums) {
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

	public int findDuplicate(int[] nums) {
		for(int i=0; i<nums.length; i++){
			int index = Math.abs(nums[i])-1;
			if(nums[index]<0)
				return Math.abs(nums[i]);
			else
				nums[index] = -nums[index];
		}
		return -99999;
    }


    public static void main(String[] args) {
		int[] a = {1,4,6,6,6,2,3};
		System.out.println(new FindtheDuplicateNumber().findDuplicate(a));
	}

}
