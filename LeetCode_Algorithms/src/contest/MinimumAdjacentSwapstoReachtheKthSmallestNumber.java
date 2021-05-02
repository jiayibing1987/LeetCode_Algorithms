package contest;

import java.util.Arrays;

public class MinimumAdjacentSwapstoReachtheKthSmallestNumber {

    public int getMinSwaps(String num, int k) {
        String temp = num;
        for(int i = 0; i< k; i++) {
            temp = nextGreaterElement(temp);
        }
        return CountSteps(num.toCharArray(), temp.toCharArray(), num.length());
    }

    public static int CountSteps(char []s1, char[] s2, int size)
    {
        int i = 0, j;
        int result = 0;

        // Iterate over the first string and convert
        // every element equal to the second string
        while (i < size)
        {
            j = i;

            // Find index element of first string which
            // is equal to the ith element of second string
            while (s1[j] != s2[i])
            {
                j += 1;
            }

            // Swap adjacent elements in first string so
            // that element at ith position becomes equal
            while (i < j)
            {

                // Swap elements using temporary variable
                char temp = s1[j];
                s1[j] = s1[j - 1];
                s1[j - 1] = temp;
                j -= 1;
                result += 1;
            }
            i += 1;
        }
        return result;
    }

    public String nextGreaterElement(String input) {
        char[] nums = input.toCharArray();
        int length = nums.length;

        int j = -1;
        for(int i=length-1; i>0; i--) {
            if(nums[i-1] < nums[i]) {
                j = i-1;
                break;
            }

        }

        //find min digit between j+1 to n-1,also need to be greater then nums[j]
        int minIndex = j+1;
        char minDigit = '9';
        for(int i=j+1; i<length; i++) {
            if(nums[i] < nums[minIndex] && nums[i] > nums[j]) {
                minIndex = i;
                minDigit = nums[i];
            }
        }
        //swap with j
        char temp = nums[j];
        nums[j] = nums[minIndex];
        nums[minIndex] = temp;

        Arrays.sort(nums, j+1, length);
        return new String(nums);
    }

    public static void main(String[] args) {
        MinimumAdjacentSwapstoReachtheKthSmallestNumber m = new MinimumAdjacentSwapstoReachtheKthSmallestNumber();
        System.out.println(m.getMinSwaps("5489355142", 4));
        System.out.println(m.getMinSwaps("11112", 4));
        System.out.println(m.getMinSwaps("11112", 1));
    }
}
