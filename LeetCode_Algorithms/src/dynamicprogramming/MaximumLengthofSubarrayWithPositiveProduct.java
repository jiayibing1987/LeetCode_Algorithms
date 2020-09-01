package dynamicprogramming;

public class MaximumLengthofSubarrayWithPositiveProduct {

    public int getMaxLen(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0] = nums[0] == 0 ? new int[] {0, 0} : (nums[0] > 0 ? new int[] {1,1} : new int[]{-1,-1});
        int count = nums[0] < 0 ? 1 : 0;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] == 0) {
                dp[i] = new int[]{0,0};
                count = 0;
            }
            else {
                int x = dp[i-1][0] == 0 ? 1 : (dp[i-1][0] / Math.abs(dp[i-1][0]));
                dp[i][0] = (Math.abs(dp[i-1][0]) + 1) * (nums[i] / Math.abs(nums[i])) * x;

                if(count == 1) {
                    dp[i][1] = nums[i] / Math.abs(nums[i]);
                    count ++;
                }
                else {
                    int y = dp[i-1][0] == 0 ? 1 : (dp[i-1][1] / Math.abs(dp[i-1][1]));
                    dp[i][1] = (Math.abs(dp[i-1][1]) + 1) * (nums[i] / Math.abs(nums[i])) * y;
                }
                if(nums[i] < 0) count ++;
            }

        }

        int max = 0;
        for(int[] n : dp) {
            if(Math.max(n[0], n[1]) > max)
                max = Math.max(n[0], n[1]);
        }
        return max;
    }

    //-1,       2,     -1,      -1     1       -1
    //[-1,-1] [-2,1] [3, -2]  [-4, 3] [-5 4] [6, -5]

    // -7,   -10,  -7,  21,  20,-12,-34,26,2
    //-1-1,  2,-1 -3,
    public static void main(String[] args) {
        MaximumLengthofSubarrayWithPositiveProduct m = new MaximumLengthofSubarrayWithPositiveProduct();
        int[] a = {-16,0,-14,4,-13,-17,-19,-17,-21,-11,12};
        System.out.println(m.getMaxLen(a));
    }
}
