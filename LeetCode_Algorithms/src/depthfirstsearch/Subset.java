package depthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 
 *               ABC
 *           0    1    2
 *           A    B    C
 *        1    2   2 
 *       AB   AC   BC
 *       2
 *     ABC    
 * 
 * 
 * @author Ryan
 *
 */
public class  Subset{

	
	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	//start index indicates where to add new number into temp list
	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
		list.add(new ArrayList<Integer>(tempList));
		for(int i=start; i<nums.length; i++){
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i+1);
			tempList.remove(tempList.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3};
		Subset s = new Subset();
		System.out.println(s.subsets(a));
	}

}
