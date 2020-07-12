package thirtydayschallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 78. Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets.
 */
public class SubSet {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        results.add(Collections.emptyList());
        backTrack(results, new ArrayList<>(), nums, 0);
        return results;
    }

    private void backTrack(List<List<Integer>> results, List<Integer> list, int[] nums, int index) {
        for(int i=index; i< nums.length; i++){
            list.add(nums[i]);
            results.add(new ArrayList<>(list));
            backTrack(results, new ArrayList<>(list), nums, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println(new SubSet().subsets(nums));
    }
}
