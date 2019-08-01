package array;

/**
 * 540. Single Element in a Sorted Array
 * Given a sorted array consisting of only integers where every element appears exactly twice 
 * except for one element which appears exactly once. Find this single element that appears only once.
 * @author Ryan
 *
 */
public class SingleElementinaSortedArray {
	
    //XOR operation O(n)
    public int singleNonDuplicate1(int[] nums) {
        int res = 0;
        for(int n: nums){
        	res ^= n;
        }
        return res;
    }
    
    //check each pair and increment index by 2 , O(n)
    public int singleNonDuplicate(int[] nums) {
    	for(int i= 0; i<nums.length; i=i+2){
    		if(i== nums.length-1 || nums[i] != nums[i+1])
    			return nums[i];
    	}
    	return -1; // not found
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
