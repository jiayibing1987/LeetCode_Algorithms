package thirtydayschallenge;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {

    //dp solution
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums)
            sum += n;
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        int n = nums.length;

        boolean [][] dp = new boolean [n][target+1];
        dp[0][0] = true;
        for(int j=0; j<target; j++) {
            if(j == nums[0])
                dp[0][j] = true;
        }

        for(int i = 1; i < n; i++) {
            for(int j=0; j <= target; j++) {
                if(j < nums[i]) { // not taking cur number
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[n-1][target];
    }


    /**
     * recursion with memorization
     */
    boolean found;
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for(int n : nums)
            sum += n;
        if(sum % 2 != 0) return false;
        int target = sum / 2;

        dfs(nums, 0, 0, target, new HashSet<>());
        return found;
    }

    private void dfs(int[] nums, int startIndex, int sum, int target, Set<Integer> visited) {
        if(visited.contains(sum) || sum > target) {
            return;
        }
        if(sum == target) {
            visited.add(sum);
            found = true;
            return;
        }

        for(int i=startIndex; i<nums.length; i++) {
            dfs(nums, i + 1, sum + nums[i], target, visited);
        }
        visited.add(sum);
    }

    public static void main(String[] args) {
        int[] a = {1,2,5};
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        System.out.print(p.canPartition(a));
    }
}
