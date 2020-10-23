package array;

import java.util.Stack;

public class OneThteeTwoPattern {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int[] minArray = new int[n];
        Stack<Integer> stack = new Stack<>();


        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(nums[i], min);
            minArray[i] = min;
        }

        for (int j = n - 1; j > 0; j--) {
            if (nums[j] != minArray[j]) {
                while (!stack.isEmpty() && stack.peek() <= minArray[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }

    public boolean find132pattern1(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int[] minArray = new int[n];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(nums[i], min);
            minArray[i] = min;
        }

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j] && nums[i] > minArray[j])
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,-4,-3,-5,-1};
        OneThteeTwoPattern o = new OneThteeTwoPattern();
        System.out.println(o.find132pattern(a));
    }
}
