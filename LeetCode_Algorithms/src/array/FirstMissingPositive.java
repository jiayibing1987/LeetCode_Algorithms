package array;

/**
 * #41 Given an unsorted integer array, find the smallest missing positive integer.
 * @author Ryan
 *
 */
public class FirstMissingPositive {

	//move all positive value to it's original index postion e.g.
	//move 2 to a[3], 4 to a[5]
	//finally array will be like[1,x,3,4], dont care about what x is 
	//return index of x + 1 is the result.
    public int firstMissingPositive(int[] nums) {
    	int n = nums.length;
    	for(int i=0; i<n; i++){
    		while(nums[i]>0 && nums[i]<=n && nums[i] != nums[nums[i]-1]){
    			swap(nums, i, nums[i]-1);
    		}
    	}
    	for(int i=0; i<n; i++){
    		if(nums[i] != i+1)
    			return i+1;
    	}
    	return n+1;
    }
    
    private void swap(int[] a, int i, int j){
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
    
	public static void main(String[] args) {
		FirstMissingPositive f = new FirstMissingPositive();
		int[] a = {1,2,0};
		int[] b = {3,4,-1,1};
		int[] c = {7,8,9,11,12};
		
		System.out.println(f.firstMissingPositive(a));
		System.out.println(f.firstMissingPositive(b));
		System.out.println(f.firstMissingPositive(c));
	}

}
