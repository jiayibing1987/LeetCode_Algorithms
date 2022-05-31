package contest;

import java.util.Stack;

public class StepstoMakeArrayNondecreasing {

    public int totalSteps(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i --) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int j = stack.pop();
                dp[i] = Math.max(dp[i] + 1, dp[j]);
            }
            stack.push(i);
        }

        int max = 0;
        for(int v : dp) {
            max = Math.max(max, v);
        }
        return max;
    }

    public static void main(String[] args) {
        StepstoMakeArrayNondecreasing s = new StepstoMakeArrayNondecreasing();
        int[] a1 = new int[] {5,3,4,4,7,3,6,11,8,5,11};
        //System.out.println(s.totalSteps(a1));

        int[] a2 = new int[] {7,14,4,14,13,2,6,13};
        System.out.println(s.totalSteps(a2));
    }
}
