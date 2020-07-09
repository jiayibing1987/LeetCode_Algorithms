package thirtydayschallenge;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> results = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int target = 0 - nums[i];
            int l = i + 1;
            int h = nums.length - 1;
            while (l < h) {
                if(nums[l] + nums[h] == target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[h]);
                    results.add(temp);
                    l++;
                    h--;
                }else if (nums[l] + nums[h] < target){
                    l++;
                }else{
                    h--;
                }
            }

        }
        return new ArrayList<>(results);
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> results = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            twoSum(nums, 0 - nums[i], i, results);
        }
        return new ArrayList<>(results);
    }

    private void twoSum(int[] nums, int target, int index, Set<List<Integer>> results) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == index) continue;
            if (set.contains(nums[i])) continue;
            if (map.containsKey(nums[i])) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[index]);
                temp.add(nums[map.get(nums[i])]);
                temp.add(nums[i]);
                set.add(nums[i]);
                set.add(nums[map.get(nums[i])]);
                Collections.sort(temp);
                results.add(temp);
            } else {
                map.put(target - nums[i], i);
            }
        }
    }


}
