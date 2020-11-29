package contest;

import java.util.Arrays;
import java.util.Stack;

public class FindtheMostCompetitiveSubsequence {

    public int[] mostCompetitive(int[] nums, int k) {
        int[] res= new int[k];
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(stack.size() == k && nums[i] >= nums[stack.peek()])
                continue;

            while(!stack.isEmpty() && nums[i] < nums[stack.peek()] && (stack.size() -1) + (n-i) >= k) {
                stack.pop();
            }
            stack.push(i);
        }

        for(int i=k-1; i>=0; i--) {
            res[i] = nums[stack.pop()];
        }
        return res;
    }

    public static void main(String[] args) {
        FindtheMostCompetitiveSubsequence f = new FindtheMostCompetitiveSubsequence();
        int[] a = {3,5,2,6};
        int[] b = {2,4,3,3,5,4,9,6};
        System.out.println(Arrays.toString(f.mostCompetitive(a, 2)));
        System.out.println(Arrays.toString(f.mostCompetitive(b, 4)));
    }


}
