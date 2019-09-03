package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class MajorityElement {

	//solution1 use a hash map
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
        	if(map.containsKey(num)){
        		map.put(num, map.get(num)+1);
        	}else{
        		map.put(num, 1);
        	}
        }
        int max = 0;
        int major = nums[0];
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        	if(entry.getValue() > max){
        		max = entry.getValue();
        		major = entry.getKey();
        	}
        }
        return major;
    }
    
    //solution2 return mid of sorted array
    public int majorityElement(int[] nums) {
    	Arrays.sort(nums);
    	return nums[(nums.length-1)/2];
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
