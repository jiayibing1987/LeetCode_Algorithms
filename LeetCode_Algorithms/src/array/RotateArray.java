package array;

import java.util.Arrays;

/**
 * 189. Rotate Array
 * 
 * @author Ryan
 *
 */
public class RotateArray {

	// create a new array and move k elements first then other elements
	public void rotate1(int[] nums, int k) {
		if (nums.length <= 1 || k % nums.length <= 0)
			return;
		int[] temp = new int[nums.length];
		int p = nums.length - k % nums.length;
		for (int i = 0; i < nums.length; i++) {
			temp[i] = nums[p++];
			if (p >= nums.length)
				p = 0;
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = temp[i];
		}
	}

	public void rotate(int[] nums, int k) {
		k = k%nums.length;
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
	}

	public void reverse(int[] a, int start, int end) {
		while (start < end) {
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		RotateArray r = new RotateArray();
		r.rotate(a, 3);
		System.out.println(Arrays.toString(a));

	}

}
