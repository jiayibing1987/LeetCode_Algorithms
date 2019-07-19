package array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappeared {

    public List<Integer> findDisappearedNumbers(int[] nums) {
    	boolean[] tags = new boolean[nums.length+1];
    	List<Integer> results = new ArrayList<Integer>();
    	for(int i=0; i<nums.length; i++){
    		tags[nums[i]] = true;
    	}
    	
    	for(int i=1; i<nums.length+1; i++){
    		if(tags[i]==false)
    			results.add(i);
    	}
    	return results;
    }
    
	public static void main(String[] args) {
		FindAllNumbersDisappeared f = new FindAllNumbersDisappeared();
		int[] a = {4,3,2,7,8,2,3,1};
		System.out.println(f.findDisappearedNumbers(a));
	}

}
