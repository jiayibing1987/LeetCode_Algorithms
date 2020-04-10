package array;

import java.util.TreeSet;

/**
 * #220. Contains Duplicate III
 * @author Ryan
 *
 */
public class ContainsDuplicatesThree {

	
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	TreeSet<Long> set = new TreeSet<Long>();
    	int i=0;
    	for(int j=0; j<=nums.length-1; j++){
    		//get ceiling and flooring
    		if(set.floor((long)nums[j]) != null){
    			if( Math.abs(nums[j] - set.floor((long)nums[j]))<=t )
    				return true;
    		}
    		if(set.ceiling((long)nums[j]) != null){
    			if(Math.abs(nums[j] - set.ceiling((long)nums[j])) <= t)
    				return true;
    		}

    		set.add((long) nums[j]);
    		if(j-i>=k)
    			set.remove((long)nums[i++]);
    	}
    	return false;
    }
	
	//brute force O(n*k)
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
		for(int i=0; i<=nums.length-2; i++){
			for(int j=i+1; j<=Math.min(i+k,nums.length-1); j++){
				long c = (long)nums[j]-(long)nums[i];
				if(Math.abs(c) <=(long)t)
					return true;
			}
    	}
    	return false;	
    }
    
	public static void main(String[] args) {
		int[] a = {-1,2147483647};
		int k = 1;
		int t = 2147483647;
		
		int[] b = {1,2};
		k=0;
		t=1;
		
//		int[] cc = {1,5,9,1,5,9};
//		k=2;
//		t=3;
//		
//		int[] d = {10,15,18,24};
//		k=3;
//		t=3;
		ContainsDuplicatesThree c = new ContainsDuplicatesThree();
		System.out.print(c.containsNearbyAlmostDuplicate(b, k, t));
	}

}
