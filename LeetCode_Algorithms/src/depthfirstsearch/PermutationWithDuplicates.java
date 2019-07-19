package depthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationWithDuplicates {

//	public static List<List<Integer>> permute(int[] nums) {
//		List<List<Integer>> perms = new ArrayList<List<Integer>>();
//		List<Integer> remains = new ArrayList<Integer>();
//		for(int i=0; i<nums.length; i++)
//			remains.add(nums[i]);
//		perm(perms, new ArrayList<>(), remains);
//		return perms;
//	}
//	
//	private static void perm(List<List<Integer>> perms, List<Integer>onePerm, List<Integer> remains){
//		if(remains.size() == 0 && perms.contains(onePerm) == false){
//			perms.add(new ArrayList<Integer>(onePerm));
//			return;
//		}else{
//			for(int i=0; i<remains.size(); i++){
//				onePerm.add(remains.get(i));
//				List<Integer> copy = new ArrayList<Integer>(remains);
//				copy.remove(i);
//				perm(perms, onePerm, copy);
//				onePerm.remove(onePerm.size()-1);//need to remove last added number when trace back to last level
//			}
//		}
//	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		backTrack(nums, results, new ArrayList<Integer>(), used);
		return results;
	}
	
	private void backTrack(int[] nums, List<List<Integer>> results, List<Integer> temp, boolean[] used){
		if(temp.size() == nums.length){
			results.add(new ArrayList<Integer>(temp));
		}else{
			for(int i=0; i<nums.length; i++){
				if(used[i] || (i>=1 && nums[i] == nums[i-1]) && used[i-1]==false) continue;
				used[i] = true;
				temp.add(nums[i]);
				backTrack(nums, results, temp,used);
				used[i] = false;
				temp.remove(temp.size()-1);
			}
		}
	}
	
	public static void main(String[] args){
		PermutationWithDuplicates p2 = new PermutationWithDuplicates();
		int[] nums = {1,1,2};
		//System.out.println(p2.permuteUnique(nums));
		
		int[] a = {1};
		System.out.println(p2.permuteUnique(a));

	}

}
