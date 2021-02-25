package stack;

import java.util.Stack;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int low = n-1;
        int high = 0;
        Stack<Integer> stack = new Stack<>();

        // 1 2 3 3 3 3 2 4 4 4
        for (int i = 0; i < n; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            if (nums[i] > nums[stack.peek()]) {
                stack.push(i);
            } else if (nums[i] == nums[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                    int index = stack.pop();
                    low = Math.min(index, low);
                }
                stack.push(i);
            }
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            if (nums[i] < nums[stack.peek()]) {
                stack.push(i);
            } else if (nums[i] == nums[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    int index = stack.pop();
                    high = Math.max(index, high);
                }
                stack.push(i);
            }
        }
        return high > low ? high - low + 1 : 0;
    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();
        int[] a = {2,6,4,8,10,9,15};
        int[] b = {1,3,5,4,2};

        System.out.println(s.findUnsortedSubarray(b));
    }
}
