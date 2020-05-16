package dynamicprogramming;

/**
 * 918. Maximum Sum Circular Subarray
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
 */
public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] A) {
        int sum = 0;
        for(int a : A)
            sum += a;

        int[] dp = new int [A.length];
        dp[0] = A[0];

        int res1 = A[0];
        for(int i=1; i<A.length; i++) {
            dp[i] = Math.max(0, dp[i-1]) + A[i];
            res1 = Math.max(dp[i], res1);
        }

        //get min sub-array, then Sum-min is max value of two-interval Subarray
        //[    [Min Array]      ]
        //[sub1[         ]sub2  ]
        int res2 = A[0];
        for(int i=1; i<A.length; i++) {
            dp[i] = Math.min(0, dp[i-1]) + A[i];
            res2 = Math.min(dp[i], res2);
        }
        if(res2 == sum) return res1;
        res2 = sum - res2;

        return Math.max(res1, res2);
    }

}
