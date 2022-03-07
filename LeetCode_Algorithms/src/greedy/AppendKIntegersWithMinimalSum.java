package greedy;

import java.util.Arrays;

public class AppendKIntegersWithMinimalSum {

    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        long res = 0;
        long pre = 0;

        for(int i = 0; i < nums.length && k > 0; i ++) {
            long missing = nums[i] - pre - 1;
            if(missing <= 0) {pre = nums[i]; continue;}

            if(missing <= k) {
                res += calc(pre + 1, nums[i] - 1);
                k -= missing;
            } else {
                res += calc(pre + 1, pre + k);
                return res;
            }
            pre = nums[i];
        }

        if(k > 0) {
            res += calc(nums[n - 1] + 1, nums[n - 1] + k);
        }
        return res;
    }

    private long calc(long a, long b) {
        return (a + b) * (b - a + 1) / 2;
    }

    public static void main(String[] args) {
        AppendKIntegersWithMinimalSum a = new AppendKIntegersWithMinimalSum();
        int[] a1 = new int[] {96,44,99,25,61,84,88,18,19,33,60,86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84};
        System.out.println(a.minimalKSum(a1, 35));
    }
}
