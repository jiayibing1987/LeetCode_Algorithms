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
        
        for(int i=0; i<nums.length; i++){
        	if(map.containsKey(target - nums[i])){
        		result[1] = i;
        		result[0] = map.get(target - nums[i]);
        		break;
        	}      		
        	map.put(nums[i], i);
        }
        return result;
    }
    
    public static void main (String[] args){
    	TwoSum ts = new TwoSum();
    	int[] nums = new int[]{2, 7, 11, 15};	
    	System.out.println(ts.twoSum(nums, 9)[0]);
    	System.out.println(ts.twoSum(nums, 9)[1]);
    }
}
