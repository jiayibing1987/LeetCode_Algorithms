package slidingwindow;

import java.util.Arrays;

public class FrequencyoftheMostFrequentElement {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n == 1) return 1;

        int left = n - 1;
        int right = n - 1;
        int max = 0;
        int sum = 0;

        while (right > 0) {
            while(left > 0  && sum < k) {
                int moveLeft = nums[right] - nums[left-1];
                if(sum + moveLeft <= k) {
                    left --;
                    sum += moveLeft;
                }else {
                    break;
                }
            }
            int len = right - left + 1;
            max = Math.max(max, len);

            int moveRight = (nums[right] - nums[right - 1]) * (len - 1);
            sum -= moveRight;
            right --;
        }
        return max;
    }

    public static void main(String[] args) {
        FrequencyoftheMostFrequentElement f = new FrequencyoftheMostFrequentElement();
        System.out.println(f.maxFrequency(new int[]{1, 2, 4}, 5));
        System.out.println(f.maxFrequency(new int[]{1,4,8,13}, 5));
        System.out.println(f.maxFrequency(new int[]{10000}, 10000));
    }
}
