package array;

/**
 * 167. Two Sum II - Input array is sorted
 * Given an array of integers that is already sorted in ascending order,
 *  find two numbers such that they add up to a specific target number.
 * @author Ryan
 *
 */
public class TwoSumTwo {

    public int[] twoSum(int[] numbers, int target) {
    	int low = 0;
    	int high = numbers.length-1;
    	while(low < high){
    		int sum = numbers[low]+numbers[high];
    		if(sum == target)
    			return  new int[]{low+1, high+1};
    		if(sum < target)
    			low++;
    		else
    			high--;
    	}
    	return  new int[]{low, high};
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
