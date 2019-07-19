package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class NumArray {

	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
    public NumArray(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
        	sum += nums[i];
        	map.put(i, sum);
        }
    }
    
    public int sumRange(int i, int j) {
        return map.get(j)- (i==0? 0 : map.get(i-1));
    }
    
    
	public static void main(String[] args) {
		int[] a = {-2, 0, 3, -5, 2, -1};
		NumArray n = new NumArray(a);
		System.out.println(n.sumRange(0, 5));
	}

}
