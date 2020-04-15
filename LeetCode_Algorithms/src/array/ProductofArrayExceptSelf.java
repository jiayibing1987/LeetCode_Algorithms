package array;

import java.util.Arrays;

/**
 * 238.Product of Array Except Self
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 */
public class ProductofArrayExceptSelf {

    //o(1) spaces
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n == 0) return new int[0];
        int[] res = new int[n];

        res[0] = 1;
        for(int i=1; i<n; i++)
            res[i] = nums[i-1] * res[i-1];

        int p = 1;
        for(int i=n-1; i>=0; i--){
            p = i==n-1 ? 1: p*nums[i+1];
            res[i] = p * res[i];
        }
        return res;
    }

    //o(n) space
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        if (n == 0) return new int[0];
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n];

        int p = 1;
        for (int i = 0; i < n; i++) {
            p *= nums[i];
            left[i] = p;
        }

        p = 1;
        for (int i = n - 1; i >= 0; i--) {
            p *= nums[i];
            right[i] = p;
        }

        for (int i = 0; i < n; i++) {
            int lp = i - 1 < 0 ? 1 : left[i - 1];
            int rp = i + 1 > n - 1 ? 1 : right[i + 1];
            res[i] = lp * rp;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new ProductofArrayExceptSelf().productExceptSelf(a)));
    }

}
