package array;

/**
 * 84. Largest Rectangle in Histogram
 * @author Ryan
 *
 */
public class LargestRectangleinHistogram {

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
    public int largestRectangleArea(int[] heights) {
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
		// TODO Auto-generated method stub
	}

}
