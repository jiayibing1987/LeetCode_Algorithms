package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class IntersectionofTwoArraysTwo {

	public int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> list = new ArrayList<Integer>();
		int n1 = nums1.length;
		int n2 = nums2.length;
		int i = 0;
		int j = 0;
		while (i < n1 && j < n2) {
			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		int[] result = new int[list.size()];
		Iterator<Integer> iterator = list.iterator();
		for(int k=0; k<result.length; k++){
			result[k] = (int) iterator.next();
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		IntersectionofTwoArraysTwo i = new IntersectionofTwoArraysTwo();
		System.out.println(Arrays.toString(i.intersection(nums1, nums2)));
	}

}
