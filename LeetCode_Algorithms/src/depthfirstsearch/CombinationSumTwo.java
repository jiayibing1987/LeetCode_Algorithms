package depthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {

	List<List<Integer>> results = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	results.clear();
        Arrays.sort(candidates);
        backTrack(candidates, 0, 0, target, new ArrayList<Integer>());
        return results;
    }
    
    private void backTrack(int[] canditates, int start, int sum, int target, List<Integer> combination){
    	if(sum == target){
    		results.add(new ArrayList<Integer>(combination));
    		return;
    	}else if(sum > target){
    		return;
    	}else{
    		for(int i=start; i<canditates.length; i++){
    			//skip duplicates
    			if(i>start && canditates[i]==canditates[i-1]) continue;
    			combination.add(canditates[i]);
    			backTrack(canditates, i+1, sum+canditates[i], target, combination);
    			combination.remove(combination.size()-1);
    		}
    	}
    }
    
	public static void main(String[] args) {
		CombinationSumTwo c = new CombinationSumTwo();
		int[] a = { 2, 3, 7 };
		System.out.println(c.combinationSum2(a, 7));
		
		int[] b = {10,1,2,7,6,1,5};
		System.out.println(c.combinationSum2(b, 8));

	}

}
