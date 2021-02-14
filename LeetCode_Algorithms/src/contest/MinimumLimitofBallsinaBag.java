package contest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumLimitofBallsinaBag {

    public int minimumSize(int[] nums, int maxOperations) {
        int low = 0;
        int high = 1_000_000_000;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(checkCondition(nums, maxOperations, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean checkCondition(int[] nums, int maxOperations, int p) {
        for(int num : nums) {
            if(num > p) {
                int o = num % p == 0 ? (num / p) - 1 : num / p;
                maxOperations -= o;
                if(maxOperations < 0) return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        MinimumLimitofBallsinaBag m = new MinimumLimitofBallsinaBag();
        System.out.println(m.minimumSize(new int[]{9}, 2));
        System.out.println(m.minimumSize(new int[]{2,4,8,2}, 4));
        System.out.println(m.minimumSize(new int[]{7,17}, 2));
        int[] a = {431,922,158,60,192,14,788,146,788,775,772,792,68,143,376,375,877,516,595,82,56,704,160,403,713,504,67,332,26};
        System.out.println(m.minimumSize(a, 80));
    }
}
