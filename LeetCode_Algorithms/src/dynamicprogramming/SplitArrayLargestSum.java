package dynamicprogramming;

import java.util.Arrays;

public class SplitArrayLargestSum {

    int[] prefix_sum;
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        prefix_sum = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i ++) {
            sum += nums[i];
            prefix_sum[i] = sum;
        }

        int[][] memo = new int[n][m+1];
        for(int i = 0; i < n; i ++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(memo, 0, n, m);
    }

    private int helper(int[][] memo, int i, int n, int m) {
        if(m == 1) {
            return getSum(i, n-1);
        }
        if(memo[i][m] >= 0) {
            return memo[i][m];
        }

        int min = Integer.MAX_VALUE;
        for(int k = i; k + m <= n; k ++) {
            int segment = getSum(i, k);
            int rest = helper(memo, k + 1, n, m - 1);
            int temp = Math.max(segment, rest);
            min = Math.min(min, temp);
        }
        memo[i][m] = min;
        return min;
    }

    private int getSum(int i, int j) {
        return prefix_sum[j] - (i > 0 ? prefix_sum[i - 1] : 0);
    }

    public static void main(String[] args) {
        SplitArrayLargestSum s = new SplitArrayLargestSum();
        int[] a1 = new int[] {7,2,5,10,8};
        System.out.println(s.splitArray(a1, 2));

        int[] a2 = new int[] {1,2,3,4,5};
        System.out.println(s.splitArray(a2, 2));
    }
}
