package backtrack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartitiontoKEqualSumSubsets {

    Map<String, Boolean> memo;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        memo = new HashMap<>();
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums)
            totalSum += num;
        int targetSum = totalSum / k;
        if(totalSum % k != 0) return false;

        char[] used = new char[n];
        Arrays.fill(used, '0');
        return helper(nums, used, 0, targetSum, 0, k);
    }

    private boolean helper(int[] nums, char[] used, int curSum, int targetSum, int count, int k) {
        if(count == k - 1)
            return true;
        if(curSum > targetSum)
            return false;

        String usedString = new String(used);
        String key = usedString + "#" + count;
        if(memo.containsKey(key))
            return memo.get(key);

        if(curSum == targetSum) {
            boolean ans = helper(nums, used, 0, targetSum, count + 1, k);
            memo.put(key, ans);
            return ans;
        }

        for(int i = 0; i < nums.length; i ++) {
            if(used[i] == '0') {
                used[i] = '1';
                if(helper(nums, used, curSum + nums[i], targetSum, count, k))
                    return true;
                used[i] = '0';
            }
        }
        memo.put(key, false);
        return false;
    }
}
