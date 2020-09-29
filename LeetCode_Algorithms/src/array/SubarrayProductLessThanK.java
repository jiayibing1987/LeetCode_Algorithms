package array;

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long product = 1;
        int curEnd = 0;
        int curStart = 0;
        int res = 0;
        for(; curEnd < nums.length; curEnd++) {
            product *= nums[curEnd];
            while(curStart < curEnd && product >= k){
                product /= nums[curStart++];
            }
            if(product < k)
                res += curEnd- curStart + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK s = new SubarrayProductLessThanK();
        int[] a = {1, 2, 3};
        int[] b = {10,5,2,6};
        System.out.println(s.numSubarrayProductLessThanK(a, 0));
        System.out.println(s.numSubarrayProductLessThanK(b, 100));
    }
}
