package twopointer;

import java.util.Arrays;

public class DistributeElementsIntoTwoArrays {

    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        int i1 = 0;
        int i2 = 0;
        arr1[0] = nums[0];
        arr2[0] = nums[1];

        for(int j=2; j<n; j++) {
            if(arr1[i1] >= arr2[i2]) {
                arr1[++i1] = nums[j];
            } else {
                arr2[++i2] = nums[j];
            }
        }

        int[] res = new int[n];
        for(int i = 0; i<= i1; i++) {
            res[i] = arr1[i];
        }

        i2 = 0;
        for(int i=i1+1; i<n; i++) {
            res[i] = arr2[i2++];
        }
        return res;
    }

    public static void main (String[] args) {
        DistributeElementsIntoTwoArrays d = new DistributeElementsIntoTwoArrays();
        int[] nums1 = new int[] {2,1,3};
        System.out.println(Arrays.toString(d.resultArray(nums1)));
    }
}
