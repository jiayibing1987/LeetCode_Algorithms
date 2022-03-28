package thirtydayschallenge;

public class SearchinRotatedSortedArrayTwo {

    public boolean search1(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(target == nums[mid]) return true;

            if(nums[low] < nums[mid]) {
                if(nums[low] <= target && target < nums[mid])
                    high = mid -1;
                else
                    low = mid + 1;
            }else if(nums[low] > nums[mid]){
                if(nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            } else {
                low ++;
            }
        }

        return false;
    }

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(target == nums[mid]) return true;
            if(nums[mid] > nums[low]) {
                if(target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < nums[low]) {
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            } else {
                low ++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArrayTwo s = new SearchinRotatedSortedArrayTwo();
        int[] a1 = new int[] {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
        //System.out.println(s.search(a1, 13));

        int[] a2 = new int[] {1,0,1,1,1};
        System.out.println(s.search(a2, 0));
    }
}
