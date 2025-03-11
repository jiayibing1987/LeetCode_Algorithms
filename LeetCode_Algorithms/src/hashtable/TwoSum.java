package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * #1
 * @author Ryan
 *
 */
public class TwoSum {
	
    public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++) {
			map.put(nums[i], i);
		}

		for(int i=0; i<nums.length; i++) {
			int lookFor = target - nums[i];
			if(map.containsKey(lookFor) && map.get(lookFor) != i) {
				result[0] = i;
				result[1] = map.get(lookFor);
				break;
			}
		}

		return result;
    }
    
    public static void main (String[] args){
    	TwoSum ts = new TwoSum();
    	int[] nums = new int[]{2, 7, 11, 15};	
    	//System.out.println(ts.twoSum(nums, 9)[0]);
    	//System.out.println(ts.twoSum(nums, 9)[1]);

		int[] nums1 = new int[]{3, 2, 4};
		System.out.println(ts.twoSum(nums1, 6)[0]);
		System.out.println(ts.twoSum(nums1, 6)[1]);
    }
}
