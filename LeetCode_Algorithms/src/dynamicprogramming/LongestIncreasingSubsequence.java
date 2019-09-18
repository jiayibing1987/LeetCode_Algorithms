package dynamicprogramming;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * @author Ryan
 *
 */
public class LongestIncreasingSubsequence {

	
    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int max = 1;
        for(int i=0; i<nums.length; i++){
        	//for each index i, need pre value and cur value
        	int pre_length = 1;
        	int pre_value = nums[i];
        	int cur_length = pre_length;
        	int cur_value = pre_value;
        	for(int j=i+1; j<nums.length; j++){
        		//if nums[j] greater than cur value, means there is number to increase length of sequence
        		//cur value becomes pre value
        		//nums[j] is cur value and increase cur length + 1
        		if(nums[j] > cur_value){
        			pre_length = cur_length;
        			pre_value = cur_value;
        			cur_length++;
        			cur_value = nums[j];
        			//if pre value < nums[j] < cur value means, we can have another smaller value 
        			//which has same length of sequence. so update cur_value to nums[j]
        		}else if(nums[j]>pre_value && nums[j]<cur_value){
        			cur_value = nums[j];
        		}else{}//do nothing
        	}
        	max = Math.max(cur_length, max);
        }
        return max;
    }
    
    //if there is coming index i, if we just come all index j before i
    //if nums[i]>nums[j] means we can increase length of subsequence end at j 
    //compare all j from 0 to i-1 then pick the largest one.
    public int lengthOfLIS(int[] nums) {
    	if(nums.length == 0) return 0;
    	//dp[i] mean LIS until index i inclusively
    	int[] dp = new int[nums.length];
    	Arrays.fill(dp, 1);
    	int max = 1;
    	for(int i=1; i<nums.length; i++){
    		int cur_max = 1;
    		for(int j=0; j<i; j++){
    			if(nums[i]>nums[j]){
    				cur_max = Math.max(cur_max, dp[j]+1);
    			}
    		}
    		dp[i] = cur_max;
    		max = Math.max(max, dp[i]);
    	}
    	return max;
    }
    
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] a = {10,9,2,5,3,7,101,18};
		System.out.print(lis.lengthOfLIS(a));
	}

}
