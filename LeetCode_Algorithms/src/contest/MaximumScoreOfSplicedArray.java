package contest;

public class MaximumScoreOfSplicedArray {

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
        }

        int res1 = getMax(nums1, nums2, sum1);
        int res2 = getMax(nums2, nums1, sum2);
        return Math.max(res1, res2);
    }

    private int getMax (int[] nums1, int[] nums2, int sum1) {
        int n = nums1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = nums2[i] - nums1[i];
        }

        int cur = 0;
        int max_sum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i ++) {
            if(cur < 0) {
                cur = 0;
                cur += diff[i];
                max_sum = Math.max(cur, max_sum);
            }else {
                cur += diff[i];
                max_sum = Math.max(cur, max_sum);
            }
        }

        if(max_sum <= 0) return sum1;
        return sum1 + max_sum;
    }

    public static void main(String[] args) {
        MaximumScoreOfSplicedArray m = new MaximumScoreOfSplicedArray();
//        int[] a = new int[] {20,40,20,70,30};
//        int[] b = new int[] {50,20,50,40,20};
//        System.out.println(m.maximumsSplicedArray(a, b));

        int[] a = new int[] {28,34,38,14,30,31,23,7,28,3};
        int[] b = new int[] {42,35,7,6,24,30,14,21,20,34};
        System.out.println(m.maximumsSplicedArray(a, b));
    }
}
