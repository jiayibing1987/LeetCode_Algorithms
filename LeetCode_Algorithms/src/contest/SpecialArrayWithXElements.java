package contest;

import java.util.Arrays;

public class SpecialArrayWithXElements {

    // 0 1 2 3 4 index
    // 0 3 6 7 7 nums
    // 5 4 3

    // 0 0 3 4 4 nums
    // 5 4 3
    public int specialArray(int[] nums) {
        int res = -1;
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0; i<n; i++) {
            int leftNumber = n - i;
            if(nums[i] < leftNumber) {
                continue;
            }else {
                int pre = i-1>=0 ? nums[i-1] : -1;
                if(pre < leftNumber)
                    return leftNumber;
            }
        }
        return res;
    }

}
