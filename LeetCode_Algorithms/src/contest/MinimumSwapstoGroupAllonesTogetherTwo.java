package contest;

import java.sql.SQLOutput;
import java.util.Arrays;

public class MinimumSwapstoGroupAllonesTogetherTwo {

    public int minSwaps(int[] data) {
        int n = data.length;
        int ones = Arrays.stream(data).sum();
        int cnt_one = 0, max_one = 0;
        int left = 0, right = 0;

        while (right < data.length) {
            // updating the number of 1's by adding the new element
            cnt_one += data[right++];
            // maintain the length of the window to ones
            if (right - left > ones) {
                // updating the number of 1's by removing the oldest element
                cnt_one -= data[left++];
            }
            // record the maximum number of 1's in the window
            max_one = Math.max(max_one, cnt_one);
        }
        int temp1 = ones - max_one;

        int zeros = n - ones;
        int cnt_zero = 0, max_zero = 0;
        left = 0; right = 0;
        while (right < data.length) {
            cnt_zero += (data[right++] == 0) ? 1 : 0;
            if (right - left > zeros) {
                if(data[left] == 0)
                    cnt_zero--;
                left++;
            }
            max_zero = Math.max(max_zero, cnt_zero);
        }
        int temp2 = zeros - max_zero;

        return Math.min(temp1, temp2);
    }

    public static void main(String[] args) {
        MinimumSwapstoGroupAllonesTogetherTwo m = new MinimumSwapstoGroupAllonesTogetherTwo();
        int[] a1 = new int[] {0,1,0,1,1,0,0};
        System.out.println(m.minSwaps(a1));

        int[] a2 = new int[] {0,1,1,1,0,0,1,1,0};
        System.out.println(m.minSwaps(a2));

        int[] a3 = new int[] {1,1,0,0,1};
        System.out.println(m.minSwaps(a3));
    }

}
