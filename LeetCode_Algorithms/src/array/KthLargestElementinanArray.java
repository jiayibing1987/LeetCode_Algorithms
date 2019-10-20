package array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {
    	int low = 0;
    	int high = nums.length-1;
    	while(low < high){
    		int p = partition(nums, low, high);
    		if(p>k-1)
    			high = p-1; // search left sub-array
    		else if(p<k-1)
    			low = p+1; // search right sub-array
    		else
    			break;
    	}
    	return nums[k-1];
    }

    private int partition(int[] nums, int low, int high) {
    	int i = low-1;
    	int pivot = nums[high];
    	for(int j=low; j<=high-1; j++){
    		if(nums[j] < pivot){
    			i++;
    			int temp = nums[i];
    			nums[i] = nums[j];
    			nums[j] = temp;
    		}
    	}
    	int temp = nums[high];
    	nums[high] = nums[i+1];
    	nums[i+1] = temp;
    	return i+1;
	}

	//using priority queue
    public int findKthLargest2(int[] nums, int k) {
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    	for(Integer n : nums){
    		pq.offer(n);
    		if(pq.size() > k)
    			pq.poll();
    	}
    	return pq.peek();
    }
	
	//sort array and return k-th number
    public int findKthLargest1(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
    	Arrays.sort(nums);
    	return nums[nums.length - k]; 
    }
    
	public static void main(String[] args) {
		KthLargestElementinanArray k = new KthLargestElementinanArray();
		int[] a = new int[]{3,2,3,1,2,4,5,5,6};
		System.out.print(k.findKthLargest(a, 4));
	}

}
