package thirtydayschallenge;

public class FindMinimuminRotatedSortedArrayTwo {

    public int findMin(int[] nums) {
        return binarySearch(0, nums.length-1, nums);
    }

    private int binarySearch(int low, int high, int[] nums) {
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[low] < nums[high])
                return nums[low];
            else if(nums[low] > nums[high]) {
                if(nums[mid] >= nums[low])
                    low = mid+1;
                else
                    high = mid;
            } else {
                return Math.min(binarySearch(low, mid, nums), binarySearch(mid+1, high, nums));
            }

        }
        return nums[low];
    }

    public static void main(String[] args) {
        FindMinimuminRotatedSortedArrayTwo f = new FindMinimuminRotatedSortedArrayTwo();
        int[] a = {10,10,10,1,10};
        int[] b = {10,1,10,10,10};
        System.out.println(f.findMin(a));
        System.out.println(f.findMin(b));

    }
}
