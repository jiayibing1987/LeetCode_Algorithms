package dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class JumpGameVI {

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        pq.add(new int[] {nums[0], 0});
        for(int i = 1; i < n; i ++) {
            while(pq.peek()[1] < i - k) {
                pq.poll();
            }
            dp[i] = pq.peek()[0] + nums[i];
            pq.add(new int[] {dp[i], i});
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        JumpGameVI g = new JumpGameVI();
        int[] a1 = new int[] {1,-1,-2,4,-7,3};
        //System.out.println(g.maxResult(a1, 2));

        int[] a2 = new int[] {100,-1,-100,-1,100};
        System.out.println(g.maxResult(a2, 2));
    }
}
