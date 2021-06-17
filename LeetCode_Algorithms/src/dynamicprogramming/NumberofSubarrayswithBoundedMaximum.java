package dynamicprogramming;

public class NumberofSubarrayswithBoundedMaximum {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int[] dp = new int[n];

        int start = 0;
        int sum = 0;
        for(int i = 0; i <n; i ++) {
            if(nums[i] > right) {
                dp[i] = 0;
                start = i + 1;
            } else if (nums[i] < left) {
                dp[i] = i ==0 ? 0 : dp[i-1];
            } else {
                dp[i] = i - start + 1;
            }
            sum += dp[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        NumberofSubarrayswithBoundedMaximum n = new NumberofSubarrayswithBoundedMaximum();
        int[] a1 = new int[] {2, 1, 4, 3};
        System.out.println(n.numSubarrayBoundedMax(a1, 2, 3));

        int[] a2 = new int[] {3};
        System.out.println(n.numSubarrayBoundedMax(a2, 2, 3));

        int[] a3 = new int[] {1};
        System.out.println(n.numSubarrayBoundedMax(a3, 2, 3));

        int[] a4 = new int[] {4};
        System.out.println(n.numSubarrayBoundedMax(a4, 2, 3));
    }

}
