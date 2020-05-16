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

        int res1 = Integer.MIN_VALUE;
        int cur = A[0];
        for(int i=1; i<A.length; i++) {
            cur = Math.max(0 , cur) + A[i];
            res1 = Math.max(cur, res1);
        }

        int res2 = Integer.MAX_VALUE;
        cur = A[0];
        for(int i=1; i<A.length; i++) {
            cur = Math.min(0, cur) + A[i];
            res2 = Math.min(cur, res2);
        }
        if(res2 == sum) return res1;
        res2 = sum - res2;

        return Math.max(res1, res2);
    }

}
