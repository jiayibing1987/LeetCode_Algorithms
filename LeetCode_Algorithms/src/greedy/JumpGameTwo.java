package greedy;

import thirtydayschallenge.BackspaceStringCompare;

/**
 * 45. Jump Game II
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 */
public class JumpGameTwo {

    public int jump(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 0;
        int n = nums.length;
        int right_bound = 0;
        int next_max = 0;
        for (int i = 0; i < n; i++) {
            next_max = Math.max(i + nums[i], next_max);
            if (next_max >= n - 1) return count + 1;

            if (i == right_bound) {
                count++;
                right_bound = next_max;
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        int[] a = {2,3,1,1,4};
        System.out.println(new JumpGameTwo().jump(a));
    }

}
