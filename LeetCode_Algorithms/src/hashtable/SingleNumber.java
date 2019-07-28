package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 136 Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * @author Ryan
 *
 */
public class SingleNumber {

	public int singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for(int n : nums){
			if(set.contains(n))
				set.remove(n);
			else
				set.add(n);
		}
		return set.iterator().next();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
