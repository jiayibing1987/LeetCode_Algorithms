package array;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target,
 *  find three integers in nums such that the sum is closest to target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * @author Ryan
 *
 */
public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		int minDiff = Integer.MAX_VALUE;
		int result = 0 ;
		
		for(int i=0; i<n-2; i++){
			int low = i+1;
			int high = n-1;
			while (low < high){
				int sum = nums[i] + nums[low] + nums[high];
				int diff = target - sum;
				if(Math.abs(diff)< minDiff){
					result = sum;
					minDiff = Math.abs(diff);
				}
				//target>sum move low pointer get a larger number
				if(diff > 0)
					low++;
				//target<sum move high pointer get a smaller number
				else
					high--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ThreeSumClosest t = new ThreeSumClosest();
		int[] a = {-1, 2, 1, -4};
		System.out.println(t.threeSumClosest(a, 1));
		
		int[] b = {1,1,1,0};
		System.out.println(t.threeSumClosest(b, -100));
		
		int[] c = {-3,-2,-5,3,-4};
		System.out.println(t.threeSumClosest(c, -1));		
		
		int[] d = {0,2,1,-3};
		System.out.println(t.threeSumClosest(d, 1));		

		int[] e = {1,2,4,8,16,32,64,128};
		System.out.println(t.threeSumClosest(e, 82));		
	}

}
