package array;

import java.util.Stack;

/**
 * #42 Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * @author Ryan
 *
 */
public class TrappingRainWater {

	//using stack
	public int trap(int[] height) {
		Stack<Integer> s = new Stack<Integer>();
		int curIndex = 0;
		int res = 0;
		while(curIndex < height.length){
			while(!s.isEmpty() && height[curIndex]>height[s.peek()]){
				int top = s.pop();
				if(s.isEmpty()) break;
				int leftBound = s.peek();
				int distance = curIndex - leftBound -1;
				res += distance*(Math.min(height[curIndex], height[leftBound]) - height[top]);
			}
			s.push(curIndex);
			curIndex ++;
		}
		return res;
	}
	
	
	//solution 2, dp solution, optimized by solution1 with memory
	public int trap2(int[] height) {
		int[] dpLeft = new int[height.length];
		int[] dpRight = new int[height.length];
		int maxLeft = 0, maxRight = 0;
		
		for(int i=0; i<height.length; i++){
			maxLeft = Math.max(maxLeft, height[i]);
			dpLeft[i] = maxLeft;
		}
		for(int i=height.length-1; i>=0; i--){
			maxRight = Math.max(maxRight, height[i]);
			dpRight[i] = maxRight;
		}
		int res = 0;
		for(int i=0; i<height.length; i++){
			res += Math.min(dpLeft[i], dpRight[i]) - height[i];
		}
		return res;
	}
	
	//solution 1, brute force
	// For each element in the array, we find the maximum level of water it can trap after the rain,
	// which is equal to the minimum of maximum height of bars on both the sides minus its own height.
	public int trap1(int[] height) {
        int res = 0;
        for(int i=0; i<height.length; i++){
            int maxLeft = 0;
            int maxRight = 0;
        	//search from i to 0, get max left
        	for(int j=i; j>=0; j--){
        		maxLeft = Math.max(height[j], maxLeft);
        	}
        	for(int j=i; j<height.length; j++){
        		maxRight = Math.max(height[j], maxRight);
        	}
        	res += Math.min(maxLeft, maxRight) - height[i];
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
