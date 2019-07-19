package array;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, 
 * sort them in-place so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * @author Ryan
 *
 */
public class SortColors {
		//-- 2 pass counting sort
//    public void sortColors(int[] nums) {
//    	int c0 = 0, c1 = 0;
//    	for(int i=0; i<nums.length; i++){
//    		if(nums[i] == 0)
//    			c0++;
//    		if(nums[i] == 1)
//    			c1++;
//    	}
//    	int p1 = c0;
//    	int p2 = c0+c1;
//    	for(int i=0; i<nums.length; i++){
//    		if(i<p1)
//    			nums[i] = 0;
//    		else if(i>=p1 && i<p2)
//    			nums[i] = 1;
//    		else
//    			nums[i] = 2;
//    	}
//    }
    
	//one pass solution
    public void sortColors(int[] nums) {
    	int low = 0; //last index of 0 for current stage
    	int high = nums.length-1;// pointer for 2
    	int i = 0;
   
    	while(i<=high){
    		if(nums[i] == 0){ 
    			//swap i and low
    			//nums[low] could only be 1 or 0
    			nums[i] = nums[low];
    			nums[low] = 0;
    			low++;
    		}
    		if(nums[i] == 2){
    			//swap i and high
    			//nums[high] could be 0 or 1 or 2, if it is 0 we need to stay at i and swap again
    			nums[i] = nums[high];
    			nums[high] = 2;
    			high--;
    			i--;
    		}
    		i++;
    	}
    }
    
	public static void main(String[] args) {
		SortColors s = new SortColors();
		int[] a = {1,2,0};
		s.sortColors(a);
		System.out.println(Arrays.toString(a));
	}

}
