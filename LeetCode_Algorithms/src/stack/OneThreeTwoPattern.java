package stack;

import java.util.Stack;

public class OneThreeTwoPattern {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int[] min = new int[n];
        min[0] = nums[0];
        for(int i = 1; i < n; i ++) {
            min[i] = Math.min(min[i -1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i > 0; i --) {
            while(!stack.isEmpty() && nums[i] > stack.peek()) {
                int k = stack.pop();
                if(min[i - 1] < nums[i] && min[i - 1] < k)
                    return true;
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        OneThreeTwoPattern o = new OneThreeTwoPattern();
        int[] a = new int[] {3,5,0,3,4};
        System.out.println(o.find132pattern(a));
    }
}
