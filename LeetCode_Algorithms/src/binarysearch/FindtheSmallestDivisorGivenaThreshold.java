package binarysearch;

public class FindtheSmallestDivisorGivenaThreshold {

    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for(int n : nums)
            max = Math.max(n, max);

        int low = 1;
        int high = max;

        while(low < high) {
            int mid = low + (high - low) / 2;
            int divisionSum = getDivisionSum(nums, mid);
            if(divisionSum > threshold) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int getDivisionSum(int[] nums, int mid) {
        double res = 0.0;
        for(int n : nums) {
            res += Math.ceil((double) n / (double) mid);
        }
        return (int)res;
    }

}
