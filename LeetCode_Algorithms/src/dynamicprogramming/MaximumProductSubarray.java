package dynamicprogramming;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] pre;
        int max = nums[0];
        pre = new int[]{nums[0], nums[0]};

        for(int i=1; i<n; i++) {
            int[] cur;
            if(nums[i] == 0) {
                cur = new int[]{0, 0};
            }else if(pre[0] <0 && pre[1] < 0) {
                cur = new int[]{pre[0] * nums[i], nums[i]};
            }else if(pre[0] ==0 && pre[1] == 0) {
                cur = new int[]{nums[i], nums[i]};
            }else {
                cur = new int[]{pre[0] * nums[i], pre[1] * nums[i]};
            }
            int temp = Math.max(cur[0], cur[1]);
            max = Math.max(temp, max);
            pre = cur;
        }
        return max;
    }

}
