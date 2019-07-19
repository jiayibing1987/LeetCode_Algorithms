package depthfirstsearch;

import java.util.*;

//#46 Given a collection of distinct integers, return all possible permutations.
public class Permutation {

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
//		if(remains.size() == 0){
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
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		backTrack(nums, results, new ArrayList<Integer>());
		return results;
	}
	
	private void backTrack(int[] nums, List<List<Integer>> results, List<Integer> temp){
		if(temp.size() == nums.length){
			results.add(new ArrayList<Integer>(temp));
			return;
		}
		else{
			for(int i=0; i<nums.length; i++){
				if(!temp.contains(nums[i])){
					temp.add(nums[i]);
					backTrack(nums, results, temp);
					temp.remove(temp.size()-1);
				}
			}
		}
	}
	
	
	public static void main(String[] args){
		Permutation p = new Permutation();
		int[] nums = {1,2,3};
		System.out.println(p.permute(nums));
	}
}
