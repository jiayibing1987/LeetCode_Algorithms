package depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * #77. Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * @author Ryan
 *
 */
public class Combinations {

	
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		backTrack(results, new ArrayList<Integer>(), 1, n, k);
		return results;
	}

	private void backTrack(List<List<Integer>> results, List<Integer> temp, int start, int n, int k){
		if(temp.size() == k){
			results.add(new ArrayList<Integer>(temp));
		}else{
			for(int i=start; i<=n; i++){
				temp.add(i);
				backTrack(results, temp,i+1, n, k);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		Combinations c = new Combinations();
		System.out.println(c.combine(4, 2));
	}

}
