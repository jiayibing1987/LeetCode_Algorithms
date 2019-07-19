package twopointer;


/*
 * #27 Remove Element
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length-1;
        
        while(i<=j){
        	if(nums[j] == val){
        		nums[j] = 0;
        		j--;
        	}else{
        		if(nums[i] == val){
        			//swap
        			nums[i] = nums[j];
        			nums[j] = 0;
        			i++;
        			j--;
        		}else{        			
        			i++;	
        		}
        	}	
        }		
        return j+1;		
    }
    
	
	public static void main(String[] args) {
		RemoveElement r = new RemoveElement();
		int[] a1 = {3,2,2,3};
		int v1 = 3;
		System.out.println(r.removeElement(a1, v1));
		
		int[] a2 = {0,1,2,2,3,0,4,2};
		int v2 = 2;
		System.out.println(r.removeElement(a2, v2));
		
	}

}
