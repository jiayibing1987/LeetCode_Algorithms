package thirtydayschallenge;

public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < nums[r]){
                if(nums[mid] < target && target <= nums[r]) // go right
                    l = mid + 1;
                else
                    r = mid - 1;
            }else{
                if(nums[l] <= target && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return -1;
    }

}
