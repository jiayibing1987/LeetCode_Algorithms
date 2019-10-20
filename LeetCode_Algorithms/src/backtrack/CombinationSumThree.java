package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * @author Ryan
 *
 */
public class CombinationSumThree {

	List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(0, k, n, 1, 0, new ArrayList<Integer>());
    	return list;
    }
    
    private void helper(int curDepth, int maxDepth, int target, int start, int sum, List<Integer> combination){
    	if(sum > target)
    		return;
    	if(curDepth == maxDepth){
    		if(sum == target)
    			list.add(new ArrayList<Integer>(combination));
    		return;
    	}
    	
    	for(int i=start; i<=9; i++){
    		combination.add(i);
    		helper(curDepth+1, maxDepth, target, i+1, sum+i, combination);
    		combination.remove(combination.size()-1);
    	}
    }
    
    
	public static void main(String[] args) {
		CombinationSumThree c = new CombinationSumThree();
		System.out.println(c.combinationSum3(3, 7));
	}

}
