package string;

import java.util.Arrays;

public class NextGreaterElementThree {

    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int length = nums.length;
        if(length == 1) return -1;

        int j = -1;
        for(int i=length-1; i>0; i--) {
            if(nums[i-1] < nums[i]) {
                j = i-1;
                break;
            }

        }
        if(j == -1) return -1;

        //find min digit between j+1 to n-1,
        int minIndex = j+1;
        for(int i=j+1; i<length; i++) {
            if(nums[i] < nums[minIndex] && nums[i] > nums[j]) {
                minIndex = i;
            }
        }
        //swap with j
        char temp = nums[j];
        nums[j] = nums[minIndex];
        nums[minIndex] = temp;

        Arrays.sort(nums, j+1, length);
        String s = new String(nums);
        long l = Long.valueOf(s);
        if(l > Integer.MAX_VALUE)
            return -1;
        else
            return (int) l;
    }

    public static void main (String[] args) {
        NextGreaterElementThree ng = new NextGreaterElementThree();
        System.out.println(ng.nextGreaterElement(230241));
        System.out.println(ng.nextGreaterElement(1234));
    }

}
