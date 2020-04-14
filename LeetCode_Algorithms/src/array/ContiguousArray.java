package array;

import java.util.HashMap;
import java.util.Map;

/**
 * #525. Contiguous Array
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        int max = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            count = nums[i] == 1 ? count+1 : count-1;
            if(count == 0){
                max = Math.max(max, i+1);
            }else {
                if (map.containsKey(count))
                    max = Math.max(max, i - map.get(count));
                else
                    map.put(count, i);
            }
        }
        return max;
    }


    //brute force
    public int findMaxLength1(int[] nums) {
        int count;
        int n = nums.length;
        int max = 0;
        for(int i=0; i<n-1; i++){
            count = 0;
            for(int j=i; j<n; j++){
                if(nums[j] == 1)
                    count++;
                else
                    count--;
                if(count == 0)
                    max = Math.max(max, j-i+1);
            }
        }
        return max;
    }
}
