package dynamicprogramming;

import java.util.*;

/**
 * 368. Largest Divisible Subset
 */
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        map.put(nums[0], list);

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int max_index = 0;
        for(int i=1; i<nums.length; i++) {
            int pre_max = -1;
            for(int j=0; j<i; j++) {
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]){
                    dp[i] =  dp[j] + 1;
                    pre_max = j;
                }
            }
            if(dp[i] > dp[max_index])
                max_index = i;

            List<Integer> maxList;
            if(pre_max != -1){
                maxList = new ArrayList<>(map.get(nums[pre_max]));
            }else {
                maxList = new ArrayList<>();
            }
            maxList.add(nums[i]);
            map.put(nums[i], maxList);
        }

        return map.get(nums[max_index]);
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,2,3};
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(a));
    }

}
