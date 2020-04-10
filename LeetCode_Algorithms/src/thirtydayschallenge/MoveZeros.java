package thirtydayschallenge;

import java.util.Arrays;

public class MoveZeros {
    public void moveZeroes1(int[] nums) {
        if(nums.length <= 1) return;
        int p1 = 0;
        int p2 = 0;
        int n = nums.length;
        while(p2 < n-1 || nums[p2] != 0) {
            while(p1 < n-1 && nums[p1] != 0)
                p1++;
            if(p1 == n-1) break;
            p2 = p1;
            while(p2 < n && nums[p2] == 0)
                p2++;
            if(p2 == n) break;
            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
        }
    }

    public void moveZeroes(int[] nums) {
        if(nums.length == 0) return;
        int slow = 0;
        for(int i=0 ;i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        for(int j=slow; j<nums.length; j++)
            nums[j] = 0;
        return;
    }

    public static void main (String[] args){
        int[] a = {0,1,0,3,12};
        new MoveZeros().moveZeroes(a);
        System.out.println(Arrays.toString(a));
        int[] b = {1,0,1};
        new MoveZeros().moveZeroes(b);
        System.out.println(Arrays.toString(b));
    }
}
