package contest;

public class SumofBeautyintheArray {

    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int res = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        for(int i = 1; i < n; i ++) {
            left[i] = Math.max(nums[i], left[i - 1]);
        }

        right[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i --) {
            right[i] = Math.min(nums[i], right[i + 1]);
        }

        for(int i = 1; i < n - 1;i ++) {
            int leftMax = left[i - 1];
            int rightMin = right[i + 1];
            if(nums[i] > leftMax && nums[i] < rightMin) {
                res += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SumofBeautyintheArray s = new SumofBeautyintheArray();
        int[] a1 = new int[] {1,2,3};
        System.out.println(s.sumOfBeauties(a1));
        int[] a2 = new int[] {2,4,6,4};
        System.out.println(s.sumOfBeauties(a2));
        int[] a3 = new int[] {3,2,1};
        System.out.println(s.sumOfBeauties(a3));
    }

}
