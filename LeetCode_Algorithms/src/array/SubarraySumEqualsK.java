package array;

import java.util.HashMap;
import java.util.Map;

/**
 * #560. Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< n; i++) {
            nums[i] = i == 0 ? nums[i] : nums[i - 1] + nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int count = map.getOrDefault(k, 0);
        for(int i = 0; i < n; i++) {
            if(map.get(nums[i]) == 1)
                map.remove(nums[i]);
            else
                map.put(nums[i], map.get(nums[i]) - 1);
            if(map.containsKey(nums[i] + k))
                count += map.get(nums[i] + k);
        }
        return count;
    }

    public static void main (String[] args) {
        int[] a = {1, 1, 1};
        System.out.println(new SubarraySumEqualsK().subarraySum(a , 2));
    }
}
