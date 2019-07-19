package array;

import java.util.Arrays;

/**
 * 
 * #31
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 ¡ú 1,3,2
3,2,1 ¡ú 1,2,3
1,1,5 ¡ú 1,5,1
 * @author Ryan
 *
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
    	//search from right to left, find the first value that is smaller than it's right neighbor 
    	int left = -1;
    	for(int i=nums.length-2; i>=0; i--){
    		if(nums[i] < nums[i+1]){
    			left = i;
    			break;
    		}
    	}
    	//if not found, means it is that largest value of whole permutation, then sort whole array
    	if(left == -1){
    		Arrays.sort(nums);
    		return;
    	}
    	//find the smallest value after left index, then swap with left value
    	int min = Integer.MAX_VALUE;
    	int right = -1;
    	for(int i=left+1; i<nums.length; i++){
    		if(nums[i] < min && nums[i] > nums[left]){
    			min = nums[i];
    			right = i;
    		}
    	}
    	int temp = nums[left];
    	nums[left] = nums[right];
    	nums[right] = temp;
    	
    	//sort array after index left
    	Arrays.sort(nums, left+1, nums.length);
    }
    
	public static void main(String[] args) {
		NextPermutation n = new NextPermutation();
		int[] a = {1,2,3,4};
		int[] b = {1,3,4,2};
		int[] c = {1,4,3,2};
		int[] d = {4,3,2,1};
	
		n.nextPermutation(a);
		System.out.println(Arrays.toString(a));
		n.nextPermutation(b);
		System.out.println(Arrays.toString(b));
		n.nextPermutation(c);
		System.out.println(Arrays.toString(c));
		n.nextPermutation(d);
		System.out.println(Arrays.toString(d));
	}

}
