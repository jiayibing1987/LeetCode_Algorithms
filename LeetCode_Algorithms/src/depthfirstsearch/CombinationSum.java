package depthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * #39
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 *  find all unique combinations in candidates where the candidate numbers sums to target.
 * @author Ryan
 *
 */
public class CombinationSum {

	List<List<Integer>> results = new ArrayList<List<Integer>>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		helper(candidates, target, 0, 0,new ArrayList<Integer>());
		return results;
	}

	private void helper(int[] candidates, int target, int start, int sum, List<Integer> combination) {
		if (sum == target) {
			results.add(new ArrayList<Integer>(combination));
			return;
		} else if (sum > target) {
			return;
		}
		
		for (int j = start; j < candidates.length; j++) {
			combination.add(candidates[j]);
			helper(candidates, target, j, sum+candidates[j], combination);
			combination.remove(combination.size()-1);
		}
	}


	public static void main(String[] args) {
		CombinationSum c = new CombinationSum();
		int[] a = { 2, 3, 7 };
		System.out.println(c.combinationSum(a, 7));
	}

}
