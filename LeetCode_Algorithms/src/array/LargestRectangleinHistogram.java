package array;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 * @author Ryan
 *
 */
public class LargestRectangleinHistogram {

	//3. dp with stack, for each heights[i], assume it is the smallest the number in it's rectangle
	//need to get "next" smaller number of left direction and right direction
	//area = (right - left - 1) * height
	public int largestRectangleArea(int[] heights) {
		if(heights == null || heights.length == 0)
			return 0;
		int n = heights.length;
		int[] left = new int[n];
		int[] right = new int[n];

		Stack<Integer> stack = new Stack<>();
		//using the stack to find the last number which smaller than heights[i]
		for(int i=0; i<n; i++) {
			while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				left[i] = -1;
			} else {
				left[i] = stack.peek();
			}
			stack.push(i);
		}

		stack.clear();
		//using the stack to find the next number which smaller than heights[i]
		for(int i=n-1; i>=0; i--) {
			while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				right[i] = n;
			} else {
				right[i] = stack.peek();
			}
			stack.push(i);
		}

		int maxArea = 0;
		for(int i=0; i<n; i++) {
			int area = (right[i] - left[i] - 1) * heights[i];
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}


	//1. brute force, O(n2)
    public int largestRectangleArea1(int[] heights) {
        int max = 0;
        for(int i=0; i<heights.length; i++){
        	int minHeight = Integer.MAX_VALUE;
        	for(int j=i; j<heights.length; j++){
        		minHeight = Math.min(minHeight, heights[j]);
        		int distance = j-i+1;
        		int area = distance * minHeight;
        		max = Math.max(max, area);
        	}
        }
        return max;
    }
    
    //2. divide and conquer
    //The idea is to find the minimum value in the given array. Once we have index of the minimum value, 
    //the max area is maximum of following three values.
    //a) Maximum area in left side of minimum value (Not including the min value)
    //b) Maximum area in right side of minimum value (Not including the min value)
    //c) Number of bars multiplied by minimum value.
    //recusively find the max area for each part
    public int largestRectangleArea2(int[] heights) {
    	return largestArea(heights, 0, heights.length-1);
    }
    
    private int largestArea(int[] heights, int low, int high){
    	if(low > high) return 0;
    	if(low == high) return heights[low];
    	int minIndex = findIndexOfMinimumValue(heights, low, high);
    	int areaWithMin = (high-low+1) * heights[minIndex];
    	int areaLeft = largestArea(heights, low, minIndex-1);
    	int areaRight = largestArea(heights, minIndex+1, high);

    	return Math.max(areaWithMin, Math.max(areaLeft, areaRight));
    }
    
    private int findIndexOfMinimumValue(int[] heights, int low, int high){
    	int minIndex = low;
    	for(int i=low; i<=high; i++)
    		if(heights[i] < heights[minIndex])
    			minIndex = i;
    	return minIndex;
    }
    
    
	public static void main(String[] args) {
		LargestRectangleinHistogram l = new LargestRectangleinHistogram();
		int[] a1 = new int[] {2,1,5,6,2,3};
		System.out.println(l.largestRectangleArea(a1));
	}

}
