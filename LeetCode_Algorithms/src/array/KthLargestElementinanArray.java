package array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementinanArray {

	public int findKthLargest(int[] nums, int k) {
		if(nums.length == 0) return -1;
		int n = nums.length;
		quickSort(nums, 0, nums.length - 1);
		return nums[n-k];
	}

	public void quickSort(int[] a, int low, int high) {
		if(low >= high)
			return;
		int pivot = partition(a, low, high);
		quickSort(a ,low, pivot);
		quickSort(a ,pivot + 1, high);
	}

	private int partition(int[] a, int low, int high) {
		int p = a[(low + high) / 2];
		int i = low;
		int j = high;

		while(true) {
			while (a[i] < p)
				i++;
			while (a[j] > p)
				j--;
			if (i >= j) break;
			else {
				swap(a, i ,j);
				i++;
				j--;
			}

		}
		return j;
	}

	private void swap (int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	//using priority queue
    public int findKthLargest2(int[] nums, int k) {
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
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
		int[] a = new int[]{5,2,4,1,3,6,0};
		System.out.print(k.findKthLargest(a, 4));
	}

}
