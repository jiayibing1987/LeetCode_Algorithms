package twopointer;

/**
 * #11
 * @author Ryan
 *
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
    	int max = 0;
    	int left = 0;
    	int right = height.length-1;
    	
    	while(left<right){
    		int area = (right-left) * Math.min(height[left], height[right]);
    		max = Math.max(max, area);
    		if(height[left] < height[right]){
    			left++;
    		}else if(height[left] > height[right]){
    			right--;
    		}else{
    			left++;
    			right--;
    		}
    	}
    	return max;
    }
    
    
	public static void main(String[] args) {
		ContainerWithMostWater c = new ContainerWithMostWater();
		int[] a  = {1,8,6,2,5,4,8,3,7};
		System.out.println(c.maxArea(a));
	}

}
