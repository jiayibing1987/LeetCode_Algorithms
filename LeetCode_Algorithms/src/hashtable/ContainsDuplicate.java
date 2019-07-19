package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * #217
 * Given an array of integers, find if the array contains any duplicates.
 * @author Ryan
 *
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++){
        	if(set.contains(nums[i])){
        		return true;
        	}
        	set.add(nums[i]);
        }
        return false;
    }
	
	public static void main(String[] args) {
		
	}

}
