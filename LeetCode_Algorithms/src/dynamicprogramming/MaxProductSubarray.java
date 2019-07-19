package dynamicprogramming;

/**
 * 
 *
 */
public class MaxProductSubarray {

    public int maxProduct(int[] nums) {
    	int res = nums[0];
    	//max product value until index i
    	int[] p = new int[nums.length];
    	//min product value until index i
    	int[] n = new int[nums.length];
    	p[0] = nums[0];
    	n[0] = nums[0];
    	
    	for(int i=1; i<nums.length; i++){
    		//pi can be max value of pi-1*numi(both positive) or ni-1*numi(both negative)
    		//if pi is 0 then just take numi
    		p[i] = Math.max(Math.max(p[i-1]*nums[i], n[i-1]*nums[i]), nums[i]);
    		n[i] = Math.min(Math.min(p[i-1]*nums[i], n[i-1]*nums[i]), nums[i]);
    		res = Math.max(res, p[i]);
    	}
    	
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
