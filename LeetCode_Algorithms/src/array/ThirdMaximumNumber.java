package array;

/**
 * 414. Third Maximum Number
 * @author Ryan
 *
 */
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        if(nums == null || nums.length ==0 ) return 0;
    	Integer firstMax = nums[0];
    	Integer secondMax = null;
    	Integer thirdMax = null;
    	for(int i=1; i<nums.length; i++){
    		if(nums[i] == firstMax)
    			continue;
    		if(secondMax != null && nums[i] == secondMax)
    			continue;
    		if(thirdMax != null && nums[i] == thirdMax)
    			continue;
    		else if(nums[i] > firstMax){
    			thirdMax = secondMax;
    			secondMax = firstMax;
    			firstMax = nums[i];
    		}
    		else if(secondMax == null || nums[i] > secondMax){
    			thirdMax = secondMax;
    			secondMax = nums[i];
    		}
    		else if(thirdMax == null || nums[i] > thirdMax){
    			thirdMax = nums[i];
    		}
    	}
    	return thirdMax == null? firstMax : thirdMax;
    }
    
	public static void main(String[] args) {
		ThirdMaximumNumber t = new ThirdMaximumNumber();
		int[] a = new int[]{2,2,3,1};
		System.out.println(t.thirdMax(a));
	}

}
