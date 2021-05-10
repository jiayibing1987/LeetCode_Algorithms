package stack;

import java.util.Stack;

public class MaximumSubarrayMinProduct {

    public int maxSumMinProduct(int[] nums) {
        int m = 1000000000 + 7;
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        for(int i = n - 1; i >= 0; i--) {
            while(stack.peek() != n && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            right[i] = stack.peek();
            stack.push(i);
        }

        stack.clear();
        stack.push(-1);
        for(int i = 0; i < n; i++) {
            while(stack.peek() != -1 && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            left[i] = stack.peek();
            stack.push(i);
        }

        long[] preSum = new long[n];
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            preSum[i] = sum;
        }

        //assume each is the smallest number, find the farthest left and right pointer  to maximise sub-array: min * (sum range l , r)
        long max = 0;
        for(int i = 0; i < n; i ++) {
            long sumL = left[i] == -1 ? 0 :preSum[left[i]];
            long sumR = preSum[right[i] - 1];
            long min_product = nums[i] * (sumR - sumL);
            max = Math.max(max, min_product);
        }
        return (int) (max % m);
    }

}
