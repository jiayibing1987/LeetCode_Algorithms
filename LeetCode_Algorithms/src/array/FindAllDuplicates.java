package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, 1 ¡Ü a[i] ¡Ü n (n = size of array), some elements appear twice and others appear once.

   Find all the elements that appear twice in this array.
 * @author Ryan
 *
 */
public class FindAllDuplicates {
	
	//when looking a number i, set the index i to negative, if it is already negative, then i is the duplicate number
    public List<Integer> findDuplicates(int[] nums) {
    	List<Integer> results = new ArrayList<Integer>();
    	for(int i=0; i<nums.length; i++){
    		int index = Math.abs(nums[i])-1;
    		if(nums[index]<0)
    			results.add(Math.abs(nums[i]));
    		else
    			nums[index] = -nums[index];
    	}
    	return results;
    }
    
    
	public static void main(String[] args) {
		FindAllDuplicates f = new FindAllDuplicates();
		int[] a = {4,3,2,7,8,2,3,1};
		System.out.println(f.findDuplicates(a));
	}

}
